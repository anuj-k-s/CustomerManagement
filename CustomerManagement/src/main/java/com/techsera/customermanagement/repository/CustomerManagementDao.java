package com.techsera.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techsera.customermanagement.models.entity.CustomerEntity;

@Repository
public interface CustomerManagementDao extends JpaRepository<CustomerEntity,Long>{

	

}
