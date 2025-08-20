Meta:

Narrative:
Entity Enrollment form - As the SD registered Entity,
I want to capture the addendum for entity enrollment form in a format
so that it meets the SD need.


Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Group Provider Enrollment Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<fein>' to variable 'fein'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<phone>' to variable 'phone'
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
And save value '<addendum>' to variable 'addendum'
And save value '<programParticipation>' to variable 'programParticipation'
And save value '<speciality>' to variable 'speciality'
And save value '<programParticipationTaxonomy>' to variable 'programParticipationTaxonomy'
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
And user click on Group Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |email   |dbaName   |differentLegalName |isChangeOwnFein |profitStatus   |taxExempt |fiscalEnd |
|${providerLegalBusinessName}|${fein}                       |${email}|${dbaName}|No                 |No              |${profitStatus}|Yes       |5         |
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicareParticipant|medicaidState |medicalDirector |teachingFacility |indianHealthServices |groupClaimSubmit                |
|No                 |No            |No              |No               |No                   |Electronic Data Interchange EDI |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |personOwnership|entityOwnership|personOrEntityOwnership|corporationOwnership|partnershipOwnership|subcontractorOwnership|familymembersOwnership|ownersOwnership|
|Government - City|No             |No             |No                     |No                  |No                  |No                    |No                    |No             |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on Addline for 'Other Managing Employee Type' in Key Personnel section
When implicit wait '2' seconds
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1          |
|${mailingAddressLine1}|
When implicit wait '2' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
Then click on the Save button
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |
|No              |No                      |No      |No           |No                    |No                 |No              |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionOfLicense |suspensionOfAccreditation |procurementProgram |paymentSuspension |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                        |No                 |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'EFT Information' section
Then To fill the EFT Information:
|financialInstitution |EFTRoutingNumber |accountNumber |accountType |startDate |
|Pharma medi ltd      |123456           |8888          |1           |${date}   |
When implicit wait '2' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Taxonomy / License Information' section
And implicit wait '5' seconds
And To fill the Licensure Section for Enrollment:
|taxonomyCategory    |
|${taxonomyCategory} |
When to select the primary taxonomy options '${primaryTaxonomy}'
When implicit wait '5' seconds
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |fax          |ext    |
|${firstName}|${lastName}|${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation   |speciality   |
|${programParticipation}|${speciality}|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                       |effectiveStartDate|effectiveEndDate|
|${programParticipationTaxonomy}|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Confirm' in Program participation section
When implicit wait '3' seconds
Then save the Program Participation
When implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |
When implicit wait '5' seconds
When click on Add Program Participation in Service Location section
And To fill the Program Participation info:
|programParticipation   |
|${programParticipation}|
And implicit wait '3' seconds
Then select Taxonomy in Program Participation
When implicit wait '3' seconds
And To fill the Program Participation info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '3' seconds
Then save Taxonomy in Program Participation
When implicit wait '5' seconds
When upload document 'Claims Documents' document text_file.txt in Service Location Claim Section
When implicit wait '2' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|
|No                  |No    |None  |Yes        |No               |No            |No              |
And implicit wait '5' seconds
When click on 'Save' in Service Location section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|
When implicit wait '10' seconds
When click on 'Save' in Service Location section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
When implicit wait '10' seconds
When move to '${addendum}' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user titel & '${firstName} ${lastName}'
And implicit wait '20' seconds
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
And implicit wait '10' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When log out from PE portal
Examples:
|index         |providerLegalBusinessName  |dbaName|dob       |ssn          |fein      |mailingAddressLine1|mailingAddressZip|mailingAddressCountycode|phone        |taxonomyCategory|primaryTaxonomy          |licenseNumber|licenseType|licenseIssuedState|primaryServiceLocationAddressLine1|primaryServiceLocationZip|primaryServiceLocationCountyCode|groupClaimSubmit                |secondaryServiceLocationAddressLine1|profitStatus          |reasonCode |phoneno   |managingEmployeeType |employeeStatus         |countryOfBirth|stateofBirth|stateOfBirth |addendum                      |programParticipationTaxonomy                           |programParticipation|speciality    |
|GroupAdendum1 |COMMUNITY HEALTH CENTER    |Clinic |10/11/1980|456-76-545111|2262618066|2321 DUNN AV       |33110-4343       |11130                   |(245)357-5678|Interpreter     |171R00000X -  Interpreter|1864655944   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Community Health Worker Agency|172V00000X - Community Health Worker Agency            |Medicaid/CHIP       |Agencies (Not specified elsewhere)|


Meta:

Narrative:
Entity Enrollment form - As the SD registered Entity,
I want to capture the addendum for entity enrollment form in a format
so that it meets the SD need.


Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds


Scenario:Group Provider Enrollment Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<fein>' to variable 'fein'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<phone>' to variable 'phone'
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
And save value '<addendum>' to variable 'addendum'
And save value '<programParticipation>' to variable 'programParticipation'
And save value '<speciality>' to variable 'speciality'
And save value '<programParticipationTaxonomy>' to variable 'programParticipationTaxonomy'
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
And user click on Group Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |email   |dbaName   |differentLegalName |isChangeOwnFein |profitStatus   |taxExempt |fiscalEnd |
|${providerLegalBusinessName}|${fein}                       |${email}|${dbaName}|No                 |No              |${profitStatus}|Yes       |5         |
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicareParticipant|medicaidState |medicalDirector |teachingFacility |indianHealthServices |groupClaimSubmit                |
|No                 |No            |No              |No               |No                   |Electronic Data Interchange EDI |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |personOwnership|entityOwnership|personOrEntityOwnership|corporationOwnership|partnershipOwnership|subcontractorOwnership|familymembersOwnership|ownersOwnership|
|Government - City|No             |No             |No                     |No                  |No                  |No                    |No                    |No             |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on Addline for 'Other Managing Employee Type' in Key Personnel section
When implicit wait '2' seconds
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1          |
|${mailingAddressLine1}|
When implicit wait '2' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
Then click on the Save button
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |
|No              |No                      |No      |No           |No                    |No                 |No              |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionOfLicense |suspensionOfAccreditation |procurementProgram |paymentSuspension |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                        |No                 |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'EFT Information' section
Then To fill the EFT Information:
|financialInstitution |EFTRoutingNumber |accountNumber |accountType |startDate |
|Pharma medi ltd      |123456           |8888          |1           |${date}   |
When implicit wait '2' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Taxonomy / License Information' section
And implicit wait '5' seconds
And To fill the Licensure Section for Enrollment:
|taxonomyCategory    |
|${taxonomyCategory} |
When to select the primary taxonomy options '${primaryTaxonomy}'
When implicit wait '5' seconds
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |fax          |ext    |
|${firstName}|${lastName}|${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation   |speciality   |
|${programParticipation}|${speciality}|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                       |effectiveStartDate|effectiveEndDate|
|${programParticipationTaxonomy}|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Program participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|licenseCertificateType                    |issuer      |effectiveEndDate2|effectiveStartDate2 |licenseCertificateNumber|
|Psychiatric Residential Treatment Facility|South Dakota|${expDate}       |${date}             |12345                   |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Program Participation section
When implicit wait '15' seconds
When click on 'Add' in Program participation section
When implicit wait '3' seconds
When click on 'Confirm' in Program participation section
When implicit wait '3' seconds
Then save the Program Participation
When implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |
When implicit wait '5' seconds
When click on Add Program Participation in Service Location section
And To fill the Program Participation info:
|programParticipation   |
|${programParticipation}|
And implicit wait '3' seconds
Then select Taxonomy in Program Participation
When implicit wait '3' seconds
And To fill the Program Participation info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '3' seconds
Then save Taxonomy in Program Participation
When implicit wait '5' seconds
And To fill the Service Location info:
|isNpiUsed|isScriptSupplier|
|Yes      |Yes             |
When implicit wait '5' seconds
When upload document 'Claims Documents' document text_file.txt in Service Location Claim Section
When implicit wait '2' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|
|No                  |No    |None  |Yes        |No               |No            |No              |
And implicit wait '5' seconds
When click on 'Save' in Service Location section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|
When implicit wait '10' seconds
When click on 'Save' in Service Location section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
When implicit wait '10' seconds
When move to '${addendum}' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user titel & '${firstName} ${lastName}'
And implicit wait '20' seconds
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
And implicit wait '10' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When log out from PE portal
Examples:
|index         |providerLegalBusinessName  |dbaName|dob       |ssn          |fein      |mailingAddressLine1|mailingAddressZip|mailingAddressCountycode|phone        |taxonomyCategory|primaryTaxonomy          |licenseNumber|licenseType|licenseIssuedState|primaryServiceLocationAddressLine1|primaryServiceLocationZip|primaryServiceLocationCountyCode|groupClaimSubmit                |secondaryServiceLocationAddressLine1|profitStatus          |reasonCode |phoneno   |managingEmployeeType |employeeStatus         |countryOfBirth|stateofBirth|stateOfBirth |addendum                      |programParticipationTaxonomy                           |programParticipation|speciality    |
|GroupAdendum2 |ABBOTT HOUSE INC           |Clinic |10/11/1985|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|4525342523   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Psych Attestation             |323P00000X - Psychiatric Residential Treatment Facility|Medicaid/CHIP       |Mental Health & Substance Treatment Facilities|

Meta:

Narrative:
Entity Enrollment form - As the SD registered Entity,
I want to capture the addendum for entity enrollment form in a format
so that it meets the SD need.


Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds


Scenario:Group Provider Enrollment Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<fein>' to variable 'fein'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<phone>' to variable 'phone'
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
And save value '<addendum>' to variable 'addendum'
And save value '<programParticipation>' to variable 'programParticipation'
And save value '<speciality>' to variable 'speciality'
And save value '<programParticipationTaxonomy>' to variable 'programParticipationTaxonomy'
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
And user click on Group Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |email   |dbaName   |differentLegalName |isChangeOwnFein |profitStatus   |taxExempt |fiscalEnd |
|${providerLegalBusinessName}|${fein}                       |${email}|${dbaName}|No                 |No              |${profitStatus}|Yes       |5         |
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicareParticipant|medicaidState |medicalDirector |teachingFacility |indianHealthServices |groupClaimSubmit                |
|No                 |No            |No              |No               |No                   |Electronic Data Interchange EDI |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |personOwnership|entityOwnership|personOrEntityOwnership|corporationOwnership|partnershipOwnership|subcontractorOwnership|familymembersOwnership|ownersOwnership|
|Government - City|No             |No             |No                     |No                  |No                  |No                    |No                    |No             |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on Addline for 'Other Managing Employee Type' in Key Personnel section
When implicit wait '2' seconds
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1          |
|${mailingAddressLine1}|
When implicit wait '2' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
Then click on the Save button
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |
|No              |No                      |No      |No           |No                    |No                 |No              |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionOfLicense |suspensionOfAccreditation |procurementProgram |paymentSuspension |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                        |No                 |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'EFT Information' section
Then To fill the EFT Information:
|financialInstitution |EFTRoutingNumber |accountNumber |accountType |startDate |
|Pharma medi ltd      |123456           |8888          |1           |${date}   |
When implicit wait '2' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Taxonomy / License Information' section
And implicit wait '5' seconds
And To fill the Licensure Section for Enrollment:
|taxonomyCategory    |
|${taxonomyCategory} |
When to select the primary taxonomy options '${primaryTaxonomy}'
When implicit wait '5' seconds
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |fax          |ext    |
|${firstName}|${lastName}|${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation   |speciality   |
|${programParticipation}|${speciality}|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                       |effectiveStartDate|effectiveEndDate|
|${programParticipationTaxonomy}|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Confirm' in Program participation section
When implicit wait '3' seconds
Then save the Program Participation
When implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |
When implicit wait '5' seconds
When click on Add Program Participation in Service Location section
And To fill the Program Participation info:
|programParticipation   |
|${programParticipation}|
And implicit wait '3' seconds
Then select Taxonomy in Program Participation
When implicit wait '3' seconds
And To fill the Program Participation info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '3' seconds
Then save Taxonomy in Program Participation
When implicit wait '5' seconds
And To fill the Service Location info:
|officeLocation |
|No             |
When implicit wait '5' seconds
When upload document 'Claims Documents' document text_file.txt in Service Location Claim Section
When implicit wait '2' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|
|No                  |No    |None  |Yes        |No               |No            |No              |
And implicit wait '5' seconds
When click on 'Save' in Service Location section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|
When implicit wait '10' seconds
When click on 'Save' in Service Location section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
When implicit wait '10' seconds
When move to '${addendum}' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user titel & '${firstName} ${lastName}'
And implicit wait '20' seconds
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
And implicit wait '10' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When log out from PE portal
Examples:
|index         |providerLegalBusinessName  |dbaName|dob       |ssn          |fein      |mailingAddressLine1|mailingAddressZip|mailingAddressCountycode|phone        |taxonomyCategory|primaryTaxonomy          |licenseNumber|licenseType|licenseIssuedState|primaryServiceLocationAddressLine1|primaryServiceLocationZip|primaryServiceLocationCountyCode|groupClaimSubmit                |secondaryServiceLocationAddressLine1|profitStatus          |reasonCode |phoneno   |managingEmployeeType |employeeStatus         |countryOfBirth|stateofBirth|stateOfBirth |addendum                      |programParticipationTaxonomy                           |programParticipation|speciality    |
|GroupAdendum3 |PIERRE SCHOOL DISTRICT     |Clinic |04/29/1992|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|8703453254   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |School District               |251300000X - Local Education Agency (School District)  |Medicaid/CHIP       |School        |


Meta:

Narrative:
Entity Enrollment form - As the SD registered Entity,
I want to capture the addendum for entity enrollment form in a format
so that it meets the SD need.


Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds


Scenario:Group Provider Enrollment Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
And save value '<providerName>' to variable 'providerName'
And save value '<fein>' to variable 'fein'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save value '<mailingAddressCountycode>' to variable 'mailingAddressCountycode'
And save value '<phone>' to variable 'phone'
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
And save value '<addendum>' to variable 'addendum'
And save value '<programParticipation>' to variable 'programParticipation'
And save value '<speciality>' to variable 'speciality'
And save value '<programParticipationTaxonomy>' to variable 'programParticipationTaxonomy'
And save value '<licenseCertificationType>' to variable 'licenseCertificationType'
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
And user click on Group Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|providerLegalBusinessName   |federalEmployerIdentification |email   |dbaName   |differentLegalName |isChangeOwnFein |profitStatus   |taxExempt |fiscalEnd |
|${providerLegalBusinessName}|${fein}                       |${email}|${dbaName}|No                 |No              |${profitStatus}|Yes       |5         |
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicareParticipant|medicaidState |medicalDirector |teachingFacility |indianHealthServices |groupClaimSubmit                |
|No                 |No            |No              |No               |No                   |Electronic Data Interchange EDI |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |personOwnership|entityOwnership|personOrEntityOwnership|corporationOwnership|partnershipOwnership|subcontractorOwnership|familymembersOwnership|ownersOwnership|
|Government - City|No             |No             |No                     |No                  |No                  |No                    |No                    |No             |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on Addline for 'Other Managing Employee Type' in Key Personnel section
When implicit wait '2' seconds
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1          |
|${mailingAddressLine1}|
When implicit wait '2' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
Then click on the Save button
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |
|No              |No                      |No      |No           |No                    |No                 |No              |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionOfLicense |suspensionOfAccreditation |procurementProgram |paymentSuspension |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                        |No                 |No                |No             |No                 |
When implicit wait '2' seconds
When move to 'EFT Information' section
Then To fill the EFT Information:
|financialInstitution |EFTRoutingNumber |accountNumber |accountType |startDate |
|Pharma medi ltd      |123456           |8888          |1           |${date}   |
When implicit wait '2' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Taxonomy / License Information' section
And implicit wait '5' seconds
And To fill the Licensure Section for Enrollment:
|taxonomyCategory    |
|${taxonomyCategory} |
When to select the primary taxonomy options '${primaryTaxonomy}'
When implicit wait '5' seconds
When move to 'Primary Service Location Information' section
And To fill the Service Location Billing info:
|primaryServiceLocationAddressLine1    |
|${primaryServiceLocationAddressLine1} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |phone     |email    |fax          |ext    |
|${firstName}|${lastName}|${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation   |speciality   |
|${programParticipation}|${speciality}|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                       |effectiveStartDate|effectiveEndDate|
|${programParticipationTaxonomy}|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Program participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|licenseCertificateType     |issuer      |effectiveEndDate2|effectiveStartDate2 |licenseCertificateNumber|
|${licenseCertificationType}|South Dakota|${expDate}       |${date}             |12345                   |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Program Participation section
When implicit wait '15' seconds
When click on 'Add' in Program participation section
When implicit wait '3' seconds
When click on 'Confirm' in Program participation section
When implicit wait '3' seconds
Then save the Program Participation
When implicit wait '3' seconds
When move to '${addendum}' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |
When implicit wait '5' seconds
When click on Add Program Participation in Service Location section
And To fill the Program Participation info:
|programParticipation   |
|${programParticipation}|
And implicit wait '3' seconds
Then select Taxonomy in Program Participation
When implicit wait '3' seconds
And To fill the Program Participation info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '3' seconds
Then save Taxonomy in Program Participation
!-- When implicit wait '5' seconds
!-- And To fill the Service Location info:
!-- |officeLocation |
!-- |No             |
When implicit wait '5' seconds
When upload document 'Claims Documents' document text_file.txt in Service Location Claim Section
When implicit wait '2' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|
|No                  |No    |None  |Yes        |No               |No            |No              |
And implicit wait '5' seconds
When click on 'Save' in Service Location section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|
When implicit wait '10' seconds
When click on 'Save' in Service Location section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
When implicit wait '10' seconds
When move to new 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user titel & '${firstName} ${lastName}'
And implicit wait '20' seconds
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
And implicit wait '10' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When log out from PE portal
Examples:
|index         |providerLegalBusinessName  |dbaName|dob       |ssn          |fein      |mailingAddressLine1|mailingAddressZip|mailingAddressCountycode|phone        |taxonomyCategory|primaryTaxonomy          |licenseNumber|licenseType|licenseIssuedState|primaryServiceLocationAddressLine1|primaryServiceLocationZip|primaryServiceLocationCountyCode|groupClaimSubmit                |secondaryServiceLocationAddressLine1|profitStatus          |reasonCode |phoneno   |managingEmployeeType |employeeStatus         |countryOfBirth|stateofBirth|stateOfBirth |addendum                      |programParticipationTaxonomy                           |programParticipation|speciality    |licenseCertificationType|
|GroupAdendum4 |ALCESTER AMBULANCE SERVICE |Clinic |04/29/1992|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|8703453254   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Transportation Attestation    |3416L0300X - Ambulance - Ground                        |Medicaid/CHIP       |Transportation|Ambulance license       |
|GroupAdendum5 |OGLALA LAKOTA AIR RESCUE   |Clinic |04/29/1992|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|8703453254   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Transportation Attestation    |3416A0800X - Ambulance - Air                           |Medicaid/CHIP       |Transportation|Ambulance license       |
|GroupAdendum6 |KSL TRANSPORTATION LLC     |Clinic |04/29/1992|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|8703453254   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Transportation Attestation    |343800000X - Secured Transportation - Non-Emergent     |Medicaid/CHIP       |Transportation|N/A                     |
|GroupAdendum7 |CEDAR MOBILITY LLC         |Clinic |04/29/1992|322-43-342323|3523324332|2321 DUNN AV       |33110-4343       |11130                   |(113)231-3322|Interpreter     |171R00000X -  Interpreter|8703453254   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |Transportation Attestation    |343900000X - Community Transportation                  |Medicaid/CHIP       |Transportation|N/A                     |
