package com.nt.component;

public  final class CreditCardPayment  implements Payment {
	
	public   String doPayment(String  account, float amount) {
		return  amount+" of payment is done from the Credit Account "+account;
	}

}
