package com.valtech.training.first.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_seq")
	@SequenceGenerator(name = "author_seq",sequenceName = "authorseq")
	private int id;
	private String name;
	private String address;
	@ManyToMany(targetEntity = Book.class, fetch =FetchType.LAZY,mappedBy = "authors")

	Set<Book> books;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Author(int id, String name, String address, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.books = books;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addBook(Book book) {
		if(books==null)books=new HashSet<Book>();
		books.add(book);
		book.getAuthors().add(this);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
		book.getAuthors().remove(this);
	}
	
	

}
