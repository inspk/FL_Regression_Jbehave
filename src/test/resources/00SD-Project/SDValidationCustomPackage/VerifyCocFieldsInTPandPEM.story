Meta:
Narrative:
As the DYP TP and PEM provider,
I can create the CoC for affiliation
without details of service location and program participation.

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
Examples:
|index                     |gender|dob       |ssn       |mailingAddressLine1  |mailingAddressZip|
|ProviderEnrollmentManager1|Male  |10/11/1975|333-633236|2528 DELL RANGE BLVD |74510-5343       |

Scenario:Approve the provider
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Created' and use in session
And save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'ProviderEnrollmentManager1'

Scenario:Verify the fields
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And close informational pop-up
And implicit wait '5' seconds
And click on CoC tab on header
When click on Change request button on Coc page
Then validate the Coc Types as below in Coc page:
|fields         |
|Add Affiliation|
|End Affiliation|
|Enrollment Data|


Meta:
Narrative:
As the DYP TP and PEM provider,
I can create the CoC for affiliation
without details of service location and program participation.

Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Register and Enroll the Trading Partner Enrollment Provider Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
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
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Trading Partner Enrollment type
When implicit wait '2' seconds
When move to 'Identifying Information' section
And To fill the Address Details:
|mailingAddressLine1|
|${address}         |
When To fill the identify info in the identification section for TP:
|businessName   |dba   |federalEmployerIdentification|
|${businessName}|${dba}|${fein}                      |
When implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When To fill the Classification Section:
|classification   |softwareVendorName|softwareName|versionId|entityCode|
|${classification}|ANDERSON INC      |SD-Printer  |v2.0     |Cartridge |
When implicit wait '2' seconds
When move to 'Provider Identifiers' section
And To fill TP Provider Identification Number:
|tpnpi   |
|${npi}  |
When implicit wait '2' seconds
When move to 'Ownership' section
When implicit wait '2' seconds
When move to 'Key Personnel' section
Then click on the Addline
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |${address} |
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
When move to new 'Affiliation' section
And implicit wait '2' seconds
When move to new 'Trading Partner Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '10' seconds
And move to new 'Payment' section
And implicit wait '5' seconds
When perform personal payment
And implicit wait '10' seconds
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
When implicit wait '60' seconds
When log out from PE portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
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
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And wait for screening process execution during '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When search for provider by name '${businessName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
Then rewrite stage of credentials to 'Created' for '$index'
Examples:
|index          |dob       |ssn          |dba   |countryOfBirth|stateOfBirth|businessName            |phoneno   |fein         |providerType|address        |classification|managingEmployeeType |employeeStatus         |
|TradingPartner1|10/11/1980|456-76-545111|Doctor|United States |South Dakota|AVERA AT HOME           |9874563210|60-42484039  |Hospital    |633 E SIOUX AVE|Switch Vendor |Director             |Managing Non Convicted |

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to approve Group Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Created' and use in session
And save value 'AVERA AT HOME' to variable 'businessName'
And save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'TradingPartner1'

Scenario:Verify the fields
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And close informational pop-up
And implicit wait '5' seconds
And click on CoC tab on header
When click on Change request button on Coc page
Then validate the Coc Types as below in Coc page:
|fields         |
|Add Affiliation|
|End Affiliation|
|Enrollment Data|