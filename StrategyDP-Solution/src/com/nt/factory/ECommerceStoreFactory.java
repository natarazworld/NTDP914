package com.nt.factory;

import com.nt.component.CreditCardPayment;
import com.nt.component.DebitCardPayment;
import com.nt.component.ECommerceStore;
import com.nt.component.NetBankingPayment;
import com.nt.component.Payment;
import com.nt.component.UPIPayment;

public final class ECommerceStoreFactory {
	
	public  static  ECommerceStore   getInstance(String paymentType) {
		Payment payment=null;
		ECommerceStore store=null;
	    store=new ECommerceStore();
	    if(paymentType.equalsIgnoreCase("UPI"))
	    	payment=new UPIPayment();
	    else if(paymentType.equalsIgnoreCase("DEBIT"))
	    	payment=new DebitCardPayment();
	    else if(paymentType.equalsIgnoreCase("CREDIT"))
	    	payment=new CreditCardPayment();
	    else if(paymentType.equalsIgnoreCase("netBanking"))
	    	payment= new NetBankingPayment();
	    else
	    	throw new IllegalArgumentException("invalid Payment type");
	    //set dependent to target
	    store.setPayment(payment);
	    return store;
	    	
	}

}
