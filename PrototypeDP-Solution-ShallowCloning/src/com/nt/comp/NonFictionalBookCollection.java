package com.nt.comp;

import java.util.ArrayList;
import java.util.List;

public class NonFictionalBookCollection extends BookCollection {
	
	public NonFictionalBookCollection() {
		System.out.println("NonFictionalBookCollection:: 0-param constructor");
	}

	@Override
	public void loadBooks() {
	  // u can write  DB code here..  to get books..	
			for(int i=1;i<=10;++i) {
			Book b=new Book();
			b.setId(i);
			b.setName("Non-Fictional-"+i);
			getBooks().add(b);
		}//for
	}//loadBooks

	@Override
	public String toString() {
		return "NonFinctionalBookCollection []"+super.toString();
	}

	
	

	
	
}
