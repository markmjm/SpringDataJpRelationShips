package com.mjm.jpaassociation.onetomany.entities;


import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String number;
    private String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
