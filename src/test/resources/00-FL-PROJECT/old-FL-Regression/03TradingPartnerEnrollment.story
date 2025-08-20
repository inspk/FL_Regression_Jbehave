Meta:
@regression
Narrative:
Register the Provider
I want to fill Trading Partner Enrollment application
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
When move to 'Affiliation' section
And implicit wait '2' seconds
When move to 'Trading Partner Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '10' seconds
And move to 'Payment' section
And implicit wait '5' seconds
When perform personal payment
And implicit wait '10' seconds
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
When log out from IU portal
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
When click on 'Approve' button on decision panel
And implicit wait '5' seconds
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click On 'Verify Payment' button
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set date '${date}' and set agentId '${requestId}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for '$index'
Examples:testdata/CustomSDtradingPartner.table


Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC TradingPartner Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories|
|Ownership |
And implicit wait '2' seconds
Then verify the Coc Pop ownership notification 'Cannot change ownership, please submit new enrollment' is displaying
When implicit wait '2' seconds
Then click on Ok button in the coc page
When implicit wait '2' seconds

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC TradingPartner Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
And get random npi from file 'WyNPI'
And save value '<dba>' to variable 'dba'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<businessName>' to variable 'businessName'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness''
And save value '<phoneno>' to variable 'phoneno'
And save value '<address>' to variable 'address'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save current date to variable 'date'
And save value 'lite' to variable 'middleName'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories      |
|Key Personnel   |
And implicit wait '10' seconds
Then click on Addline for 'Key Personnel' in Key Personnel section
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth       |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth}    |${date}      |${expDate} |${address} |
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
And implicit wait '10' seconds
When move to 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'TradingPartner1'
Examples:testdata/CustomSDtradingPartner.table

Scenario: Approve Coc by 1 approver,2 reviewers to Deny COC TradingPartner Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'TradingPartner1'


Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC TradingPartner Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
And get random npi from file 'WyNPI'
And save value '<dba>' to variable 'dba'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<businessName>' to variable 'businessName'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness''
And save value '<phoneno>' to variable 'phoneno'
And save value '<address>' to variable 'address'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save current date to variable 'date'
And save value 'lite' to variable 'middleName'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories      |
|Key Personnel   |
And implicit wait '10' seconds
Then click on Addline for 'Key Personnel' in Key Personnel section
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth       |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth}    |${date}      |${expDate} |${address} |
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
And implicit wait '10' seconds
When move to 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'TradingPartner1'
Examples:testdata/CustomSDtradingPartner.table


Scenario: Deny Coc by 1 approver,2 reviewers to Deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
And implicit wait '5' seconds
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'

Scenario:Terminate the Trading Partner Provider
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
And save current date to variable 'date'
And save current date 'dateformat'
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${businessName}  |
When implicit wait '10' seconds
When click to provider data with text '${businessName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Enrollment Rules Violation' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
When log out from IU portal
Then rewrite stage of credentials to 'Terminated' for 'TradingPartner1'

Scenario: Re-Enrollment For Terminated
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Terminated' and use in session
Given user navigated to landing page
And get random npi from file 'WyNPI'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on reenrollment button
When implicit wait '10' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|tpnpi      |
|${npi}     |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '3' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Trading Partner Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '10' seconds
And move to 'Payment' section
And implicit wait '5' seconds
When perform personal payment
And implicit wait '10' seconds
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
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '60' seconds
When log out from PE portal
Then rewrite stage of credentials to 'Reenrollment' for 'TradingPartner1'

Scenario: Re-Enrollment Approve
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Reenrollment' and use in session
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
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
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
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
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
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
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When search for provider by name '${businessName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When log out from IU portal
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set date '${date}' and set agentId '${requestId}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'TradingPartner1'


Scenario:Terminate the Trading Partner Provider
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
And save current date to variable 'date'
And save current date 'dateformat'
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${businessName}  |
When implicit wait '10' seconds
When click to provider data with text '${businessName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Enrollment Rules Violation' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
When log out from IU portal
Then rewrite stage of credentials to 'Terminated' for 'TradingPartner1'

Scenario: Re-Enrollment For Terminated
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Terminated' and use in session
Given user navigated to landing page
And get random npi from file 'WyNPI'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on reenrollment button
When implicit wait '10' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|tpnpi      |
|${npi}     |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '3' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Trading Partner Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '10' seconds
And move to 'Payment' section
And implicit wait '5' seconds
When perform personal payment
And implicit wait '10' seconds
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
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName}|${lastName}'
When implicit wait '60' seconds
When log out from PE portal
Then rewrite stage of credentials to 'Reenrollment' for 'TradingPartner1'

Scenario: Reenrollment deny
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Reenrollment' and use in session
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
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
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
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
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
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
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When search for provider by name '${businessName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When log out from IU portal
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${businessName}         |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Denied' for 'TradingPartner1'