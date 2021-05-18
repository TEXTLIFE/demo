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

You can run the api app in your local machine via intelliJ IDE or via jar, the local URL is localhost:8080/api/v1/parcel/, 
I didn't deploy it in the internet as running api service, but local only.
It has the following json parameters for example if you wanna insert data using postman in json format (the api must be running on local):
    {
        "weight" : "11",
        "voucher" : "MYNT"
    }

Then try to execute GET via postman localhost:8080/api/v1/parcel/ without a parameter of ID (query all data)

    {
        "id": "8b0cc8da-3c4e-4839-9ebb-5f2f6158b292",
        "ruleName": "Heavy Parcel",
        "priority": 2,
        "height": 0.0,
        "width": 0.0,
        "length": 0.0,
        "weight": 11.0,
        "volume": 0.0,
        "voucher": "MYNT",
        "discount": 12.25,
        "cost": 207.75
    }

another example with different parameters, without the weight param:
    {
        "height" : "20",
        "width" : "20",
        "length" : "10",
        "voucher" : "GFI"
    }

result will be:

    {
        "id": "cf2e1db5-573e-479c-9eed-0cbbef0d019d",
        "ruleName": "Large Parcel",
        "priority": 5,
        "height": 20.0,
        "width": 20.0,
        "length": 10.0,
        "weight": 0.0,
        "volume": 4000.0,
        "voucher": "GFI",
        "discount": 7.5,
        "cost": 192.5
    }


with complete parameters from weight, length, width, height but NO voucher(discount):

{
    "weight" : "10",
    "height" : "20",
    "width" : "20",
    "length" : "10"
}

Result is:

    {
        "id": "dfe0c22c-8eae-4e4f-90ea-03584315ffb1",
        "ruleName": "Large Parcel",
        "priority": 5,
        "height": 20.0,
        "width": 20.0,
        "length": 10.0,
        "weight": 10.0,
        "volume": 4000.0,
        "voucher": null,
        "discount": 0.0,
        "cost": 200.0
    }


