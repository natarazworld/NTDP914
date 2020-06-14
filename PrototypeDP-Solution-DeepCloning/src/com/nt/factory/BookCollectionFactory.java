package com.nt.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nt.comp.Book;
import com.nt.comp.BookCollection;
import com.nt.comp.FictionalBookCollection;
import com.nt.comp.NonFictionalBookCollection;

public class BookCollectionFactory {
	private static  Map<String,BookCollection> cacheMap=new HashMap();
	static {
		BookCollection collection1=null,collection2=null;
		
		collection1=new FictionalBookCollection();
		collection1.setBookType("fictional");
		collection1.loadBooks();
		collection2=new NonFictionalBookCollection();
		 collection2.setBookType("non-fictional");
		collection2.loadBooks();
		cacheMap.put("fictional", collection1);
		cacheMap.put("non-fictional",collection2);
		System.out.println("..........................................");
	}
	
	public static  BookCollection  getInstance(String collectionType) throws Exception{
		  BookCollection  original=null, cloned=null;
		  List<Book> clist=null;
		  Book  cb=null;
		  //gives orginal object
		  original=cacheMap.get(collectionType);
		   //gives cloned object
		  cloned=(BookCollection)original.clone();
		  clist=new ArrayList();
		  for(Book ob:original.getBooks()) {
			    cb=(Book) ob.clone();
			    //cb=new Book();
			    cb.setId(ob.getId());
			    cb.setName(ob.getName());
			    clist.add(cb);
		  }
		  
		  cloned.setBookType(original.getBookType());
		  cloned.setBooks( clist);
		  return cloned;
	}

}
