package com.mjm.jpaassociation.onetomany.repos;

import com.mjm.jpaassociation.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
