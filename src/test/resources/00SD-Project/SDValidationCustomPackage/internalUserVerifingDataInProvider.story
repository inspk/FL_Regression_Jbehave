Meta:

Narrative:
As the DYP Internal User,
I can view the requested enrollment date in the top section of each enrollment request.

Scenario:Login as Internaluser And verify enrollment request revalidation date
Meta:
Given take firstname, lastname and email credentials for type 'Individual5' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
Then verify the enrollment request 'Effective approved date' is '${date}'
Then verify the enrollment request 'Provider name' is '${firstName} ${lastName}'
Then verify the enrollment request 'Enrollment type' is 'Individual'
Then verify the enrollment request 'Revalidation Date' is '06/08/2023'