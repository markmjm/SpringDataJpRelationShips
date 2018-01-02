package com.mjm.jpaassociation.onetoone.repos;

import com.mjm.jpaassociation.onetoone.entities.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Integer>{
}
