package models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	public Date getDate() {
		return finishDate;
	}
	public void setDate(Date date) {
		this.finishDate = date;
	}
	@Override
	public String toString() {
		String finishDateText = (finishDate == null ? "Not read yet" : DateConverter.convertDateToString(getDate()));
		return "Books [id=" + id + ", name=" + name + ", numberOfPages=" + numberOfPages + ", date=" + finishDateText + "]";
	}
	
}
