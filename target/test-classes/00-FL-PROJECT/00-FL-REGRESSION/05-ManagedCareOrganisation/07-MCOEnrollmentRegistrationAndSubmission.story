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

Scenario:Register and Enroll the MCO Enrollment Provider Flow
Meta:
Given generate firstname, lastname, middlename and email credentials for 'MCO3'
And save value '<fein>' to variable 'fein'
And save value '<gender>' to variable 'gender'
And save value '<taxEntityType>' to variable 'taxEntityType'
And save value '<planLegalName>' to variable 'planLegalName'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<phone>' to variable 'phone'
And save value '<phoneno>' to variable 'phoneno'
And save value '<taxonomyCategory>' to variable 'taxonomyCategory'
And save value '<primaryTaxonomy>' to variable 'primaryTaxonomy'
And save value '<dbaName>' to variable 'dbaName'
And save value '<region>' to variable 'region'
And save value '<attentionLine>' to variable 'attentionLine'
And save value '<managingEmployeeType>' to variable 'managingEmployeeType'
And save value '<primaryServiceLocationAddressLine1>' to variable 'primaryServiceLocationAddressLine1'
And save value '<employeeStatus>' to variable 'employeeStatus'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<countryOfBirth>' to variable 'countryOfBirth'
And save value '<stateofBirth>' to variable 'stateofBirth'
And save value '<phone>' to variable 'applicationContactPhone'
And save value '<providerID>' to variable 'providerID'
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
When implicit wait '5' seconds
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
And user click on Managed Care Organisation Enrollment type
When implicit wait '50' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|planLegalName   |taxEntityType   |federalEmployerIdentification |applicationContactPhone|appliationContactName   |mcoEmail|dbaName   |
|${planLegalName}|${taxEntityType}|${fein}                       |${phone}               |${firstName} ${lastName}|${email}|${dbaName}|
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|284300000X          |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|speciality |
|SIPP - 916 |
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '5' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '5' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email   |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|${primaryServiceLocationAddressLine1}|${firstName} |${email}|${phoneno} |Yes           |Yes                      |
When implicit wait '5' seconds
When click on 'Add Region' in Service Location Section
When implicit wait '5' seconds
And To fill the Service Location info:
|region   |startDate |
|${region}|${date}   |
When implicit wait '5' seconds
Then click on Save Button
When implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1    |effectiveStartDate|effectiveEndDate|
|${mailingAddressLine1} |${date}           |${expDate}      |
And To fill the Concact Person Details:
|attentionLine   |phone     |email    |fax          |ext    |
|Landmark        |${phoneno}|${email} |111-111-1111 |333333 |
And implicit wait '5' seconds
And To fill the Address Details:
|billingAddressHomeOrCorp|billingAddressContactPersonDetailsHomeOrCorp|
|Yes                     |Yes                                         |
And implicit wait '10' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |lessThanFivePercent|personOwnership|entityOwnership|personOrEntityOwnership|subcontractorOwnership|familymembersOwnership|ownersOwnership|
|Government - City|No                 |No             |No             |No                     |No                    |No                    |No             |
When implicit wait '10' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
Then click on the Addline
When implicit wait '5' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType    |employeeStatus   |providerID   |npi   |gender   |firstName    |middleName    |lastName   |ssn    |dob     |countryOfBirth   |stateOfBirth    |ssnStartDate |ssnEndDate |
|${managingEmployeeType} |${employeeStatus}|${providerID}|${npi}|${gender}|${firstName} |${middleName} |${lastName}|${ssn} |${dob}  |${countryOfBirth}|${stateOfBirth} |${date}      |${expDate} |
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
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |convictedFelony|
|No              |No                      |No      |No           |No                    |No                 |No              |No             |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |businessOrProffesionalLicense|suspensionOfAccreditation |suspendedOrExcluded|paymentSuspension |falseClaimsAct |owesMoneyToMedicaid |
|No                 |No                    |No                           |No                        |No                 |No                |No             |No                  |
When implicit wait '5' seconds
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
When click on Proceed To Sign button
And implicit wait '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
When implicit wait '5' seconds
Then save the Tracking Number of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for 'MCO3'
Examples:testdata/regressiondata/ManagedCareOrganisationEnrollment.table

