package com.mjm.jpaassociation.onetomany.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }
}
