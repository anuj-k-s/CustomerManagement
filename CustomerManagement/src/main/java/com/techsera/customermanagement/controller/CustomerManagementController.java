package com.techsera.customermanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsera.customermanagement.models.Customer;
import com.techsera.customermanagement.models.entity.CustomerEntity;
import com.techsera.customermanagement.service.CustomerManagementService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/techsera")
public class CustomerManagementController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerManagementController.class);

	@Autowired
	private CustomerManagementService customerManagementService;

	@GetMapping("/customer")
	public ResponseEntity<List<CustomerEntity>> getCustomersData() {
		logger.info("Entering into getCustomersData at {}", System.currentTimeMillis());
		try {
			return new ResponseEntity<List<CustomerEntity>>(customerManagementService.getCustomerData(), HttpStatus.OK);
		} finally {
			logger.info("Exiting from getCustomersData at {}", System.currentTimeMillis());
		}
	}

	@PostMapping("/customer")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody Customer customer) {
		logger.info("Entering into addCustomer at {}", System.currentTimeMillis());
		try {
			return new ResponseEntity<CustomerEntity>(customerManagementService.saveCustomerDetails(customer),
					HttpStatus.CREATED);
		} finally {
			logger.info("Exiting from addCustomer at {}", System.currentTimeMillis());
		}
	}

	@PutMapping("/customer")
	public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody Customer customer) {
		logger.info("Entering into updateCustomer at {}", System.currentTimeMillis());
		try {
			return new ResponseEntity<CustomerEntity>(customerManagementService.updateCustomerDetails(customer),
					HttpStatus.CREATED);
		} finally {
			logger.info("Exiting from updateCustomer at {}", System.currentTimeMillis());
		}

	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<CustomerEntity> deleteCustomer(@PathVariable Long id) {
		logger.info("Entering into deleteCustomer at {}", System.currentTimeMillis());
		try {
			customerManagementService.deleteCustomer(id);
			return new ResponseEntity<CustomerEntity>(HttpStatus.ACCEPTED);
		} finally {
			logger.info("Exiting from deleteCustomer at {}", System.currentTimeMillis());
		}
	}
}
