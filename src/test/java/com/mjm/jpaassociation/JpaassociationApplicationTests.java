package com.mjm.jpaassociation;

import com.mjm.jpaassociation.manytomany.entities.Programmer;
import com.mjm.jpaassociation.manytomany.entities.Project;
import com.mjm.jpaassociation.manytomany.repos.ProgrammerRespository;
import com.mjm.jpaassociation.onetomany.entities.Customer;
import com.mjm.jpaassociation.onetomany.entities.PhoneNumber;
import com.mjm.jpaassociation.onetomany.repos.CustomerRepository;
import com.mjm.jpaassociation.onetoone.entities.License;
import com.mjm.jpaassociation.onetoone.entities.Person;
import com.mjm.jpaassociation.onetoone.repos.LicenseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaassociationApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	LicenseRepository licenseRespository;

	@Autowired
	ProgrammerRespository programmerRespository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateCustomer(){
		Customer customer = new Customer();
		customer.setName("Jimmy Jam");

		HashSet<PhoneNumber> numbers  = new HashSet<>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1112223333");
		ph1.setType("cell");
		ph1.setCustomer(customer);

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("5556667777");
		ph2.setType("home");
		ph2.setCustomer(customer);

		PhoneNumber ph3 = new PhoneNumber();
		ph3.setNumber("3456789999");
		ph3.setType("office");
		ph3.setCustomer(customer);

		numbers.add(ph1);
		numbers.add(ph2);
		numbers.add(ph3);
		customer.setNumbers(numbers);

		repository.save(customer);
	}

	@Test
	//@Transactional
	//if you want lazy loading of child entities, enable this Transactiona
	public void testLoadCustomer(){
		Customer customer = repository.findOne(5);
		System.out.println(customer);
		Set<PhoneNumber> numbers = customer.getNumbers();
		for (PhoneNumber number : numbers) {
			System.out.println(number.getNumber());
		}
	}

	@Test
	public void testUpdateCustomer(){
		Customer customer = repository.findOne(5);
		customer.setName("John Bush");
		System.out.println(customer);
		Set<PhoneNumber> numbers = customer.getNumbers();
		for (PhoneNumber number : numbers) {
			number.setType("Cell");
		}
		repository.save(customer);
	}

	@Test
	public void testDeleteCustomer(){
		Customer customer = repository.findOne(5);
		if(customer != null){
			repository.delete(5);
		}
	}

	@Test
	public void testManyToManyCreateProgramm(){
		Programmer programmer = new Programmer();
		programmer.setName("Jimmy Jam");
		programmer.setSal(10000);

		Set<Project> projects = new HashSet<>();
		Project p1 = new Project();
		p1.setName("Java Project 1");
		projects.add(p1);
		Project p2 = new Project();
		p2.setName("Java Project 2");
		projects.add(p2);

		programmer.setProjects(projects);
		programmerRespository.save(programmer);

	}

	@Test
	@Transactional
	//if you want lazy loading of child projects, enable this Transactiona
	public void testFindProgrammer(){
		Programmer p = programmerRespository.findOne(1);
		System.out.println(p);
	}


	@Test
	public void testOneToOneCreateLicense(){
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date()); //one day license :=-)

		Person person = new Person();
		person.setFirstName("Jimmy");
		person.setLastName("Jam");
		person.setAge(35);

		license.setPerson(person);
		licenseRespository.save(license);
	}
}
