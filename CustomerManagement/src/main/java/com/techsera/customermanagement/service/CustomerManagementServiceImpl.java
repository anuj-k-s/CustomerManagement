package com.techsera.customermanagement.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techsera.customermanagement.exception.BuisnessException;
import com.techsera.customermanagement.models.Customer;
import com.techsera.customermanagement.models.entity.CustomerEntity;
import com.techsera.customermanagement.repository.CustomerManagementDao;
@Service
public class CustomerManagementServiceImpl implements CustomerManagementService{
	
	@Autowired
	private CustomerManagementDao customerManagementDao;
	
	@Override
	public List<CustomerEntity> getCustomerData() {
		List<CustomerEntity> customerEntities =  customerManagementDao.findAll();
		if(customerEntities.isEmpty()) {
			throw new BuisnessException(new Timestamp(System.currentTimeMillis()), "No Data Found");
		}
		return customerEntities;
	}

	@Override
	@Transactional
	public CustomerEntity saveCustomerDetails(Customer customer) {
		checkCustomerData(customer);
		CustomerEntity entity = new CustomerEntity();
		entity.setAddress(customer.getAddress());
		entity.setContactNo(customer.getContactNo());
		entity.setEmail(customer.getEmail());
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		return customerManagementDao.save(entity);
	}

	private void checkCustomerData(Customer customer) {
		if(!customer.getEmail().contains("@techsera")) {
			throw new BuisnessException(new Timestamp(System.currentTimeMillis()), "Invalid email Id");
		}
		if(null == customer.getAddress() || 0 == customer.getContactNo() || null ==customer.getFirstName() || null == customer.getLastName() ) {
			throw new BuisnessException(new Timestamp(System.currentTimeMillis()), "Invalid Customer Data");
		}
		
	}

	@Override
	public void deleteCustomer(Long id) {
		customerManagementDao.deleteById(id);
		
	}

	@Override
	public CustomerEntity updateCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		checkCustomerData(customer);
		CustomerEntity entity = null;
		if(customerManagementDao.existsById(customer.getCustomerId())) {
			entity  = customerManagementDao.getOne(customer.getCustomerId());
			entity.setAddress(customer.getAddress());
			entity.setContactNo(customer.getContactNo());
			entity.setEmail(customer.getEmail());
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
			entity =  customerManagementDao.save(entity);
		}else {
			throw new BuisnessException(new Timestamp(System.currentTimeMillis()), "User Doesn't Exists");
		}
		return entity;
	}

}
