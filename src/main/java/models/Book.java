package models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import utils.DateConverter;

@Entity
@Table(name= "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="number_of_pages")
	private int numberOfPages;
	
	@Column(name="finish_date")
	private Date finishDate;
	
	@Transient
	private List<Author> authors;
	
	public Book() {
		this.id = 0;
		this.name = null;
		this.numberOfPages = 0;
		this.finishDate = null;
	}
	
	public Book(String name, int numberOfPages) {
		this(name, numberOfPages, null);
	}
	
	public Book(String name, int numberOfPages, Date date) {
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.finishDate = date;
	}
	
	public Book(int id, String name, int numberOfPages, Date date) {
		this.id = id;
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.finishDate = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date date) {
		this.finishDate = date;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public String getAuthorsString() {
		StringBuffer sb = new StringBuffer();
		for(Author author: authors)
			sb.append(author.getName() + ", ");
		if(authors.size() == 0)
			return "-";
		return sb.toString().substring(0, sb.length()-2);
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	@Override
	public String toString() {
		String finishDateText = (finishDate == null ? "Not read yet" : DateConverter.convertDateToString(getFinishDate()));
		return "Books [id=" + id + ", name=" + name + ", numberOfPages=" + numberOfPages + ", date=" + finishDateText + "]";
	}
	
}
