package com.codeeric.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
@Class Name: Parcel
@ClassDescription: this Parcel class is part of Model and Entity if have some Hibernate in our
MVC (Model View Controller) design pattern.
@author: Enrique Tan
@version 1.0
@since May 16, 2021
 */

public class Parcel {
    //variable declaration
    private final UUID id;
    private final String ruleName;
    private final int priority;
    private final float height;
    private final float width;
    private final float length;
    private final float weight;
    private final float volume;
    private final float cost;
    private final String voucherCode;
    private final float discount;


    //Constructor of variables with Json property entry for Spring boot annotations
    public Parcel(@JsonProperty("id") UUID id,
                  @JsonProperty("ruleName") String ruleName,
                  @JsonProperty("priority") int priority,
                  @JsonProperty("height") float height,
                  @JsonProperty("width") float width,
                  @JsonProperty("length") float length,
                  @JsonProperty("weight") float weight,
                  @JsonProperty("volume") float volume,
                  @JsonProperty("voucher") String voucherCode,
                  @JsonProperty("discount") float discount,
                  @JsonProperty("cost") float cost)
                {
        this.id = id;
        this.ruleName = ruleName;
        this.priority = priority;
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.discount = discount;
        this.voucherCode = voucherCode;

    }

    //Getters area
    public UUID getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public float getWeight() {
        return weight;
    }

    public float getVolume() {
        Float v = volume;
        v = height * width * length;
        return v;
    }

    /**
     * Getting data from mocklab.io server by implementing RestTemplate, short cut implementation compare to MVC design pattern
     * all the way
     */
    public float getDiscount() {
        RestTemplate restTemplate = new RestTemplate();
        float disc = 0.0f;

        //injecting some errorhandling capability but not all the way or global in scope implementation
        try {

            Map<String, String> params = new HashMap<>();
            params.put("voucherCode", voucherCode);

            //putting parametrize value in the voucherCode Model variable from the mocklab.io server
            Voucher voucher = restTemplate.getForObject("https://mynt-exam.mocklab.io/voucher/{voucherCode}?key=apikey",
                    Voucher.class, params);

            disc = voucher.getDiscount();

        }catch (Exception e) {
        }

        return disc;
    }

  /**
   * This function gets the values of Kg and Cm3, based on the conditions provided in the criteria of Rule Name column
  ruleName param is tested for the value of weight and volume parameters, appropriate level or value is issued if the criteria is met
  For example in the "Heavy Parcel" ruleName, the value of weight param must be greater than 10kg and so on and so forth.
  in the Volume param, the volume param has two criteria or condition to be met in order to make sure the appropriate ruleName
  say for "Large Parcel" ruleName the volume value must greater than or equal to 2500 and volume is not equal to 0,

  Not equal to 0 has some added validation if the client will not be providing the value for Length, Width and Height
   and will only provide the weight value if the WEIGHT is 10kg or less the VOLUME computation gets the priority.

This function will proceed even there is no data given to length, width and height to get the VOLUME value,
   however it will get the weight value instead.

 If the weight parameter has no value, then it will use the length, width and height values instead otherwise no cost data will be
   computed and will result only to 0.0.
   */

    public String getRuleName() {
// for Kilos
        String rn = ruleName;
        float c = 0.0f;
       float costString = cost;

        if (weight > 50) {
            rn = "Reject";
            costString   = 0;

        } else if (weight > 10) {
            rn = "Heavy Parcel";
            c = weight * 20f;
            costString = c;
        }
//for Volume
        else if (volume < 1500 && volume != 0)  {
            rn = "Small Parcel";
            c = volume * 0.03f;
            costString = c;

        } else if (volume < 2500 && volume !=0) {
            rn = "Medium Parcel";
            c = volume * 0.04f;
            costString = c;

        } else if (volume >= 2500 || weight <= 10){
            rn = "Large Parcel";
            c = volume * 0.05f;
            costString = c;
        }
        return rn;
    }

    /**
    This function loop thru the priority column to get the value of CONDITION COLUMN as follows:
    Weight exceeds 50kg
    Weight exceeds 10kg
    Volume is less than 1500cm3
    Volume is less than 2500cm3
    Volume is equal or more than 2500cm3

    Priority value 3 has two conditions to meet in order to satisfy the Priority value capture of 3,
     this will assure that the volume column has the appropriate data or value for comparison,
     in this example volume column must be less than 1500 and NOT equal to 0
    in order to satisfy and issue the value of 3 to the priority column.
     Same thing with Priority value 4 except for Priority 5,
    for Priority 5 in order to satisfy must check the value of WEIGHT parameter for the value of less than or equal to 10kg.
     */

    public int getPriority() {
        // for Kilos
        int p = priority;

        if (weight > 50) {
            p = 1;
        } else if (weight > 10) {
            p = 2;
        }
        //volume
        else if (volume < 1500 && volume != 0) {
            p = 3;
        } else if (volume < 2500 && volume != 0) {
            p = 4;
        } else if (volume >= 2500 || weight <= 10){
            p = 5;
        }
        return p;
    }
/**
Computation happening here!!!
Applying the discount function here from mocklab.io as well
This public function computes the cost of parcel delivery based on the specified rate in the given specification as follows:
It uses the PRIORITY VALUE COLUMN to get the appropriate cost rate for the said parcel.
1. Weight exceeds 50kg cost is 0.0 or N/A.
2. Weight exceeds 10kg cost is Php 20.00 multiply by Weight(kg)
3. Volume is less than 1500 cm3 is Php 0.03 multiply by Volume(cm3)
4. Volume is less than 2500 cm3 is Php 0.04 multiply by Volume(cm3)
5. Volume is equal or above 2500cm is Php 0.05 multiply by Volume(cm3)
 */
    public float getCost() {

        int p = priority;

        if (p == 1) {
            return 0.0f;
        } else if (p == 2) {
            float c =  (20 * weight) - discount ;
            return c;
        } else if (p == 3) {
            float c =  (0.03f * volume) - discount;
            return c;
        } else if (p == 4) {
            float c = (0.04f * volume) - discount;
            return c;
        } else if (p == 5) {
            float c = (0.05f * volume) - discount;
            return c;
        }
        return cost;
    }

    public String getVoucherCode() {
        return voucherCode;
    }
}
