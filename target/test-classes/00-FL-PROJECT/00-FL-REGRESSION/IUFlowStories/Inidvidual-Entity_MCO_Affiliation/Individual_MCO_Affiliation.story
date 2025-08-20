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

Scenario:Individual Provider Enrollment Flow
Meta:
Given generate firstname, lastname, middlename and email credentials for 'Individual2'
And get random npi from file 'SdNPI'
And save value '<provider>' to variable 'provider'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<race>' to variable 'race'
And save value '<ssn>' to variable 'ssn'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<phoneno>' to variable 'phoneno'
And save value '<phoneno>' to variable 'applicationContactNum'
And save value '<address>' to variable 'address'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<licenseNumber>' to variable 'licenseNumber'
And save value '<licenseType>' to variable 'licenseType'
And save value '<licenseIssuedState>' to variable 'licenseIssuedState'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<primaryServiceLocationZip>' to variable 'primaryServiceLocationZip'
And save value '<primaryServiceLocationCountyCode>' to variable 'primaryServiceLocationCountyCode'
And save value '<profitStatus>' to variable 'profitStatus'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<stateOfBirth>' to variable 'stateofBirth'
And save value '<reasonCode>' to variable 'reasonCode'
And save value '<businessName>' to variable 'businessName'
And save value '<dbaName>' to variable 'dbaName'
And save value '<attentionLine>' to variable 'attentionLine'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save value '<providerID>' to variable 'providerID'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When save yesterday's date to variable 'yesterdayDate'
When user navigated to landing page
When implicit wait '5' seconds
When click create account link in the landing page
And wait for screening process execution during '5' seconds
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
When implicit wait '15' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Individual Enrollment type
When implicit wait '50' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When select 'To ONLY bill for services and receive payment directly from Medicaid' for Applicatiion type determination
When implicit wait '5' seconds
Then select 'SOLE PROPRIETOR' for practice type
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|title |countryOfBirth   |stateofBirth   |
|Mr.   |${countryOfBirth}|${stateOfBirth}|
And To fill the identifying information section for Enrollment:
|firstName   |lastName   |gender   |dateOfBirth|appliationContactName   |applicationContactNum|ssn    |email    |middleName   |taxExempt |businessName   |dbaName   |
|${firstName}|${lastName}|${gender}|${dob}     |${firstName} ${lastName}|${phoneno}           |${ssn} |${email} |${middleName}|Yes       |${businessName}|${dbaName}|
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|22510000X            |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Taxonomy/Speciality/License Certification Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|licenseCertificateType|licenseCertificateNumber|effectiveEndDate2|effectiveStartDate2 |
|DOH                   |12345                   |${expDate}       |${date}             |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Taxonomy/Speciality/License Certification Info section
When implicit wait '5' seconds
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
When implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicareCrossoverClaim|medicaidState|claimSubmit       |
|No                    |No           |Direct Data Entry |
And implicit wait '5' seconds
When move to 'Other Credentialing Information' section
And implicit wait '5' seconds
Then click on the Add Line
When implicit wait '5' seconds
When To fill the Other Credentialing Information Info for Enrollment:
|typeOfTraining|organizationName|effectiveStartDate|effectiveEndDate|
|Internship    |Mediplus        |${date}           |${expDate}      |
When implicit wait '5' seconds
When upload document 'Upload Training Document' document text_file.txt in Other Credentialing Information Info section
When implicit wait '5' seconds
Then click on the Save button
When implicit wait '5' seconds
When click on the Add line
When implicit wait '5' seconds
When To fill the Other Credentialing Information Info for Enrollment:
|gradutaionType    |medicalSchool|professionalSchoolName|professionalSchoolAddress|
|US/Canada Graduate|Yes          |CANVAS CAMPUS         |${address}               |
When implicit wait '5' seconds
Then click on the Save button
When implicit wait '15' seconds
When move to 'Employment Authorization Information' section
When implicit wait '5' seconds
When To fill the Employment Authorization Information for Enrollment:
|usCitizen|
|Yes      |
When implicit wait '2' seconds
When move to 'Professional Liability Insurance Information' section
And implicit wait '5' seconds
When To fill the Proffesional Liability Insurance Info for Enrollment:
|deniedProffesionalLiabilityInsurance|deniedRenewal|malpractice1|unfavourableJudgement|malpracticeCurrentlyPending|mentalOrPhysicalHealthCondition|malPracticeInfo|malPracticeHealthInfo|
|No                                  |No           |No          |No                   |No                        |No                             |No             |No                   |
When implicit wait '5' seconds
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
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '5' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '5' seconds
When upload document 'Claims Documents' document text_file.txt in Service Location Claim Section
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
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|effectiveStartDate|effectiveEndDate|
|${address}         |${date}           |${expDate}      |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And To fill the Address Details:
|homeOrCorpOfficeAddress|homeOrCorpOfficeContactPersonDetails|
|Yes                    |Yes                                 |
And implicit wait '5' seconds
When click Next button in Address Details
When implicit wait '5' seconds
Then affiliate 'Individual' with provider of '$plantype'
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|personOwnership1|personOrEntityOwnership|subcontractorOwnership|familymembersOwnership|billedEntityOwnership|
|No              |No                     |No                    |No                    |No                   |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '2' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |providerID   |npi   |race   |gender   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${providerID}|${npi}|${race}|${gender}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |${address} |
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When implicit wait '15' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |convictedFelony|
|No              |No                      |No      |No           |No                    |No                 |No              |No             |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |businessOrProffesionalLicense|suspensionOfAccreditation|suspendedOrExcluded|paymentSuspension |falseClaimsAct |owesMoneyToMedicaid|
|No                 |No                    |No                           |No                       |No                 |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'EFT Information' section
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '5' seconds
Then select 'Name of the Authorized Person' in EFT Information Section
When implicit wait '2' seconds
Then To fill the EFT Information:
|financialInstitution |accountHolderName|EFTRoutingNumber |accountNumber |accountType |startDate       |
|Pharma medi ltd      |${firstName}     |123456           |222333444     |Savings     |${yesterdayDate}|
When implicit wait '2' seconds
When upload file 'EFT supporting Document' document text_file.txt
When implicit wait '5' seconds
Then click on the Save button in Key Personel
When implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '5' seconds
When move to 'Authorized Signatory' section
And implicit wait '5' seconds
Then select 'Authorized Signatory Name' in Authorized Signatory section
When implicit wait '5' seconds
When move to new 'Provider Agreement' section
And implicit wait '10' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '40' seconds
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
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - johny.providers+68031@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the individual' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Proceed To Sign button
And implicit wait '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
When implicit wait '5' seconds
Then save the tracking number of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for 'Individual2'
Examples:testdata/regressiondata/IndividualBNPIEnrollment.table


