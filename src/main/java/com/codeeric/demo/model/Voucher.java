package com.codeeric.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 @ClassName: Voucher
 @Description: this Parcel class is part of Data Layer/View, MVC (Model View Controller) design pattern.
 @author : Enrique Enolva Tan
 @since: May 16, 2021
 @version: 1.0
 */

public class Voucher {

private final UUID id;
private final String codeName;
private final float discount;
private final String date;

    public Voucher(@JsonProperty("id") UUID id,
                   @JsonProperty("code") String codeName,
                   @JsonProperty("discount") float discount,
                   @JsonProperty("expiry") String date) {

        this.id = id;
        this.codeName = codeName;
        this.discount = discount;
        this.date = date;
    }

    public String getCodeName() {

        return codeName;
    }

    public float getDiscount() { return discount; }

    public String getDate() {
        return date;
    }
}
