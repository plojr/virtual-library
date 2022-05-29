package main;

import java.util.List;

import dao.AuthorDAO;
import models.Author;

public class App {
    public static void main( String[] args ) {
    	/*
    	Author author = AuthorDAO.getAuthorByName("Donald Knuth");
    	System.out.println(author);
    	
    	*/
    	List<Author> authors = AuthorDAO.getAuthors();
    	for(Author localAuthor: authors)
    		System.out.println(localAuthor);
    	
    	
    	/*
    	List<Book> books = BookDAO.getBooks();
    	for(Book book: books)
    		System.out.println(book);
    	
    	
    	List<AuthorBook> authorsBooks = AuthorBookDAO.getAuthorsBooks();
    	for(AuthorBook ab: authorsBooks)
    		System.out.println(ab);
    	
    	
    	List<Book> books2 = AuthorBookDAO.getBooksFromAuthor("Donald Knuth");
    	for(Book book: books2)
    		System.out.println(book);
    	
    	
    	int idAuthor = AuthorDAO.save("d");
    	System.out.println(idAuthor);
    	
    	
    	int idBook = BookDAO.save(new Book("Fake book v.6", 100, null));
    	System.out.println(idBook);
    	
    	
    	String name1 = "Pedro a";
    	String name2 = "Pedro b";
    	String name3 = "Pedro c";
    	String bookName = "Fake book v.d";
    	List<String> names = new ArrayList<String>();
    	names.add(name1);
    	names.add(name2);
    	names.add(name3);
    	boolean save = AuthorBookDAO.save(names, bookName);
    	System.out.println(save);
    	*/
    	/*
    	String bookName2 = "Fake book v.d";
    	Book book = BookDAO.getBookByName(bookName2);
    	System.out.println(book);
    	book.setDate(DateConverter.convertStringToDate("2022-05-22"));
    	BookDAO.update(book);
    	System.out.println(book);
    	*/
    }
}
