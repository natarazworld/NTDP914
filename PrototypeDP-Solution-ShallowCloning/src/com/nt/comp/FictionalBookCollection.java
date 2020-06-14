package com.nt.comp;

import java.util.ArrayList;
import java.util.List;

public class FictionalBookCollection extends BookCollection {
	
	public FictionalBookCollection() {
		System.out.println("FictionalBookCollection:: 0-param constructor");
	}

	@Override
	public void loadBooks() {
		List<Book> list=null;
	  // u can write  DB code here..  to get books..	
		list=new ArrayList();
			for(int i=1;i<=10;++i) {
			Book b=new Book();
			b.setId(i);
			b.setName("Fictional-"+i);
			getBooks().add(b);
		}//for
	}//loadBooks

	
	@Override
	public String toString() {
		return "FinctionalBookCollection []"+super.toString();
	}

	
	
}
