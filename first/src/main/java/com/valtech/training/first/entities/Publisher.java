package com.valtech.training.first.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Publisher {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pub_seqs")
	private int id;
	private String name;
	
	@OneToMany(targetEntity = Book.class,mappedBy = "publisher",cascade = CascadeType.ALL,fetch =FetchType.EAGER)
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
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(String name) {
		super();
		this.name = name;
	}
	
	public void addBook(Book book) {
	//	if(books==null)books=new HashSet<>();
	}
	
	
	
	
}
