package com.nt.test;

import com.nt.comp.BookCollection;
import com.nt.factory.BookCollectionFactory;

public class PrototypeSolutionTest {

	public static void main(String[] args)throws Exception {
		BookCollection collection1=null,collection2=null,collection3=null,collection4=null;
		collection1=BookCollectionFactory.getInstance("fictional");
		collection1.getBooks().get(0).setName("horror");
		System.out.println(collection1);
		System.out.println("..........................................");
		collection2=BookCollectionFactory.getInstance("fictional");
		System.out.println(collection2);  // here second time Book class, FictionalBookCollection objs  are created from scratch level
		System.out.println("===========================================");
		collection3=BookCollectionFactory.getInstance("non-fictional");
		System.out.println(collection3);
		System.out.println("..........................................");
		collection4=BookCollectionFactory.getInstance("non-fictional");  
		System.out.println(collection4); // here second time Book class, NonFictionalBookCollection objs are  created from scratch level


	}

}
