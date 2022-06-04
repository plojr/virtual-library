# www.skoob.com.br is a virtual library where you can insert information about the books you've
# already read or you're about to read, so the application can give you much information.
# This script is intended for you to download the information about a book and insert it
# into the database

# This script has two actual methods: one for download the data and another for inserting the data into the database.
# Given its simplicity, I won't split it into more files.

# You're going to use the script that way:
# python3 download_from_skoob.py skoob_url
# Example: python3 download_from_skoob.py https://www.skoob.com.br/por-que-os-generalistas-vencem-em-um-mundo-de-especialistas-1132649ed1136195.html

# In order to connect into the PostgreSQL database, you need to set the environment variable POSTGRESQL_DATABASE for the database,
# POSTGRESQL_USER for the user and POSTGRESQL_PASSWORD for the password.

import requests as rq
from bs4 import BeautifulSoup
import json
import psycopg2
import sys
import os

def download_data(url):
	print("Downloading", url)
	headers = {
		'authority': 'www.skoob.com.br',
		'upgrade-insecure-requests': '1',
		'user-agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML,like Gecko) Chrome/89.0.4389.90 Safari/537.36',
		'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
		'sec-fetch-site': 'same-origin',
		'sec-fetch-mode': 'navigate',
		'sec-fetch-user': '?1',
		'sec-fetch-dest': 'document',
		'referer': 'https://www.skoob.com.br/por-que-os-generalistas-vencem-em-um-mundo-de-especialistas-1132649ed1136195.html',
		'accept-language': 'en-US,en;q=0.9',
		'cookie': 'PHPSESSID=kkc5p39bptgdhb9kndej18esn2; __utma=33443132.965599740.1628687078.1628687078.1628687078.1; __utmc=33443132; __utmz=33443132.1628687078.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; user_is_logged=0; user_logged=null; __asc=00ae163717b3550aa9fdda9b521; __auc=00ae163717b3550aa9fdda9b521; __gads=ID=6eb2926efc6eb83b:T=1628687084:S=ALNI_MYAm4vNHosOJtZMR-JHV07-3lqrow; __utmb=33443132.2.10.1628687078'
	}
	pagina = rq.get(url, headers = headers)
	soup = BeautifulSoup(pagina.text, 'html.parser')
	info = soup.find('script', {'type':'application/ld+json'}).text
	js = json.loads(info)
	entidade_principal = js['mainEntity']
	ret = {}
	if entidade_principal['numberOfPages'] != None:
		ret['number_of_pages'] = entidade_principal['numberOfPages']
	else:
		ret['number_of_pages'] = 0
	if entidade_principal['name'] != None:
		ret['book_name'] = entidade_principal['name']
	else:
		ret['book_name'] = ''
	nome_autor = soup.find('i', {'class':"sidebar-subtitulo"})
	if nome_autor != None:
		ret['author_name'] = nome_autor.text
	else:
		nome_autor = soup.find_all('a', href=True)
		for el in nome_autor:
			if el['href'].find("autor") != -1 and el['href'].find("recentes") == -1  and el['href'].find("checar") == -1 and str(el).find("livro-autor-foto") == -1:
				ret['author_name'] = el.text
				break
	return ret

def insert_data(book_name, author_name, number_of_pages):
    conn = psycopg2.connect(
        host = "localhost",
		database = os.environ["POSTGRESQL_DATABASE"],
		user = os.environ["POSTGRESQL_USER"],
		password = os.environ["POSTGRESQL_PASSWORD"],
        options='-c search_path=library'
	)
    cursor = conn.cursor()
    
    author_query_select = "SELECT id FROM authors WHERE name = %s"
    cursor.execute(author_query_select, (author_name,))
    fetch = cursor.fetchone()
    if fetch is not None:
        author_id = fetch[0]
    else:
        author_query_insert = "INSERT INTO authors (name) VALUES (%s)"
        cursor.execute(author_query_insert, (author_name,))
        cursor.execute('SELECT LASTVAL()')
        author_id = cursor.fetchone()[0]
    
    book_query = "INSERT INTO books (name, number_of_pages) VALUES (%s, %s)"
    cursor.execute(book_query, (book_name, number_of_pages))
    cursor.execute('SELECT LASTVAL()')
    book_id = cursor.fetchone()[0]

    author_book_query = "INSERT INTO authors_books (authors_id, books_id) VALUES (%s, %s)"
    cursor.execute(author_book_query, (author_id, book_id,))
    conn.commit()

def main():
    url = sys.argv[1]
    dados = download_data(url)
    insert_data(dados['book_name'], dados['author_name'], dados['number_of_pages'])
    print("Added successfully: book's name: " + dados['book_name'], " author's name: " + dados['author_name'], " number of page: " + dados['number_of_pages'], sep=',')

main()