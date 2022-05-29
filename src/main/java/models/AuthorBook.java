package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="authors_books")
public class AuthorBook {
	@Id
	@Column(name="authors_books_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "authors_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "books_id")
	private Book book;

	public AuthorBook() {
		this(0, null, null);
	}
	
	public AuthorBook(Author author, Book book) {
		super();
		this.author = author;
		this.book = book;
	}
	
	public AuthorBook(int id, Author author, Book book) {
		super();
		this.id = id;
		this.author = author;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "AuthorBook [id=" + id + ", author=" + author + ", book=" + book + "]";
	}
}
