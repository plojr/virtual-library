package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import models.Book;
import utils.HibernateUtil;

public class BookDAO {
	
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
	
	@SuppressWarnings("deprecation")
	public static Book getBookByName(String bookName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Book book where book.name = :name");
			query.setParameter("name", bookName);
			@SuppressWarnings("unchecked")
			List<Book> books = query.getResultList();
			if(books.size() != 0) {
				session.close();
				return books.get(0);
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
	
	public static List<Book> getBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Book> books = session.createQuery("from Book").list();
    		if(books.size() != 0) {
	    		session.close();
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
