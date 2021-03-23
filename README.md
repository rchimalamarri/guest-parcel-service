# guest-parcel-service
This micro service will help to the hotel staff for handling guest parcel requests

Instructions to run the solution:

1. clone the project from master branch
2. Do the gradle clean build --refresh-dependencies
3. once after build successful -start the application by running GuestParcelServiceApplication java file with help of any IDE
4. once application is started Please use the post man collection for the sample request for all the 4 end points
5. Please refer the swagger for mandatory request headers,
for example First Name , Last name  and ParcelCollectionEligibility are mandatory as per Swagger and in terms of table level 
Note: in real time swagger will be exposed to API gateway to validate the mandatory request headers, Hence Explicit null checks are not performed 
