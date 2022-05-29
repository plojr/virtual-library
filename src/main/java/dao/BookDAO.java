package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import models.Book;
import utils.HibernateUtil;

public class BookDAO {
	
	@SuppressWarnings("deprecation")
	public static boolean update(Book book) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(book);
			session.flush();
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			session.close();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	public static int save(Book book) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(book);
			session.flush();
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			session.close();
			return -1;
		} finally {
			session.close();
		}
		return book.getId();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Book getBookByName(String bookName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Book book where book.name = :name");
			query.setParameter("name", bookName);
			List<Book> books = query.getResultList();
			if(books.size() != 0) {
				session.close();
				Book book = books.get(0);
				book.setAuthors(AuthorBookDAO.getAuthorsByBook(book));
				return book;
			}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		session.close();
    	}
    	return null;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Book> getBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
			List<Book> books = session.createQuery("from Book").list();
    		if(books.size() != 0) {
	    		session.close();
	    		for(Book book: books)
	    			book.setAuthors(AuthorBookDAO.getAuthorsByBook(book));
	    		return books;
    		}
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
