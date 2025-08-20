Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario:Register as Trading Partner Enrollment and Adding PEM provider in affiliation
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'SdNPI'
And save value '<dba>' to variable 'dba'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<businessName>' to variable 'businessName'
And save value '<fein>' to variable 'fein'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<phoneno>' to variable 'phoneno'
And save value '<address>' to variable 'address'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<classification>' to variable 'classification'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
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
When implicit wait '2' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '2' seconds
Then click on new user link from the gmail
When implicit wait '2' seconds
Then navigate Back to Login page
When implicit wait '2' seconds
And refresh page
When implicit wait '2' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Trading Partner (TP) Enrollment type
When implicit wait '2' seconds
When move to 'Identifying Information' section
When implicit wait '2' seconds
When To fill the identify info in the identification section for TP:
|businessName   |dba   |federalEmployerIdentification|email      |
|${businessName}|${dba}|${fein}                      |${email}   |
When implicit wait '2' seconds
And To fill the Address Details:
|mailingAddressLine1|
|${address}         |
When implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When To fill the Classification Section:
|classification   |softwareVendorName|softwareName|versionId|entityCode|
|${classification}|ANDERSON INC      |SD-Printer  |v2.0     |Cartridge |
When implicit wait '2' seconds
When move to 'Provider Identifiers' section
When implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill TP Provider Identification Number:
|tpnpi   |
|${npi}  |
When implicit wait '2' seconds
When move to 'Ownership' section
When implicit wait '2' seconds
And To fill the Ownership Section for Enrollment:
|personOwnership1|billedEntityOwnership|
|No              |No                   |
When implicit wait '2' seconds
When move to 'Key Personnel' section
Then click on the Addline
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus    |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |ssnAddress |
|Manager                 |Managing Convicted|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |${address} |
When implicit wait '2' seconds
Then click on the Save button
When implicit wait '2' seconds
When move to 'Exclusion/Sanction Information' section
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility|perjury|serviceAbuse|criminalInvestigation|unlawfulSubstances|healthCareCrime|
|No              |No                     |No     |No          |No                   |No                |No             |
And To fill the Exclusion Sanction Section:
|paymentInformation|disclosureInformation|suspensionOfLicense|suspensionOfAccreditation|procurementProgram|paymentSuspension|falseClaimsAct|currentOverpayment|
|No                |No                   |No                 |No                       |No                |No               |No            |No                |
And implicit wait '2' seconds
When move to 'Authorized Signature' section
And implicit wait '2' seconds
When to fill the Title of Person Submitting Enrollment:
|title|name         |
|Mr   |${firstName} |
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '2' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000002' in affiliation section
And implicit wait '10' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When select affliation type 'TP to PEM'
And implicit wait '5' seconds
When fill the effective start '${date}' and effective end '${enddate}' to enrollment end affiliation type page
And implicit wait '5' seconds
When click add button in affiliation pop-up
And implicit wait '5' seconds
When move to 'Trading Partner Agreement' section
And implicit wait '15' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '5' seconds
When move to 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |
|${firstName}|${lastName}|
Then Agree Term and conditions to Sign
When submit enrollment application
And implicit wait '5' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When new user logs to Provider Enrollment portal with username - nagure.providers+8048@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the TP' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And implicit wait '5' seconds
When click on Proceed To Sign button
And implicit wait '2' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '40' seconds
When click navigate to dashboard link after sign
When implicit wait '5' seconds
Then save the Tracking Number of the provider
When implicit wait '5' seconds
Examples:testdata/CustomSDtradingPartner.table

Scenario:Verify Enrollment approvals based on System Options Configuration:2 reviewers and 1 approver to approve TP Enrollment
Meta:
Given user navigated to landing page
And save value 'CORUS AT HOME CNT' to variable 'businessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
When implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
When implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set date '${date}' and set agentId '${requestId}' with reason - 'Other Documentation Supported'
And implicit wait '15' seconds