Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

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
Given generate firstname, lastname, middlename and email credentials for 'TradingPartner1'
And get random npi from file 'SdNPI'
And save value '<dbaName>' to variable 'dbaName'
And save value '<dob>' to variable 'dob'
And save value '<race>' to variable 'race'
And save value '<gender>' to variable 'gender'
And save value '<ssn>' to variable 'ssn'
And save value '<organizationLegalBusinessName>' to variable 'organizationLegalBusinessName'
And save value '<businessName>' to variable 'businessName'
And save value '<fein>' to variable 'fein'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<secondaryServiceLocation>' to variable 'secondaryServiceLocation'
And save value '<phoneno>' to variable 'phoneno'
And save value '<address>' to variable 'address'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<classification>' to variable 'classification'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When save yesterday's date to variable 'yesterdayDate'
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
When implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When skip help tour if exists
And user click on Trading Partner Enrollment type
When implicit wait '30' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Service Location                                                           |
|Address Details                                                            |
|Classification                                                             |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|Authorized Signature                                                       |
|Upload Documents                                                           |
|Provider Agreement                                                         |
|Summary                                                                    |
When implicit wait '5' seconds
When To fill the identify info in the identification section for TP:
|businessName   |dba   |federalEmployerIdentification|email      |
|${businessName}|${dba}|${fein}                      |${email}   |
When implicit wait '5' seconds
When click Next button in Address Details
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
When implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill TP Provider Identification Number:
|tpnpi   |
|${npi}  |
When implicit wait '2' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |Yes           |Yes                      |
When implicit wait '5' seconds
When click on Add Taxonomy/Speciality in Service Location section
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|specialty            |
|Trading Partner - 999|
When implicit wait '5' seconds
Then select Taxonomy in Program Participation
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '5' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '15' seconds
Then click new Save button
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1               |attentionLine|email   |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|${secondaryServiceLocation}|${firstName} |${email}|${phoneno} |Yes           |Yes                      |
When implicit wait '15' seconds
Then click new Save button
When implicit wait '10' seconds
When verify the '2' Service locations in Service Location Section
When Edit Service Location for 'Secondary'
When implicit wait '10' seconds
And To fill the Service Location info:
|locationName     |
|Secondary clinic |
When implicit wait '5' seconds
Then click new Save button
When implicit wait '10' seconds
Then verify whether the updated Location 'Secondary clinic' is displayed in Service Location
When implicit wait '5' seconds
Then Remove/End Service Location for 'Secondary'
When implicit wait '5' seconds
When verify the '1' Service locations in Service Location Section
And implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|effectiveStartDate|effectiveEndDate|
|${address}         |${date}           |${expDate}      |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |ext    |
|Landmark        |${phoneno}|${email} |333333 |
And To fill the Address Details:
|homeOrCorpOfficeAddress|homeOrCorpAddressContactPersonDetails|
|Yes                    |Yes                                  |
And implicit wait '5' seconds
And To fill the Address Details:
|serviceLocOfcAddress|serviceLocOfcContactPersonDetails|
|Yes                 |Yes                              |
And implicit wait '5' seconds
When click Next button in Address Details
When implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When To fill the Classification Section:
|classification   |softwareVendorName|softwareName|versionId|entityCode|
|${classification}|ANDERSON INC      |SD-Printer  |v2.0     |Kermit    |
When implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '2' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000177' in affiliation section
And implicit wait '5' seconds
When set type search value 'Individual' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
When implicit wait '2' seconds
Then click on 'Next' button
When implicit wait '5' seconds
When select '103TF0000X - PSYCHOLOGIST - FAMILY' with '${date}' and '${expDate}' in affiliation popup
And implicit wait '3' seconds
When click add button in affiliation pop-up
And implicit wait '5' seconds
When set providerid search value '4000106' in affiliation section
And implicit wait '5' seconds
When set type search value 'Entity' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
When implicit wait '2' seconds
Then click on 'Next' button
When implicit wait '5' seconds
When select '291U00000X - CLINICAL MEDICAL LABORATORY' with '${date}' and '${expDate}' in affiliation popup
And implicit wait '3' seconds
When click add button in affiliation pop-up
And implicit wait '3' seconds
Then verify the '2' Affiliations in Affiliation Section
When implicit wait '5' seconds
Then End Affiliation for 'TP to ENTITY'
When implicit wait '10' seconds
Then verify the '1' Affiliations in Affiliation Section
When implicit wait '5' seconds
When move to 'Ownership' section
When implicit wait '2' seconds
And To fill the Ownership Section for Enrollment:
|personOwnership1|
|Yes             |
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|addressLine1                         |fein   |ownershipnpi|dbaName   |organizationLegalBusinessName   |selectProgram|effectiveStartDate|effectiveEndDate|
|${primaryServiceLocationAddressLine1}|${fein}|${npi}      |${dbaName}|${organizationLegalBusinessName}|Medicaid     |${yesterdayDate}  |${expDate}      |
When implicit wait '15' seconds
Then click on the Save button
When implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|billedEntityOwnership|
|No                   |
When implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '5' seconds
Then click on the Addline
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |race   |gender   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${race}|${gender}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |${address} |
When implicit wait '15' seconds
Then click on the Save button
When implicit wait '2' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|
|Yes             |
And implicit wait '5' seconds
When verify personOwnership1 '${organizationLegalBusinessName} - ${fein}' and keypersonal names '${firstName} ${lastName} - ${ssn}' and select the name with text '${organizationLegalBusinessName} - ${fein}'
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |convictedFelony|
|No                      |No      |No           |No                    |No                 |No              |No             |
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionExclusion |suspensionOfLicense|suspensionOfAccreditation |currentPayment    |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                 |No                        |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
Then verify the Name with text '${firstName} ${lastName}' and select 'Authorized Signatory' in Authorized Signatory section
When implicit wait '5' seconds
When move to new 'Provider Agreement' section
And implicit wait '10' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |
|${firstName}|
Then Agree Term and conditions to Sign
When submit enrollment application
And implicit wait '5' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - dyp.provider+bannerone@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the TP' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '40' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Proceed To Sign button
And implicit wait '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
When implicit wait '15' seconds
Then save the Tracking Number of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for '<index>'
Examples:testdata/CustomSDtradingPartner.table