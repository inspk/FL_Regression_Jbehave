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

Scenario:Group Provider Enrollment
Meta:
Given generate firstname, lastname, middlename and email credentials for 'Group1'
And get random npi from file 'SdNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<fein>' to variable 'fein'
And save value '<organizationLegalBusinessName>' to variable 'organizationLegalBusinessName'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<secondaryServiceLocation>' to variable 'secondaryServiceLocation'
And save value '<secondaryServiceLocation>' to variable 'addressLine1'
And save value '<phone>' to variable 'phone'
And save value '<gender>' to variable 'gender'
And save value '<race>' to variable 'race'
And save value '<phoneno>' to variable 'phoneno'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<licenseNumber>' to variable 'licenseNumber'
And save value '<licenseType>' to variable 'licenseType'
And save value '<licenseIssuedState>' to variable 'licenseIssuedState'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<primaryServiceLocationZip>' to variable 'primaryServiceLocationZip'
And save value '<primaryServiceLocationCountyCode>' to variable 'primaryServiceLocationCountyCode'
And save value '<profitStatus>' to variable 'profitStatus'
And save value '<reasonCode>' to variable 'reasonCode'
And save value '<dbaName>' to variable 'dbaName'
And save value '<providerLegalBusinessName>' to variable 'providerLegalBusinessName'
And save value '<attentionLine>' to variable 'attentionLine'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateofBirth>' to variable 'stateofBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<providerID>' to variable 'providerID'
And save value '<phone>' to variable 'applicationContactPhone'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When save current date plus 1 one day to variable end data 'tmrwDate'
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
And fill Phone with value '${phone}' on registration page
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
And user click on Entity Enrollment type
When implicit wait '65' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When select 'To ONLY participate in the network of a Medicaid health plan' for Applicatiion type determination
When implicit wait '5' seconds
Then select 'Facility' for practice type
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |applicationContactPhone|appliationContactName   |email   |dbaName   |differentLegalName |isChangeOwnFein |
|${providerLegalBusinessName}|${fein}                       |${phone}               |${firstName} ${lastName}|${email}|${dbaName}|No                 |No              |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|profitStatus   |taxExempt |
|${profitStatus}|Yes       |
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|291U00000X           |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '20' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Other Credentialing Information                                            |
|Professional Liability Insurance                                           |
|Service Location                                                           |
|Surety Bond                                                                |
|Address Details                                                            |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|EFT Information                                                            |
|Upload Documents                                                           |
|Authorized Signature                                                       |
|Non-Institutional Provider Agreement                                       |
|Summary                                                                    |
Then click on logo
When implicit wait '5' seconds
When click delete application button
When implicit wait '2' seconds
When click on Delete button on Delete application pop-up
When implicit wait '10' seconds
And user click on Entity Enrollment type
When implicit wait '65' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When select 'To ONLY bill for services and receive payment directly from Medicaid' for Applicatiion type determination
When implicit wait '5' seconds
Then select 'Facility' for practice type
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |applicationContactPhone|appliationContactName   |email   |dbaName   |differentLegalName |isChangeOwnFein |
|${providerLegalBusinessName}|${fein}                       |${phone}               |${firstName} ${lastName}|${email}|${dbaName}|No                 |No              |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|profitStatus   |taxExempt |
|${profitStatus}|Yes       |
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|291U00000X           |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '20' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Other Credentialing Information                                            |
|Professional Liability Insurance                                           |
|Service Location                                                           |
|Surety Bond                                                                |
|Address Details                                                            |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|EFT Information                                                            |
|Upload Documents                                                           |
|Authorized Signature                                                       |
|Non-Institutional Provider Agreement                                       |
|Summary                                                                    |
Then click on logo
When implicit wait '5' seconds
When click delete application button
When implicit wait '2' seconds
When click on Delete button on Delete application pop-up
When implicit wait '10' seconds
And user click on Entity Enrollment type
When implicit wait '65' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When select 'To participate in BOTH the network of a Medicaid health plan, as well as to bill for services' for Applicatiion type determination
When implicit wait '5' seconds
Then select 'Facility' for practice type
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |applicationContactPhone|appliationContactName   |email   |dbaName   |differentLegalName |isChangeOwnFein |
|${providerLegalBusinessName}|${fein}                       |${phone}               |${firstName} ${lastName}|${email}|${dbaName}|No                 |No              |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|profitStatus   |taxExempt |
|${profitStatus}|Yes       |
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|291U00000X           |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '20' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Other Credentialing Information                                            |
|Professional Liability Insurance                                           |
|Service Location                                                           |
|Surety Bond                                                                |
|Address Details                                                            |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|EFT Information                                                            |
|Upload Documents                                                           |
|Authorized Signature                                                       |
|Non-Institutional Provider Agreement                                       |
|Summary                                                                    |
Then click on logo
When implicit wait '5' seconds
When click delete application button
When implicit wait '2' seconds
When click on Delete button on Delete application pop-up
When implicit wait '10' seconds
And user click on Entity Enrollment type
When implicit wait '95' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When select 'To ONLY bill for services and receive payment directly from Medicaid' for Applicatiion type determination
When implicit wait '5' seconds
Then select 'Group' for practice type
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |applicationContactPhone|appliationContactName   |email   |dbaName   |differentLegalName |isChangeOwnFein |
|${providerLegalBusinessName}|${fein}                       |${phone}               |${firstName} ${lastName}|${email}|${dbaName}|No                 |No              |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|profitStatus   |taxExempt |
|${profitStatus}|Yes       |
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|225100000X           |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|speciality              |
|PHYSICAL THERAPIST - 091|
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Taxonomy/Speciality/License Certification Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|licenseCertificateType|licenseCertificateNumber|effectiveEndDate2|effectiveStartDate2 |
|HQA                   |12345                   |${expDate}       |${date}             |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Taxonomy/Speciality/License Certification Info section
When implicit wait '5' seconds
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '20' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Other Credentialing Information                                            |
|Professional Liability Insurance                                           |
|Service Location                                                           |
|Address Details                                                            |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|EFT Information                                                            |
|Upload Documents                                                           |
|Authorized Signature                                                       |
|Non-Institutional Provider Agreement                                       |
|Summary                                                                    |
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|2251N0400X           |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Taxonomy/Speciality/License Certification Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|licenseCertificateType|licenseCertificateNumber|effectiveEndDate2|effectiveStartDate2 |
|HQA                   |12345                   |${expDate}       |${date}             |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Taxonomy/Speciality/License Certification Info section
When implicit wait '5' seconds
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '5' seconds
Then verify the '2' taxonomies in Taxonomy/Speciality/License Certification section info
Then Edit taxonomy for '2251N0400X'
When implicit wait '5' seconds
Then click on the 'Edit'
When implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|licenseCertificateNumber|
|786A3545                |
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '10' seconds
Then verify whether the updated License No '786A3545' is displayed in Taxonomy Section
When implicit wait '3' seconds
Then Remove/End taxonomy for '2251N0400X'
When implicit wait '45' seconds
Then verify the '1' taxonomies in Taxonomy/Speciality/License Certification section info
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
When implicit wait '5' seconds
And To fill the Provider Identification Number:
|crossOverApplication|medicaidState|claimSubmit       |
|No                  |No           |Direct Data Entry |
And implicit wait '5' seconds
When move to 'Professional Liability Insurance' section
And implicit wait '5' seconds
When To fill the Proffesional Liability Insurance Info for Enrollment:
|deniedProffesionalLiabilityInsurance|deniedRenewal|malpractice1|unfavourableJudgement|malpracticeCurrentlyPending|mentalOrPhysicalHealthCondition|malPracticeInfo|
|No                                  |No           |No          |No                   |No                         |No                             |No             |
And implicit wait '5' seconds
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
|specialty               |
|PHYSICAL THERAPIST - 091|
When implicit wait '5' seconds
Then select Taxonomy in Program Participation
When implicit wait '15' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '5' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '5' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county   |open24Hours|emergencyServices|patientRecords|personnelRecords|phoneNumberOfPatients|mannerOfService|
|No                  |No    |allCounty|Yes        |No               |Yes           |Yes             |${phoneno}           |In-Person      |
And implicit wait '5' seconds
And To fill the Service Location info:
|wheelChairAccessibility|parkingSpaceForHandicapped|assistiveListeningDevices|accessibleExamRooms|
|No                     |No                        |No                       |No                 |
And implicit wait '5' seconds
Then click new Save button
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1               |attentionLine|email   |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|${secondaryServiceLocation}|${firstName} |${email}|${phoneno} |Yes           |Yes                      |
When implicit wait '5' seconds
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
When implicit wait '15' seconds
When verify the '1' Service locations in Service Location Section
And implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |effectiveStartDate|effectiveEndDate|
|${mailingAddressLine1} |${date}           |${expDate}      |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax          |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '10' seconds
And To fill the Address Details:
|homeOrCorpOfficeAddress|homeOrCorpOfficeContactPersonDetails|
|Yes                    |Yes                                 |
And implicit wait '5' seconds
When click Next button in Address Details
When implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000042' in affiliation section
And implicit wait '5' seconds
When set type search value 'PEM' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
When click add button in affiliation pop-up
And implicit wait '3' seconds
When set npi search value '1356867915' in affiliation section
And implicit wait '5' seconds
When set type search value 'Individual' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When click on 'Do you want to affiliate with Primary service location ?' to 'true' in affiliation popup
And implicit wait '3' seconds
Then select Taxonomy and Provider Type of Entity in Affiliation section
When implicit wait '10' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
When implicit wait '2' seconds
Then click on 'Next' button
When implicit wait '5' seconds
When select '225100000X - PHYSICAL THERAPIST' with '${date}' and '${tmrwDate}' in affiliation popup
And implicit wait '10' seconds
When click add button in affiliation pop-up
And implicit wait '3' seconds
Then edit the details of the 'ENTITY to INDIVIDUAL' provider in Affiliation section
When implicit wait '3' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation
And implicit wait '10' seconds
Then click on the 'Update'
When implicit wait '5' seconds
Then verify whether 'ENTITY to INDIVIDUAL' provider Affiliation Effective end date '${expDate}' is displayed
When implicit wait '5' seconds
Then End Affiliation for 'ENTITY to INDIVIDUAL'
When implicit wait '15' seconds
Then verify the '1' Affiliations in Affiliation Section
When implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |lessThanFivePercent|subcontractorOwnership|entityOwnership|familymembersOwnership|ownersOwnership|personOrEntityOwnership|
|Government - City|No                 |No                    |No             |No                    |No             |No                     |
And To fill the Ownership Section for Enrollment:
|personOwnership|
|Yes            |
When implicit wait '5' seconds
Then click on the Addline
When implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|addressLine1                         |npi   |dateOfBirth|fillSsn |firstName   |lastName   |middleName   |effectiveStartDate|effectiveEndDate|ownershipType|ownershipPercent|relationshipToProvider|
|${primaryServiceLocationAddressLine1}|${npi}|${dob}     |${ssn}  |${firstName}|${lastName}|${middleName}|${yesterdayDate}  |${expDate}      |Direct       |50              |Parent                |
When implicit wait '10' seconds
Then click on the Save button
When implicit wait '5' seconds
When click Next button on Ownership section
When implicit wait '10' seconds
Then verify the popup message 'Overall Ownership percentage should be equal to 100%' is displayed
When implicit wait '5' seconds
Then click on the 'Ok'
When implicit wait '10' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
Then edit the ownership percentage to '100'
When implicit wait '3' seconds
Then click on the Save button
When implicit wait '5' seconds
When click Next button on Ownership section
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |providerID   |npi   |race   |gender   |firstName    |middleName    |lastName    |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${providerID}|${npi}|${race}|${gender}|${lastName}  |${middleName} |${firstName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1          |
|${mailingAddressLine1}|
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When implicit wait '15' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|
|Yes             |
When verify personOwnership1 '${firstName} ${lastName} - ${ssn}' and keypersonal names '${lastName} ${firstName} - ${ssn}' and select the name with text '${firstName} ${lastName} - ${ssn}'
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |convictedFelony|
|No                      |No      |No           |No                    |No                 |No              |No             |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |businessOrProffesionalLicense|suspensionOfAccreditation |suspendedOrExcluded|paymentSuspension |falseClaimsAct |owesMoneyToMedicaid |
|No                 |No                    |No                           |No                        |No                 |No                |No             |No                  |
When implicit wait '2' seconds
When move to 'EFT Information' section
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '2' seconds
Then verify and select the name with text '${firstName} ${lastName} - ${ssn}'
When implicit wait '2' seconds
Then To fill the EFT Information:
|financialInstitution |accountHolderName|EFTRoutingNumber |accountNumber |accountType |startDate |
|Pharma medi ltd      |${firstName}     |123456           |222333444     |Savings     |${date}   |
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
Then verify 'Exclusion/Sanction Documents' field is Added in Upload Documents
When upload new 'Exclusion/Sanction Documents' document text_file.txt
And implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
Then verify the Name with text '${firstName} ${lastName}' and select 'Authorized Signatory Name' in Authorized Signatory section
When implicit wait '5' seconds
When move to new 'Non-Institutional Provider Agreement' section
And implicit wait '10' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName               |
|${firstName} ${lastName}|
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
When new user logs to Provider Enrollment portal with username - dyp.provider+lima@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the group' in message center
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
Then save the tracking number of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for 'Group1'
Examples:testdata/regressiondata/EntityEnrollmentForAllowingSNPI.table
