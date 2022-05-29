package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import models.Author;
import utils.HibernateUtil;

public class AuthorDAO {
	
	public static boolean update(String name) {
		Author author = getAuthorByName(name);
		Session session = null;
		Transaction transaction = null;
		author = new Author(name);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(author);
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
	
	public static int save(String name) {
		Author author = getAuthorByName(name);
		if(author != null) return author.getId();
		Session session = null;
		Transaction transaction = null;
		author = new Author(name);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(author);
			session.flush();
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			session.close();
			return -1;
		} finally {
			session.close();
		}
		return author.getId();
	}
	
	@SuppressWarnings("deprecation")
	public static Author getAuthorByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Author author where author.name = :name");
			query.setParameter("name", name);
			@SuppressWarnings("unchecked")
			List<Author> authors = query.getResultList();
			if(authors.size() != 0) {
				session.close();
				return authors.get(0);
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
	public static List<Author> getAuthors() {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
    		List<Author> authors = session.createQuery("from Author").list();
    		session.close();
    		return authors;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
	}
}
