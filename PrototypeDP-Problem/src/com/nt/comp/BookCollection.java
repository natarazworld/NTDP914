package com.nt.comp;

import java.util.ArrayList;
import java.util.List;

public abstract class BookCollection {
	private String bookType;
	private  List<Book>  books=new ArrayList();
	
	public BookCollection() {
		System.out.println("BookCollection:: 0-param constructor");
	}
	
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public abstract void loadBooks();
	
	@Override
	public String toString() {
		return "BookCollection [bookType=" + bookType + ", books=" + books + "]";
	}

}
