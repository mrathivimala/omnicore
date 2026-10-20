package com.data.management.omnicore.customer.repository;

import com.data.management.omnicore.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
