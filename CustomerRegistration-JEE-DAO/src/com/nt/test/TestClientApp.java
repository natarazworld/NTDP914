package com.nt.test;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nt.dto.CustomerDTO;
import com.nt.service.BankOperationsService;
import com.nt.service.BankOperationsServiceImpl;

public class TestClientApp {
	private static  Logger logger=Logger.getLogger(TestClientApp.class);
	static {
		try {
			PropertyConfigurator.configure("src/com/nt/commons/log4j.properties");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc=null;
		String name=null,addrs=null;
		float pAmt=0.0f ,rate=0.0f , time=0.0f;
		CustomerDTO dto=null;
		BankOperationsService service=null;
		String result=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter customer name::");
			name=sc.next();
			System.out.println("Enter Customer address");
			addrs=sc.next();
			System.out.println("Enter Priciple amount");
			pAmt=sc.nextFloat();
			System.out.println("Enter Rate of intrest");
			rate=sc.nextFloat();
			System.out.println("enter time (in months)");
			time=sc.nextFloat();
			logger.debug("inputs are read from  client");
			//prepare DTO
			dto=new CustomerDTO();
			dto.setCname(name); dto.setCadd(addrs); 
			dto.setpAmt(pAmt); dto.setRate(rate); dto.setTime(time);
			logger.debug("inputs are stored in to DTO");
			//get Service class object
		    service=new BankOperationsServiceImpl();
		    try {
		    	result=service.registerCustomer(dto);
		    	System.out.println(result);
		    	logger.info("Service class b.method is called");
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    	logger.fatal("problem in calling service class method");
		    }

	}//main
}//class
