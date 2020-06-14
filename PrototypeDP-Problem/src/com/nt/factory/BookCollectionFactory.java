package com.nt.factory;

import com.nt.comp.BookCollection;
import com.nt.comp.FictionalBookCollection;
import com.nt.comp.NonFictionalBookCollection;

public class BookCollectionFactory {
	
	public static  BookCollection  getInstance(String collectionType) {
		    BookCollection collection=null;
		     if(collectionType.equalsIgnoreCase("fictional")) {
		    	 collection=new FictionalBookCollection();
		    	 collection.loadBooks();
		     }
		     else if(collectionType.equalsIgnoreCase("non-fictional")) {
		    	 collection=new NonFictionalBookCollection();
		    	 collection.loadBooks();
		     }
		     else {
		    	 throw new IllegalArgumentException("invalid Collection type");
		     }
		     return collection;
	}

}
