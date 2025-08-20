Meta:

Narrative:
As the DYP Internal user,
in pending approval stage
I can change the status to approved with the enrollment requested date and
with the ability to change the effective date with current and past date.

As the DYP Internal user,
in pending approval stage
I can change the status to future approved
if the requested enrollment date is with only future date.

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to approve Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
Given user navigated to landing page
And save current date to variable 'pastDate'
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
And implicit wait '5' seconds
When set Approved status for enrollment request status - 'Approved' and popup - 'Cancel' and date '${pastDate}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'Individual1'


Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to approve Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
When save current date plus 5 one day to variable end data 'futureDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
And implicit wait '5' seconds
When set Approved status for enrollment request status - 'Approved' and popup - 'Ok' and date '${futureDate}' with reason - 'Future approved as per provider request'
And implicit wait '5' seconds
Then rewrite stage of credentials to 'FutureApproved' for 'Individual1'