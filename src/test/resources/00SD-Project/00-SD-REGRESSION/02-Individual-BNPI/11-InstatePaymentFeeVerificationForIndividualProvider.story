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

Scenario:Individual Provider Enrollment Flow to verify Instate payment
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'SdNPI'
And save value '<provider>' to variable 'provider'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<typeOfBusiness>' to variable 'typeOfBusiness'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<phoneno>' to variable 'phoneno'
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
And save value '<stateofBirth>' to variable 'stateofBirth'
And save value '<stateOfBirth>' to variable 'stateOfBirth'
And save value '<reasonCode>' to variable 'reasonCode'
And save value '<businessName>' to variable 'businessName'
And save value '<dbaName>' to variable 'dbaName'
And save value '<attentionLine>' to variable 'attentionLine'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When user navigated to landing page
And implicit wait '5' seconds
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
When implicit wait '5' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '5' seconds
Then click on new user link from the gmail
When implicit wait '5' seconds
Then navigate Back to Login page
When implicit wait '5' seconds
And refresh page
When implicit wait '10' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Individual Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|paymentrecived|
|Yes            |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|title |countryOfBirth   |stateofBirth|
|Mr.   |${countryOfBirth}|0           |
And To fill the identifying information section for Enrollment:
|firstName   |lastName   |gender   |dateOfBirth|ssn    |email    |middleName   |degree|taxExempt |businessName   |dbaName   |
|${firstName}|${lastName}|${gender}|${dob}     |${ssn} |${email} |${middleName}|D.C.  |Yes       |${businessName}|${dbaName}|
When implicit wait '10' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|selectNpi |
|Yes       |
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
When implicit wait '5' seconds
And To fill the Provider Identification Number:
|medicaidState|insurance |claimSubmit       |
|No           |No        |Direct Data Entry |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|personOwnership1|personOrEntityOwnership|subcontractorOwnership|familymembersOwnership|billedEntityOwnership|
|No              |No                     |No                    |No                    |No                   |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on the Addline
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |ssnAddress |
|${managingEmployeeType} |${employeeStatus}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |${address} |
When implicit wait '5' seconds
Then click on the Save button in Key Personel
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
|Pharma medi ltd      |123456           |222333444     |1           |${date}   |
When implicit wait '2' seconds
Then To fill the EFT Information:
|financialInstitution |
|Pharma medi ltd      |
When implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|
|${address}         |
And implicit wait '5' seconds
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax         |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
When click Next button in Address Details
When implicit wait '5' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation       |speciality  |
|Primary Care Provider (PCP)|Physician   |
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                                            |effectiveStartDate|effectiveEndDate|
|207RI0011X - Internal Medicine - Intervention Cardio|${date}           |${expDate}      |
And implicit wait '5' seconds
When click on 'Add License/Certificate' in Program participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|licenseCertificateType|issuer      |licenseCertificateNumber|effectiveEndDate2|effectiveStartDate2 |
|DEA                   |South Dakota|12345                   |${expDate}       |${date}             |
When implicit wait '5' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Program Participation section
When implicit wait '15' seconds
When click on 'Add' in Program participation section
When implicit wait '3' seconds
When click on 'Confirm' in Program participation section
When implicit wait '5' seconds
Then save the Program Participation
When implicit wait '5' seconds
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
And implicit wait '5' seconds
Then select Taxonomy in Program Participation
When implicit wait '5' seconds
And To fill the Program Participation info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save Taxonomy in Program Participation
When implicit wait '5' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '10' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county   |open24Hours|emergencyServices|patientRecords|personnelRecords|phoneNumberOfPatients|mannerOfService|
|No                  |No    |allCounty|Yes        |No               |No            |No              |${phoneno}           |In-Person |
And implicit wait '5' seconds
Then click new Save button
When implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
When move to 'PCP Addendum' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to new 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
And move to new 'Payment' section
And implicit wait '5' seconds
When click On Go to Payment button
And implicit wait '5' seconds
When verify instate payment '200.00' displaying
When perform personal payment
When implicit wait '20' seconds
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
And implicit wait '5' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for '$index'
Examples:testdata/regressiondata/IndividualBNPIEnrollment.table

