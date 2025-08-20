Meta:
@regression
Narrative:
1.I can Fill Pharmacy Enrollment application
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

Scenario:Register and Enroll the Pharmacy Provider Enrollment
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<phoneno>' to variable 'phoneno'
And save value '<fein>' to variable 'fein'
And save value '<taxEntityType>' to variable 'taxEntityType'
And save value '<ncpdpNumber>' to variable 'ncpdpNumber'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<pharmacyType>' to variable 'pharmacyType'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<pharmacylicenseNumber>' to variable 'pharmacylicenseNumber'
And save value '<pharmacylicenseType>' to variable 'pharmacylicenseType'
And save value '<pharmacylicenseIssuedState>' to variable 'pharmacylicenseIssuedState'
And save value '<statepharmacylicenseNumber>' to variable 'statepharmacylicenseNumber'
And save value '<statepharmacylicenseType>' to variable 'statepharmacylicenseType'
And save value '<statepharmacylicenseIssuedState>' to variable 'statepharmacylicenseIssuedState'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<primaryServiceLocationZip>' to variable 'primaryServiceLocationZip'
And save value '<primaryServiceLocationCountyCode>' to variable 'primaryServiceLocationCountyCode'
And save value '<profitStatus>' to variable 'profitStatus'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
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
And fill Phone with value '${phoneno}' on registration page
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
And user click on Pharmacy Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerName|federalEmployerIdentification |email   |taxEntityType    |profitStatus   |
|${firstName}|${fein}                       |${email}|${taxEntityType} |${profitStatus}|
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|pharmacynpi|
|${npi}     |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|ncpdpNumber   |
|${ncpdpNumber}|
And implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1   |
|${mailingAddressLine1}|
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |
|${firstName}|${lastName}|${phoneno}|${email} |
And implicit wait '5' seconds
When move to 'Taxonomy / License Information' section
And implicit wait '5' seconds
And To fill the Licensure Section for Enrollment:
|pharmacyType    |
|${pharmacyType} |
When to select the pharmacy primary taxonomy options '${primaryTaxonomy}'
When implicit wait '5' seconds
When To fill the Pharmacy License Information for Enrollment:
|pharmacylicenseNumber    |pharmacylicenseType     |pharmacylicenseIssuedState    |pharmacylicensEffectiveDate |pharmacylicenseExpirationDate |
|${pharmacylicenseNumber} |${pharmacylicenseType}  |${pharmacylicenseIssuedState} |${date}                     |${expDate}                    |
When implicit wait '5' seconds
Then click on the Addline in License information
When implicit wait '5' seconds
When To fill the Pharmacy License Information for Enrollment:
|statepharmacylicenseNumber    |statepharmacylicenseType   |statepharmacylicenseIssuedState   |statepharmacylicensEffectiveDate |statepharmacylicenseExpirationDate |
|${statepharmacylicenseNumber} |${statepharmacylicenseType}|${statepharmacylicenseIssuedState}|${date}                          |${expDate}                         |
When implicit wait '5' seconds
Then click on the Save button
When implicit wait '3' seconds
Then click on the close popup
When implicit wait '5' seconds
Then click on the Save button
When implicit wait '5' seconds
When move to 'Primary Service Location Information' section
And implicit wait '5' seconds
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |
|${firstName}|${lastName}|${phoneno}|${email} |
And implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
When implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|keyEmployeeCriminalOffenseInAnyState|keyEmployeeLincenseSanctionedRevokedInAnyState|keyEmployeeCivilMoneyUnderAnyState|keyEmployeeSanctionedExcludedAnyState|
|No                                  |No                                            |No                                |No                                   |
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload the Enrollment document text_file.txt
When implicit wait '30' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
When to fill the Title of Person Submitting Enrollment:
|signatureOfPersonSubmittingEnrollment|titleOfPersonSubmittingEnrollment|
|Mrs                                  |${firstName}                     |
And implicit wait '5' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
When move to new 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '40' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '50' seconds
And move to new 'Payment' section
And implicit wait '20' seconds
When perform personal payment
And implicit wait '20' seconds
When move to new 'Summary' section
When implicit wait '5' seconds
Then Agree Term and conditions to Sign
When submit enrollment application
And implicit wait '5' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
When wait for screening process execution during '40' seconds
When log out from PE portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '15' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '15' seconds
When click on Enrollment tab on header
And wait for screening process execution during '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When search for provider by name '${firstName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
Then rewrite stage of credentials to 'Created' for '$index'
Examples:testdata/SDPharmacyProvidersForcustomregression.table
