Meta:
@regression
Narrative:
1.I can Fill Facility Enrollment application
2.Sign performed with Hello Sign
3.Wait until status become Screening
4.Upload the Screening

Scenario:Delete all existing gmails
Meta:
When login to user gmail
Then go to gmail to inbox page
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Register and Enroll the Facility Enrollment and Upload Screening
Meta:
Given save value '<firstName>' to variable 'firstName'
And get random npi from file 'WyNPI'
And save value '<lastName>' to variable 'lastName'
And save value '<providerName>' to variable 'providerName'
And save value '<provider>' to variable 'provider'
And save value '<fein>' to variable 'fein'
And save value '<taxEntityType>' to variable 'taxEntityType'
And save value '<email1>' to variable 'email1'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<phone>' to variable 'phone'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<licenseNumber>' to variable 'licenseNumber'
And save value '<licenseType>' to variable 'licenseType'
And save value '<licenseIssuedState>' to variable 'licenseIssuedState'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<primaryServiceLocationZip>' to variable 'primaryServiceLocationZip'
And save value '<primaryServiceLocationCountyCode>' to variable 'primaryServiceLocationCountyCode'
And save value '<profitStatus>' to variable 'profitStatus'
And save value '<dba>' to variable 'dba'
And save value '<identifierType>' to variable 'identifierType'
And save value '<identifierId>' to variable 'identifierId'
And save value '<mi>' to variable 'mi'
And save value '<middleName>' to variable 'middleName'
And save value '<fax>' to variable 'fax'
And save value '<position>' to variable 'position'
And save value '<deaNumber>' to variable 'deaNumber'
And save value '<deaNumber>' to variable 'deaNumber'
And save value '<npiFeinNumber>' to variable 'npiFeinNumber'
And save value '<affiliationType>' to variable 'affiliationType'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<ssn1>' to variable 'ssn1'
And save value '<dob1>' to variable 'dob1'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<countyOfBirth>' to variable 'countyOfBirth'
And save value '<secondaryServiceLocationAddressLine1>' to variable 'secondaryServiceLocationAddressLine1'
And save value '<additionalTaxonomy>' to variable 'additionalTaxonomy'
And save value '<stateOfBirth1>' to variable 'stateOfBirth1'
And save value '<language>' to variable 'language'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
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
And fill Phone with value '${phone}' on registration page
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
And user click on Facility Provider Enrollment Application type
When implicit wait '2' seconds
When move to 'Identifying Information' section
And To fill the identifying information section for Enrollment:
|providerName|federalEmployerIdentification |email   |taxEntityType    |profitStatus   |
|${firstName}|${fein}                       |${email1}|${taxEntityType}|${profitStatus}|
And To fill the identifying information section for Enrollment:
|dba   |
|${dba}|
When move to 'Provider Identifiers' section
And To fill the Provider Identification Number:
|deaNumber|laboratoryServices|medicareParticipant|medicalDirector|
|No       |No                |No                 |No             |
And To fill the Provider Identification Number:
|teachingProvider|treatingProvider|pasrrAccess|drugPricingProgram|careAgreement|tradingPartnerAuthorization|
|No              |No              |No         |No                |No           |No                         |
Then click on the Addline in License information
When To fill the Provider Identification Number:
|identifierType    |identifierId    | identifierEffectiveDate |identifierEndDate|
|${identifierType} |${identifierId} | ${date}                 |${expDate}       |
Then click on the Save button
When To fill the Provider Identification Number:
|npi       |
|${npi}    |
And To fill the Provider Identification Number:
|medicareParticipant|
|No                 |
When move to 'Address Details' section
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|firstName   |lastName   |phone   |email     |
|${firstName}|${lastName}|${phone}|${email1} |
And To fill the Concact Person Details:
|mi   |fax   |position   |
|${mi}|${fax}|${position}|
When move to 'Taxonomy / License Information' section
And To fill the Licensure Section for Enrollment:
|taxonomyCategory    |
|${taxonomyCategory} |
When to select the primary taxonomy options '${primaryTaxonomy}'
When select additional Taxonomy '${additionalTaxonomy}' from the user list
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And To fill the Concact Person Details:
|firstName   |lastName   |phone   |email     |
|${firstName}|${lastName}|${phone}|${email1} |
And To fill the Concact Person Details:
|mi   |fax   |position   |
|${mi}|${fax}|${position}|
And To fill the Address Details:
|acceptingNewPatients |locationEquipped |
|Yes                  |No               |
When select language '${language}' from the user list
When move to 'Secondary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1      |
|${secondaryServiceLocationAddressLine1} |
Then click on ALL in All Ages Served
When To fill the Address Details:
|acceptingNewPatients |locationEquipped |
|Yes                  |No               |
When select language '${language}' from the user list
When move to 'Key Personnel' section
Then click on the Addline in License information
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |firstName    |middleName    |lastName   |ssn1   |dob1    |countryOfBirth   |stateOfBirth   |countyOfBirth   |
|${managingEmployeeType} |${firstName} |${middleName} |${lastName}|${ssn1}|${dob1} |${countryOfBirth}|${stateOfBirth1}|${countyOfBirth}|
Then click on the Save button
When move to 'Exclusion/Sanction Information' section
When To fill the Exclusion Sanction Section:
|criminalOffenseInAnyState|lincenseSanctionedRevokedInAnyState|civilMoneyUnderAnyState|sanctionedExcludedAnyState|
|No                       |No                                 |No                     |No                        |
When move to 'Upload Documents' section
When upload new 'Applicable board certification (Medicare/Board/Agency)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
When move to 'Authorized Signature' section
When to fill the Title of Person Submitting Enrollment:
|signatureOfPersonSubmittingEnrollment|titleOfPersonSubmittingEnrollment|
|Mrs                                  |${firstName}                     |
When move to 'Request Retroactive Adjustment' section
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '25' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And proceed to sign
And implicit wait '5' seconds
When click sign application
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When click navigate to dashboard link after sign
When log out from PE portal
When user navigated to landing page
When user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on ' AGREE' button in the Portal page
When implicit wait '2' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '2' seconds
And refresh page
And implicit wait '2' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When search for provider by name '${firstName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
Examples:testdata/demoTestData/FacilityinPendingApproval.table