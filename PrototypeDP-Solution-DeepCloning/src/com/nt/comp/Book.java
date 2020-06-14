package com.nt.comp;

public class Book implements Cloneable {
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
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	 
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

	 
}
