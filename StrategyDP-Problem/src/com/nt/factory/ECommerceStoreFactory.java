package com.nt.factory;

import com.nt.component.ECommerceStore;
import com.nt.component.UPIPayment;

public class ECommerceStoreFactory {
	
	public  static  ECommerceStore   getInstance() {
		UPIPayment payment=null;
		ECommerceStore store=null;
		payment=new UPIPayment();
		store=new ECommerceStore();
		store.setPayment(payment);
		return store;
	}

}
