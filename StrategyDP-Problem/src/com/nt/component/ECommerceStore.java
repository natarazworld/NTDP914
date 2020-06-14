package com.nt.component;

import java.util.Random;

public class ECommerceStore {
  private UPIPayment payment;


  public void setPayment(UPIPayment payment) {
	this.payment = payment;
  }

  
	
	public   String  shopping(String items[],float prices[],String account) {
		 float billAmount=0.0f;
		 String paymentMsg=null;
		//calc bill Amout
		 for(float price:prices) {
			 billAmount=billAmount+price;
		 }
		 //do payment
		 paymentMsg=payment.doPayment(account, billAmount);
		 return new Random().nextInt(100000)+ " Bill No Bill Amount is "+billAmount+"----->"+paymentMsg;
		 
		
	}
	
}
