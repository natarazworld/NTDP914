package com.nt.comp;

public class Book {
	private int id;
	private String name;
	
	public Book() {
		System.out.println("Book:: 0-param constructor");
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

	 
}
