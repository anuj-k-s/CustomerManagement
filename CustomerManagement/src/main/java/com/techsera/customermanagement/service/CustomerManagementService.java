package com.techsera.customermanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.techsera.customermanagement.models.Customer;
import com.techsera.customermanagement.models.entity.CustomerEntity;

public interface CustomerManagementService {

	public List<CustomerEntity> getCustomerData();

	public CustomerEntity saveCustomerDetails(Customer customer);

	public void deleteCustomer(Long id);

	public CustomerEntity updateCustomerDetails(Customer customer);

}
