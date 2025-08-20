Meta:
@regression
Narrative:
1.I can Fill Provider Enrollment Manager Enrollment application
2.Sign performed with Hello Sign
3.Wait until status become Screening
4.Upload the Screening

Scenario:Delete all existing gmails
Meta:
When login to user gmail
Then go to gmail to inbox page
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Provider Enrollment Manager Enrollment Flow
Meta:
Given save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<provider>' to variable 'provider'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<email1>' to variable 'email1'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<middleName>' to variable 'middleName'
And save value '<phoneNumber>' to variable 'phoneNumber'
And save value '<fax>' to variable 'fax'
And save value '<alternateEmail>' to variable 'alternateEmail'
And save current date to variable 'date'
When implicit wait '5' seconds
When user navigated to landing page
When click SignIn/Register button on landing page
When click Register button on login page
And wait for screening process execution during '3' seconds
When fill Email with value '${email1}' on registration page
And fill Organization Name field with value 'HHSTECHGROUP' on registration page
And fill Organization description with value 'HHSOrg' on registration page
And fill Password with value 'Internaluser1!' on registration page
And fill Validate password with value 'Internaluser1!' on registration page
And fill First name  with value '${firstName}' on registration page
And fill Last name with value '${lastName}' on registration page
And fill Phone with value '3534534534' on registration page
And select Prefix value 'D.O' on registration page
And select Suffix value 'III' on registration page
And click Register button on registration page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '2' seconds
When search for message by email - ${email1}
When open new 'Registration in ProviderPortal' email
When implicit wait '2' seconds
Then click on user link from the gmail
When implicit wait '2' seconds
Then navigate Back to Login page
When implicit wait '2' seconds
When user logs to Provider Enrollment portal with username - ${email1} and password - Internaluser1!
When click on ' AGREE' button in the Portal page
When skip help tour if exists
And user click on Provider Enrollment Manager type
And To fill the identifying information section for Enrollment:
|firstName   |lastName   |gender   |email    |
|${firstName}|${lastName}|${gender}|${email1} |
And To fill the identifying information section for Enrollment:
|middleName    |phoneNumber    |fax    |alternateEmail    |
|${middleName} |${phoneNumber} |${fax} |${alternateEmail} |
When move to 'Address Details' section
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
When move to 'Upload Documents' section
When implicit wait '2' seconds
When upload new 'Upload supporting documents if needed (Optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign2 provider application for user '${firstName} ${lastName}'
And implicit wait '25' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And proceed to sign
And implicit wait '5' seconds
When click sign application
When wait for screening process execution during '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When click navigate to dashboard link after sign
When log out from PE portal
When user navigated to landing page
When user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on ' AGREE' button in the Portal page
And implicit wait '2' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '10' seconds
And refresh page
And implicit wait '2' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and reason - 'Approved Based Documents'
Examples:testdata/demoTestData/PEMinApproved.table


