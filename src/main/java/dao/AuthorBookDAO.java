package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import models.Author;
import models.AuthorBook;
import models.Book;
import utils.HibernateUtil;

public class AuthorBookDAO {
	
	public static boolean save(List<Author> authors, Book book) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(book);
			for(Author author: authors) {
				session.persist(author);
				AuthorBook authorBook = new AuthorBook(author, book);
				session.persist(authorBook);
			}
			transaction.commit();
		} catch(Exception e) {
			System.out.println("AuthorBookDAO");
			System.out.println(e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	public static boolean save(List<String> authorNames, String bookName) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Book book = new Book(bookName, 100);
			session.persist(book);
			for(String name: authorNames) {
				Author author = new Author(name);
				session.persist(author);
				AuthorBook authorBook = new AuthorBook(author, book);
				session.persist(authorBook);
			}
			transaction.commit();
		} catch(Exception e) {
			System.out.println("AuthorBookDAO");
			System.out.println(e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	public static List<Book> getBooksByAuthor(String authorName) {
		return getBooksByAuthor(AuthorDAO.getAuthorByName(authorName));
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Book> getBooksByAuthor(Author author) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from AuthorBook ab where ab.author = :author");
		query.setParameter("author", author);
		List<AuthorBook> list = query.getResultList();
		session.close();
		List<Book> books = new ArrayList<>();
		for(AuthorBook ab: list)
			books.add(ab.getBook());
		return books;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Author> getAuthorsByBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from AuthorBook ab where ab.book = :book");
		query.setParameter("book", book);
		List<AuthorBook> list = query.getResultList();
		session.close();
		List<Author> authors = new ArrayList<>();
		for(AuthorBook ab: list)
			authors.add(ab.getAuthor());
		return authors;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<AuthorBook> getAuthorsBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
    		List<AuthorBook> list = session.createQuery("from AuthorBook").list();
    		session.close();
    		return list;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		session.close();
    	}
    	return null;
	}
}
