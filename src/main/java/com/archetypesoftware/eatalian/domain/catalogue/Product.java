/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.archetypesoftware.eatalian.domain.catalogue;

import java.util.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.archetypesoftware.eatalian.domain.monetary.CurrencyAmount;
// ----------- << imports@AAAAAAFs15dY/X/qZkk= >>
// ----------- >>

/**
* A Product sold by our company.
*/

@Entity
// ----------- << class.annotations@AAAAAAFs15dY/X/qZkk= >>
// ----------- >>
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ----------- << id.annotations@AAAAAAFs15dY/X/qZkk= >>
    // ----------- >>
    private Long id;

    /**
    * The name of the product.
    */

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs15fEsYAjHHA= >>
    // ----------- >>
    private String name;

    /**
    * Product description.
    */

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs15fVNoAq1rs= >>
    // ----------- >>
    private String description;

    /**
    * Product price.
    */

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="amount", column = @Column(name = "price_amount")),
        @AttributeOverride(name="currency", column = @Column(name = "price_currency"))
    })
    // ----------- << attribute.annotations@AAAAAAFs15gZFYAxtuc= >>
    // ----------- >>
    private CurrencyAmount price;

    /**
    * Product category.
    */

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    // ----------- << attribute.annotations@AAAAAAFs15idfoA7+9A= >>
    // ----------- >>
    private Category category;

    // ----------- << getId.annotations@AAAAAAFs15dY/X/qZkk= >>
    // ----------- >>
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyAmount getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product setPrice(CurrencyAmount price) {
        this.price = price;
        return this;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Product linkCategory(Category _category) {
        if (_category != null) {
            _category.getProducts().add(this);
        }

        unlinkCategory();
        setCategory(_category);
        return this;
    }

    public Product unlinkCategory() {
        if (getCategory() != null) {
            getCategory().getProducts().remove(this);
            setCategory(null);
        }
        return this;
    }

    // ----------- << equals.annotations@AAAAAAFs15dY/X/qZkk= >>
    // ----------- >>
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (getId() == null) return false;
        return obj instanceof Product && (getId().equals(((Product) obj).getId()));
    }

    // ----------- << hashCode.annotations@AAAAAAFs15dY/X/qZkk= >>
    // ----------- >>
    @Override
    public int hashCode() {
        return 562;
    }

// ----------- << class.extras@AAAAAAFs15dY/X/qZkk= >>
// ----------- >>
}