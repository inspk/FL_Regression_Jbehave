Meta:

Narrative:
As the Entity provider,
In CoC, I can add affiliation with individual providers
with the service location and program participation, taxonomy,
and license details of individual provider

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
And user click on Entity Enrollment type
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
Then To fill the EFT Information:
|financialInstitution |
|Pharma medi ltd      |
When implicit wait '2' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |
|Landmark        |${phoneno}|${email} |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|fax         |ext    |
|111-111-1111|333333 |
And implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation       |speciality  |
|Primary Care Provider (PCP)|Group       |
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                            |effectiveStartDate|effectiveEndDate|
|193200000X - Group - Multi-Specialty|${date}           |${expDate}      |
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
|programParticipation       |
|Primary Care Provider (PCP)|
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
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|phoneNumberOfPatients|mannerOfService|
|No                  |No    |None  |Yes        |No               |No            |No              |${phoneno}           |In-Person      |
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
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
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
|providerIDorName        |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
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
|providerIDorName        |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
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
|providerIDorName        |
|${providerLegalBusinessName}}|
When search for provider by name '${providerLegalBusinessName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When log out from IU portal
When implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on Yes to waive Site Visit
And implicit wait '5' seconds
When select reason 'Invalid Site Visit' and 'invalid site visit' create site visit popup
And implicit wait '5' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+lewis.wood@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'Group1'
Examples:
|index  |providerLegalBusinessName |dbaName|dob       |ssn          |fein      |mailingAddressLine1|mailingAddressZip|mailingAddressCountycode|phone        |taxonomyCategory|primaryTaxonomy          |licenseNumber|licenseType|licenseIssuedState|primaryServiceLocationAddressLine1|primaryServiceLocationZip|primaryServiceLocationCountyCode|groupClaimSubmit                |secondaryServiceLocationAddressLine1|profitStatus          |reasonCode |phoneno   |managingEmployeeType |employeeStatus         |countryOfBirth|stateofBirth|stateOfBirth |
|Group1 |VIP Community Services    |Clinic |10/11/1980|456-76-545111|2262618066|2321 DUNN AV       |33110-4343       |11130                   |(245)357-5678|Interpreter     |171R00000X -  Interpreter|1864655944   |License    |California        |2321 DUNN AV                      |33310-2345               |33140                           |Electronic Data Interchange EDI |19 Wyarno Rd, Sheridan WY           |Non-Profit 501(C)(3)  |3          |3456789098|Manager              |Managing Non Convicted |United States |0           |Alabama      |




Scenario:Coc affiliation with Individual
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
And close informational pop-up
And implicit wait '3' seconds
And click on CoC tab on header
And implicit wait '3' seconds
When click on Change request button on Coc page
And implicit wait '5' seconds
When select add affiliation type in coc pop-up
When click create button in select coc type pop-up
When move to new 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
When click on 'Yes' to the question 'Do you want to affiliate with Individual Providers?'
When set DOB search value '10/11/1980' in affiliation section
When set SSN search value '456-76-5451' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When select affliation type 'Group to Individual'
When fill the effective start '${date}' and effective end '${expDate}' to enrollment end affiliation type page
And implicit wait '3' seconds
When click on 'Yes' to 'Do you want to affiliate with Primary service location' in affiliation popup
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '3' seconds
When select 'In-Person' for Manner of Service in affiliation popup
When select 'Primary Care Provider (PCP)' with '${date}' and '${expDate}' in affiliation popup
And implicit wait '3' seconds
When click on 'Yes' for homelocation in afffiliation popup
When click 'Yes' for Accepting New Patients in affiliation popup
And implicit wait '10' seconds
When click add button in affiliation pop-up
When implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When sign/submit application
And implicit wait '15' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '25' seconds
When click navigate to dashboard link after sign
And implicit wait '15' seconds
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'Group1'
