package com.valtech.training.first.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Book {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_seq")
	@SequenceGenerator(name = "book_seq",sequenceName = "bookseq",allocationSize = 1)
	private int id;
	private String name ;
	
	private int year;
	
	private int price;
	
	
	@ManyToOne(targetEntity = Publisher.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "publisher_id",referencedColumnName = "id")
	private Publisher  publisher;
	@ManyToMany(targetEntity = Author.class,fetch = FetchType.LAZY)
	@JoinTable(name="book_author",
				joinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"))
	Set<Author> authors;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Book(int id, String name, int year, int price, Publisher publisher, Set<Author> authors) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.price = price;
		this.publisher = publisher;
		this.authors = authors;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addAuthor(Author a) {
		if(authors==null)authors=new HashSet<>();
			authors.add(a);
		if(a.getBooks()==null)a.setBooks(new HashSet<>());
		a.getBooks().add(this);
		
	}
	
	public void removeAuthor(Author a) {
		authors.remove(a);
		a.getBooks().remove(this);
	}
	
}
