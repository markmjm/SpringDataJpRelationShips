package com.mjm.jpaassociation.manytomany.repos;

import com.mjm.jpaassociation.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRespository extends CrudRepository<Programmer, Integer> {
}
