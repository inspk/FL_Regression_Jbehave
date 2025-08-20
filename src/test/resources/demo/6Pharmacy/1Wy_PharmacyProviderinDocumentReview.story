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
Then go to gmail to inbox page
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Register and Enroll the Pharmacy Provider Enrollment
Meta:
Given save value '<firstName>' to variable 'firstName'
And get random npi from file 'WyNPI'
And save value '<lastName>' to variable 'lastName'
And save value '<provider>' to variable 'provider'
And save value '<providerName>' to variable 'providerName'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<phoneno>' to variable 'phoneno'
And save value '<email1>' to variable 'email1'
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
And save value '<listAllStates>' to variable 'listAllStates'
And save value '<contactName340B>' to variable 'contactName340B'
And save value '<contactPhone340B>' to variable 'contactPhone340B'
And save value '<contactEmail340B>' to variable 'contactEmail340B'
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
And save value '<npiFeinNumber>' to variable 'npiFeinNumber'
And save value '<affiliationType>' to variable 'affiliationType'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<ssn1>' to variable 'ssn1'
And save value '<dob1>' to variable 'dob1'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<countyOfBirth>' to variable 'countyOfBirth'
And save value '<additionalTaxonomy>' to variable 'additionalTaxonomy'
And save value '<stateOfBirth1>' to variable 'stateOfBirth1'
And save value '<drugNcdExample>' to variable 'drugNcdExample'
And save value '<additionalInformation>' to variable 'additionalInformation'
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
And fill Phone with value '${phoneno}' on registration page
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
And user click on Pharmacy Enrollment type
When implicit wait '2' seconds
When move to 'Identifying Information' section
And To fill the identifying information section for Enrollment:
|providerName|federalEmployerIdentification |email   |taxEntityType    |profitStatus   |
|${firstName}|${fein}                       |${email1}|${taxEntityType}|${profitStatus}|
And To fill the identifying information section for Enrollment:
|dba   |
|${dba}|
And To fill the identifying information section for Enrollment:
|differentDbaName|
|No              |
When move to 'Provider Identifiers' section
And To fill the Provider Identification Number:
|medicareParticipant|doYouHaveDeaNumber|doYouHavePharmacyContact|
|No                 |No                |No                      |
And To fill the Provider Identification Number:
|teachingProvider|treatingProvider|pasrrAccess|drugPricingProgram|careAgreement|tradingPartnerAuthorization|
|No              |No              |No         |No                |No           |No                         |
Then click on the Addline in License information
When To fill the Provider Identification Number:
|identifierType    |identifierId    |identifierEffectiveDate |identifierEndDate|
|${identifierType} |${identifierId} |${date}                 |${expDate}       |
Then click on the Save button
When To fill the Provider Identification Number:
|pharmacynpi|
|${npi}     |
And To fill the Provider Identification Number:
|ncpdpNumber   |
|${ncpdpNumber}|
When move to 'Address Details' section
And To fill the Address Details:
|mailingAddressLine1   |
|${mailingAddressLine1}|
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email     |
|${firstName}|${lastName}|${phoneno}|${email1} |
And To fill the Concact Person Details:
|mi   |fax   |position   |
|${mi}|${fax}|${position}|
Then click on NO in Pharmacy Medicare Certified
Then click on NO in Pharmacy Payments
When move to 'Taxonomy / License Information' section
And To fill the Licensure Section for Enrollment:
|pharmacyType    |
|${pharmacyType} |
When to select the pharmacy primary taxonomy options '${primaryTaxonomy}'
When select additional Taxonomy '${additionalTaxonomy}' from the user list
When To fill the Pharmacy License Information for Enrollment:
|pharmacylicenseNumber    |pharmacylicenseType     |pharmacylicenseIssuedState    |pharmacylicensEffectiveDate |pharmacylicenseExpirationDate |
|${pharmacylicenseNumber} |${pharmacylicenseType}  |${pharmacylicenseIssuedState} |${date}                     |${expDate}                    |
Then click on the Addline in License information
When To fill the Pharmacy License Information for Enrollment:
|statepharmacylicenseNumber    |statepharmacylicenseType   |statepharmacylicenseIssuedState   |statepharmacylicensEffectiveDate |statepharmacylicenseExpirationDate |
|${statepharmacylicenseNumber} |${statepharmacylicenseType}|${statepharmacylicenseIssuedState}|${date}                          |${expDate}                         |
Then click on the Save button
Then click on the close popup
Then click on the Save button
When To fill the Pharmacy License Information for Enrollment:
|listAllStates   |
|${listAllStates}|
Then click Pharmacy Participates in 340B drug Pricing Progrm
When To fill the Pharmacy License Information for Enrollment:
|contactName340B    |contactPhone340B   |contactEmail340B   |
|${contactName340B} |${contactPhone340B}|${contactEmail340B}|
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email     |
|${firstName}|${lastName}|${phoneno}|${email1} |
And To fill the Concact Person Details:
|mi   |fax   |position   |
|${mi}|${fax}|${position}|
When move to 'Out of State Pharmacy Providers' section
Then click on pharmacy currently has any Wyoming Medicaid clients needing services
Then click on pharmacy provides medications not readily supplied by an in-state Wyoming retail or hospital pharmacy
Then click on the Addline in License information
When To fill the Pharmacy License Information for Enrollment:
|drugNcdExample    |
|${drugNcdExample} |
Then click on the Save button
Then click on pharmacy has a Wyoming Board of Pharmacy License or plans to obtain one
Then click on pharmacy is a compounding pharmacy that plans to mail compound prescriptions into the State of Wyoming
When To fill the Pharmacy License Information for Enrollment:
|additionalInformation    |
|${additionalInformation} |
When move to 'Key Personnel' section
Then click on the Addline in License information
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |firstName    |middleName    |lastName   |ssn1   |dob1    |countryOfBirth   |stateOfBirth   |countyOfBirth   |
|${managingEmployeeType} |${firstName} |${middleName} |${lastName}|${ssn1}|${dob1} |${countryOfBirth}|${stateOfBirth1}|${countyOfBirth}|
Then click on the Save button
When move to 'Exclusion/Sanction Information' section
And To fill the Exclusion Sanction Section:
|keyEmployeeCriminalOffenseInAnyState|keyEmployeeLincenseSanctionedRevokedInAnyState|keyEmployeeCivilMoneyUnderAnyState|keyEmployeeSanctionedExcludedAnyState|
|No                                  |No                                            |No                                |No                                   |
When move to 'Upload Documents' section
When implicit wait '2' seconds
When upload the Enrollment document text_file.txt
When implicit wait '5' seconds
When move to 'Authorized Signature' section
When to fill the Title of Person Submitting Enrollment:
|signatureOfPersonSubmittingEnrollment|titleOfPersonSubmittingEnrollment|
|Mrs                                  |${firstName}                     |
When move to 'Authorized Signature' section
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '25' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And proceed to sign
When implicit wait '5' seconds
When click sign application
When implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '5' seconds
Examples:testdata/demoTestData/PharmacyinDocumentReview.table
