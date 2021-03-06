package com.codeeric.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 @ClassName: Voucher
 @Description: this Parcel class is part of Data Layer/View, MVC (Model View Controller) design pattern.
 @author : Enrique Enolva Tan
 @since: May 16, 2021
 @version: 1.0
 @remarks: this is use to get the value from voucher api service from https://mynt-exam.mocklab.io/voucher/MYNT?key=apikey
 particular the code field for voucherCode and discount field as discount.
 I chose not to implement the MVC design pattern for brevity purposes, I digress to a short cut version via Spring RestTemplate 
 located in Parcel class under getDiscount method/function.
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
