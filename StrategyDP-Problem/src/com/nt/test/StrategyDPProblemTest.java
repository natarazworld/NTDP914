package com.nt.test;

import com.nt.component.ECommerceStore;
import com.nt.factory.ECommerceStoreFactory;

public class StrategyDPProblemTest {

	public static void main(String[] args) {
		ECommerceStore store=null;
		String msg=null;
		//get Ecommerce Store
		store=ECommerceStoreFactory.getInstance();
		//invoke method
		msg=store.shopping(new String[] {"shirt","pant","shoe"},new float[] {3000,5000,2000}, "45673");
		System.out.println(msg);		

	}

}
