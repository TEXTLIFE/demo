package com.codeeric.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: API_Parcel_MYNT_Exam
 * @ClassDescription: This is the main class file
 * @author: Enrique Enolva Tan
 * @version: 1.0
 * @Since: May 16, 2021
 * @Remarks: This small API app has the capabilities to accept the cost calculation of delivery parcel on WEIGHT and VOLUME
 * the WEIGHT doesn't need the height, width, and length values to get the COST, while the VOLUME needs the height, width and length
 * values in order to calculate the VOLUME and eventually get the COST, the given formulas is volume = height * width * length
 *
 *The rules for calculating the cost of delivery are in order of priority 1 to 5 which 1 is the highest, the pricing is hard coded at
 * this demo but can be dynamically provided by the user, I'm aware that the given specs stated that needs to be flexible as possible,
 * but due to time constraint I decided NOT to implement it.
 *
 * This api app also connects to https://mynt-exam.mocklab.io/voucher/ to get the voucher and the discount rate associated based on
 * Voucher Code.
 * I didn't use the expiry parameter due to the limitation given by mocklab.io API service, instead I resorted to voucherCode to get the
 * corresponding discount rate to be deducted from the Cost of parcel delivery. So, voucher are always active and ready to use.
 *
 * I didn't show the cost before discount on the API result, instead I go straight presenting the COST with or with out discount.
 *
 * I didn't use also any actual DB here but instead the ArrayList class, the reason is that I didn't see any good unless
 * we want to store the test data for good and just also to save time designing and creating actual db.
 *
 * Attention, attention: ErrorHandler or Exception Handling best practices are not considered in this api implementation.
 */

@SpringBootApplication
public class API_Parcel_MYNT_Exam {
    public static void main(String[] args) {
        SpringApplication.run(API_Parcel_MYNT_Exam.class, args);

    }
}
