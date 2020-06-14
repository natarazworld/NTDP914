package com.nt.component;

public final class UPIPayment  implements Payment {
	
	public   String doPayment(String  account, float amount) {
		return  amount+" of payment is done for the upi account "+account;
	}

}
