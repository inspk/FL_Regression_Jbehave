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

Scenario:Individual Provider Enrollment Flow with Medicaid payment 'No'
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And get random npi from file 'WyNPI'
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
When implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Individual Enrollment type
When implicit wait '5' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|paymentrecived|
|No            |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|title |firstName   |lastName   |gender   |dateOfBirth|countryOfBirth   |stateofBirth   |ssn    |email    |middleName   |degree|
|Mr.   |${firstName}|${lastName}|${gender}|${dob}     |${countryOfBirth}|${stateofBirth}|${ssn} |${email} |${middleName}|D.C.  |
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
|medicaidState|languageSupported|
|No           |English          |
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|personOwnership1|billedEntityOwnership|
|No              |No                   |
When implicit wait '10' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |
|No              |No                      |No      |No           |No                    |No                 |No              |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |suspensionOfLicense |suspensionOfAccreditation |procurementProgram |paymentSuspension |falseClaimsAct |currentOverpayment |
|No                 |No                    |No                  |No                        |No                 |No                |No             |No                 |
When implicit wait '2' seconds
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
When implicit wait '3' seconds
Then save the Program Participation
When implicit wait '3' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set type search value 'Entity' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
When select affliation type 'Individual to Entity'
When fill the effective start '${date}' and effective end '${expDate}' to enrollment end affiliation type page
And implicit wait '3' seconds
When click on 'Yes' to 'Do you want to affiliate with Primary service location' in affiliation popup
And implicit wait '3' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '3' seconds
When select 'In-Person' for Manner of Service in affiliation popup
When select 'Primary Care Provider (PCP)' with '${date}' and '${expDate}' in affiliation popup
And implicit wait '3' seconds
When click on 'Yes' for homelocation in afffiliation popup
When click 'Yes' for Accepting New Patients in affiliation popup
And implicit wait '10' seconds
When click add button in affiliation pop-up
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '10' seconds
When move to 'PCP Addendum' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '10' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When move to new 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '50' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
And move to new 'Payment' section
And implicit wait '5' seconds
When perform personal payment
When implicit wait '10' seconds
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
And implicit wait '10' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
When log out from PE portal
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - nagure.providers+5596@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
Then click on the Message Box in provider enrollment
When implicit wait '10' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '20' seconds
When log out from PE portal
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
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
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
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
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
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
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When search for provider by name '${firstName} ${lastName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
Then rewrite stage of credentials to 'Created' for '$index'
Examples:testdata/SDIndividualProvidersForcustomregression.table