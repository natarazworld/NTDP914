package com.nt.factory;

import java.util.HashMap;
import java.util.Map;

import com.nt.comp.BookCollection;
import com.nt.comp.FictionalBookCollection;
import com.nt.comp.NonFictionalBookCollection;

public class BookCollectionFactory {
	private static  Map<String,BookCollection> cacheMap=new HashMap();
	static {
		BookCollection collection1=null,collection2=null;
		
		collection1=new FictionalBookCollection();
		collection1.loadBooks();
		collection2=new NonFictionalBookCollection();
		collection2.loadBooks();
		cacheMap.put("fictional", collection1);
		cacheMap.put("non-fictional",collection2);
		
	}
	
	public static  BookCollection  getInstance(String collectionType) throws Exception{
		   return  (BookCollection) cacheMap.get(collectionType).clone();  //shallow cloning
	}

}
