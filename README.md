# demo
initial commit as of 7:49pm

This is for MYNT exam requirement API that calculate the cost of delivery of Create an API that will calculate the cost of delivery of a parcel based on 
weight and volume (volume = height * width * length). 
The API should accept the following: 1. Weight (kg) 2. Height (cm) 3. Width (cm) 4. Length (cm)

The rules for calculating the cost of delivery are in order of priority: see table

As the market tends to fluctuate in terms of pricing, the rules needs to be as flexible as possible. 
Your API should also accept a voucher code that can be used to provide discounts to the customer. 
To get the discount details of the submitted voucher code, you will need to integrate with the voucher service maintained by another team.
You may check their Voucher API definition here. https://app.swaggerhub.com/apis/mynt-iat/mynt-programming-exams/1.1.0#/voucher
This also includes the details of the mock server that they have provided for your testing.
