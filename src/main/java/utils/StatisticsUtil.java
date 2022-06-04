package utils;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import dao.BookDAO;
import models.Book;

public class StatisticsUtil {

	List<Book> books;
	public StatisticsUtil() {
		books = BookDAO.getBooks();
	}
	
	// Count number of books that have a finish date assigned to it.
	public int getTotalNumberOfReadBooks() {
		int total = 0;
		for(Book book: books)
			if(book.getFinishDate() != null)
				total++;
		return total;
	}
	
	// Count the number of read books by year.
	public TreeMap<Integer, Integer> getNumberOfReadBooksByYear() {
		TreeMap<Integer, Integer> readBooks = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if(a < b) return 1;
				if(a > b) return -1;
				return 0;
			}
		});
		for(Book book: books) {
			// If the finish date is null, then the book was not read yet. It must continue.
			if(book.getFinishDate() == null) continue;
			// Count only if the finish date is not null
			int year = DateUtils.getYear(book.getFinishDate());
			// If get(year) equals null, then the value must be 1
			if(readBooks.get(year) == null)
				readBooks.put(year, 1);
			else // Else, just increment it
				readBooks.put(year, readBooks.get(year)+1);
		}
		return readBooks;
	}
	
	// Count the number of read pages by year.
	public TreeMap<Integer, Integer> getNumberOfReadPagesByYear() {
		TreeMap<Integer, Integer> readBooks = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if(a < b) return 1;
				if(a > b) return -1;
				return 0;
			}
		});
		for(Book book: books) {
			// If the finish date is null, then the book was not read yet. It must continue.
			if(book.getFinishDate() == null) continue;
			// Count only if the finish date is not null
			int year = DateUtils.getYear(book.getFinishDate());
			// If get(year) equals null, then the value must be 1
			if(readBooks.get(year) == null)
				readBooks.put(year, book.getNumberOfPages());
			else // Else, just increment it
				readBooks.put(year, readBooks.get(year) + book.getNumberOfPages());
		}
		return readBooks;
	}
	
	// Count the number of read books by month and year.
	// TreeMap's key has format of "month/year"
	public TreeMap<String, Integer> getNumberOfReadBooksByMonthYear() {
		// The comparator method is intended for sort the TreeMap only by the year part.
		// That is: if the key is April/2022, I want to compare using only 2022.
		TreeMap<String, Integer> readBooks = new TreeMap<>(new Comparator<String>(){
		    public int compare(String o1, String o2) {
		    	String monthYear1[] = o1.split("/"), monthYear2[] = o2.split("/");
		    	int month1 = DateUtils.convertMonthNameToInt(monthYear1[0]);
		        int year1 = Integer.parseInt(monthYear1[1]);
		        int month2 = DateUtils.convertMonthNameToInt(monthYear2[0]);
		        int year2 = Integer.parseInt(monthYear2[1]);
		        // Sort by year first, then by month (both by descending order).
		        if(year1 > year2) return -1;
		        if(year1 < year2) return 1;
		        if(month1 > month2) return -1;
		        if(month1 < month2) return 1;
		        return 0;
		    }
		});
		for(Book book: books) {
			// If the finish date is null, then the book was not read yet. It must continue.
			if(book.getFinishDate() == null) continue;
			// Count only if the finish date is not null
			String monthYear = DateUtils.getMonthYear(book.getFinishDate());
			// If get(year) equals null, then the value must be 1
			if(readBooks.get(monthYear) == null)
				readBooks.put(monthYear, 1);
			else // Else, just increment it
				readBooks.put(monthYear, readBooks.get(monthYear)+1);
		}
		return readBooks;
	}
	
	// Count the number of read pages by month and year.
	// TreeMap's key has format of "month/year"
	public TreeMap<String, Integer> getNumberOfReadPagesByMonthYear() {
		// The comparator method is intended for sort the TreeMap only by the year part.
		// That is: if the key is April/2022, I want to compare using only 2022.
		TreeMap<String, Integer> readBooks = new TreeMap<>(new Comparator<String>(){
		    public int compare(String o1, String o2) {
		    	String monthYear1[] = o1.split("/"), monthYear2[] = o2.split("/");
		    	int month1 = DateUtils.convertMonthNameToInt(monthYear1[0]);
		        int year1 = Integer.parseInt(monthYear1[1]);
		        int month2 = DateUtils.convertMonthNameToInt(monthYear2[0]);
		        int year2 = Integer.parseInt(monthYear2[1]);
		        // Sort by year first, then by month (both by descending order).
		        if(year1 > year2) return -1;
		        if(year1 < year2) return 1;
		        if(month1 > month2) return -1;
		        if(month1 < month2) return 1;
		        return 0;
		    }
		});
		for(Book book: books) {
			// If the finish date is null, then the book was not read yet. It must continue.
			if(book.getFinishDate() == null) continue;
			// Count only if the finish date is not null
			String monthYear = DateUtils.getMonthYear(book.getFinishDate());
			// If get(year) equals null, then the value must be 1
			if(readBooks.get(monthYear) == null)
				readBooks.put(monthYear, book.getNumberOfPages());
			else // Else, just increment it
				readBooks.put(monthYear, readBooks.get(monthYear) + book.getNumberOfPages());
		}
		return readBooks;
	}
	
}
