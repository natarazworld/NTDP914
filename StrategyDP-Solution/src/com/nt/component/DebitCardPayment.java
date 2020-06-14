package com.nt.component;

public  final class DebitCardPayment  implements Payment {
	
	public   String doPayment(String  account, float amount) {
		return  amount+" of payment is done from the DebitCard Account "+account;
	}

}
