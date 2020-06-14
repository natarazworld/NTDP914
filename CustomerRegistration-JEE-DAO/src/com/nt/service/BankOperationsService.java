package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface BankOperationsService {
    public  String registerCustomer(CustomerDTO dto)throws Exception;
}
