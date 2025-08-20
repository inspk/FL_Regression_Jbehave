Meta:
@regression
Narrative:
Register the Provider
I want to fill Individual Enrollment application
Sign performed with Hello Sign
and update the screening scorer̥

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
|businessName   |dba   |federalEmployerIdentification|email   |
|${businessName}|${dba}|${fein}                      |${email}|
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
When click submit invoice payment on Payment section
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
When implicit wait '30' seconds
When log out from PE portal
Examples:testdata/TradingPartnerProvidersForReviewersAndOfflinePayment.table