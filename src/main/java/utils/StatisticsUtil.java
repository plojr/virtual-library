package utils;

import java.util.HashMap;
import java.util.List;

import dao.BookDAO;
import models.Book;

public class StatisticsUtil {

	List<Book> books;
	public StatisticsUtil() {
		books = BookDAO.getBooks();
	}
	
	public int getTotalNumberOfReadBooks() {
		int total = 0;
		for(Book book: books)
			if(book.getFinishDate() != null)
				total++;
		return total;
	}
	
	public HashMap<Integer, Integer> getNumberOfReadBooksByYear() {
		HashMap<Integer, Integer> readBooks = new HashMap<>();
		
		return readBooks;
	}
	
	public HashMap<Integer, Integer> getNumberOfReadBooksByMonth() {
		HashMap<Integer, Integer> readBooks = new HashMap<>();
		
		return readBooks;
	}
}
