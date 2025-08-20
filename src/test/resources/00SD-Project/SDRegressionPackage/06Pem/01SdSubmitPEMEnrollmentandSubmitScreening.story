Meta:
@regression
Narrative:
1.I can Fill PEM Enrollment application
2.Sign performed with Hello Sign
3.Wait until status become Screening
4.Upload the Screening

Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Provider Enrollment Manager  Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And save value '<provider>' to variable 'provider'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save current date to variable 'date'
When user navigated to landing page
When click create account link in the landing page
And wait for screening process execution during '3' seconds
When fill Email with value '${email}' on registration page
And fill Password with value 'Aa123321!' on registration page
When click on continue button in the registartion page
And fill Organization Name field with value 'HHSTECHGROUP' on registration page
And fill Organization description with value 'HHSOrg' on registration page
When click on continue button in the registartion page
And fill First name  with value '${firstName}' on registration page
And fill Last name with value '${lastName}' on registration page
And fill Phone with value '3534534534' on registration page
When click on create account link in the registartion page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '5' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '5' seconds
Then click on new user link from the gmail
When implicit wait '5' seconds
Then navigate Back to Login page
When implicit wait '5' seconds
And refresh page
When implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Provider Enrollment Manager type
And To fill the identifying information section for Enrollment:
|firstName   |lastName   |gender   |email    |phoneNumber|
|${firstName}|${lastName}|${gender}|${email} |3534534534 |
When implicit wait '2' seconds
When move to 'Address Details' section
When implicit wait '2' seconds
And To fill the Concact Person Details:
|attentionLine   |
|Landmark        |
When implicit wait '2' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And implicit wait '5' seconds
When move to new 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '40' seconds
And sign2 provider application for user '${firstName} ${lastName}'
And implicit wait '50' seconds
And move to new 'Payment' section
And implicit wait '30' seconds
When perform personal payment
And implicit wait '5' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |
|${firstName}|${lastName}|
Then Agree Term and conditions to Sign
When submit enrollment application
And implicit wait '5' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '40' seconds
When log out from PE portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
When log out from IU portal
Then rewrite stage of credentials to 'Created' for '$index'
Examples:testdata/SDPemProvidersForcustomregression.table

