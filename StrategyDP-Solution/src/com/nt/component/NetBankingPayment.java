package com.nt.component;

public  final class NetBankingPayment  implements Payment {
	
	public   String doPayment(String  account, float amount) {
		return  amount+" of payment is done from the NetBanking "+account;
	}

}
