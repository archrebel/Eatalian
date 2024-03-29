/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.archetypesoftware.eatalian.domain.monetary;

import java.util.*;
import java.time.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.*;


// ----------- << imports@AAAAAAFs12maHX94Pv8= >>
import java.math.BigDecimal;
// ----------- >>

@Embeddable
@ApiModel(description = "")
// ----------- << class.annotations@AAAAAAFs12maHX94Pv8= >>
// ----------- >>
public class CurrencyAmount {
    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs123YVH+n2gk= >>
    // ----------- >>
    private BigDecimal amount;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAFs124JJ3+uQlc= >>
    // ----------- >>
    private Currency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public CurrencyAmount setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public CurrencyAmount setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

// ----------- << class.extras@AAAAAAFs12maHX94Pv8= >>
    public static CurrencyAmount of(BigDecimal amount, Currency currency) {
        return new CurrencyAmount(amount, currency);
    }

    public static CurrencyAmount of(long amount, Currency currency) {
        return of(BigDecimal.valueOf(amount), currency);
    }

    public CurrencyAmount() {
    }

    public CurrencyAmount(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

// ----------- >>
}