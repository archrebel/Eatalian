/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.archetypesoftware.eatalian.domain.accounts;

import java.util.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;


// ----------- << imports@AAAAAAFs168ImoRaOvU= >>
// ----------- >>

/**
* Customer's account that he uses to interact with our store.
*/

@Entity
// ----------- << class.annotations@AAAAAAFs168ImoRaOvU= >>
// ----------- >>
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ----------- << id.annotations@AAAAAAFs168ImoRaOvU= >>
    // ----------- >>
    private Long id;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs1688cISSNbI= >>
    // ----------- >>
    private String email;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs169ap4SZKAw= >>
    // ----------- >>
    private String password;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs168ZQISEweo= >>
    // ----------- >>
    private String firstName;

    @Column
    // ----------- << attribute.annotations@AAAAAAFs168smISLWb0= >>
    // ----------- >>
    private String lastName;

    /**
    * Contact phone number, used in case there is a need to contact the customer.
    */

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs19KSvInmmzY= >>
    // ----------- >>
    private String contactPhone;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs169vx4Sgkjc= >>
    // ----------- >>
    private LocalDateTime dateOfCreation;

    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs17yvqolqgMk= >>
    // ----------- >>
    private boolean active;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="streetAndNo", column = @Column(name = "billingAddress_streetAndNo")),
        @AttributeOverride(name="city", column = @Column(name = "billingAddress_city")),
        @AttributeOverride(name="postalCode", column = @Column(name = "billingAddress_postalCode")),
        @AttributeOverride(name="country", column = @Column(name = "billingAddress_country")),
        @AttributeOverride(name="floor", column = @Column(name = "billingAddress_floor"))
    })
    // ----------- << attribute.annotations@AAAAAAFs17FjAIUGCoY= >>
    // ----------- >>
    private Address billingAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="streetAndNo", column = @Column(name = "shipmentAddress_streetAndNo")),
        @AttributeOverride(name="city", column = @Column(name = "shipmentAddress_city")),
        @AttributeOverride(name="postalCode", column = @Column(name = "shipmentAddress_postalCode")),
        @AttributeOverride(name="country", column = @Column(name = "shipmentAddress_country")),
        @AttributeOverride(name="floor", column = @Column(name = "shipmentAddress_floor"))
    })
    // ----------- << attribute.annotations@AAAAAAFs17FpEYVDlR8= >>
    // ----------- >>
    private Address shipmentAddress;

    // ----------- << getId.annotations@AAAAAAFs168ImoRaOvU= >>
    // ----------- >>
    public Long getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public boolean isActive() {
        return active;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShipmentAddress() {
        return shipmentAddress;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Account setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public Account setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        return this;
    }

    public Account setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Account setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public Account setShipmentAddress(Address shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
        return this;
    }

    public Account linkBillingAddress(Address _billingAddress) {
        setBillingAddress(_billingAddress);
        return this;
    }

    public Account linkShipmentAddress(Address _shipmentAddress) {
        setShipmentAddress(_shipmentAddress);
        return this;
    }

    public Account unlinkBillingAddress() {
        setBillingAddress(null);
        return this;
    }

    public Account unlinkShipmentAddress() {
        setShipmentAddress(null);
        return this;
    }

    // ----------- << equals.annotations@AAAAAAFs168ImoRaOvU= >>
    // ----------- >>
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (getId() == null) return false;
        return obj instanceof Account && (getId().equals(((Account) obj).getId()));
    }

    // ----------- << hashCode.annotations@AAAAAAFs168ImoRaOvU= >>
    // ----------- >>
    @Override
    public int hashCode() {
        return 319;
    }

    // ----------- << method.annotations@AAAAAAFs16/Lq4SpVCw= >>
    // ----------- >>
    public String getFullName() {
    // ----------- << method.body@AAAAAAFs16/Lq4SpVCw= >>
        return String.format("%s %s", firstName, lastName);
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFs168ImoRaOvU= >>
// ----------- >>
}