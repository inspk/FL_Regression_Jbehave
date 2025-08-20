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
Given generate firstname, lastname, middlename and email credentials for 'MCO'
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
And fill Phone with value '9876543256' on registration page
When implicit wait '5' seconds
When click on create account link in the registartion page
When implicit wait '5' seconds
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
When implicit wait '20' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|planLegalName   |taxEntityType                        |federalEmployerIdentification |applicationContactPhone  |appliationContactName   |mcoEmail      |
|planLegal       |Corporation/Professional Organization|876543278                     |4567897643               |John Dezouzer           |test@gmail.com|
When implicit wait '10' seconds
Then fill in plantype field with value 'Serious Mental Illness'
When implicit wait '5' seconds
Then fill in grouptype field with value 'Community Care Plan'
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '10' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '10' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|322D00000X           |
And implicit wait '10' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '10' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '10' seconds
When move to 'Service Location' section
When implicit wait '10' seconds
When click on Add Location in Service Location section
When implicit wait '10' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1                         |attentionLine|email         |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|100                                  |John         |test@gmail.com|8765487654 |Yes           |Yes                      |
When implicit wait '10' seconds
When click on Add Taxonomy/Speciality in Service Location section
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|specialty                                           |
|FREESTANDING PSYCHIATRIC HOSPITAL FOR CHILDREN - 300|
When implicit wait '10' seconds
Then select Taxonomy in Program Participation
When implicit wait '10' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '20' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '30' seconds
When click on 'Add Region' in Service Location Section
And To fill the Service Location info:
|region  |startDate |
|Region A|${date}   |
Then click on Save Button
When implicit wait '20' seconds
Then affiliate 'Entity' with provider
When implicit wait '20' seconds
When move to 'Address Details' section
And implicit wait '20' seconds
And To fill the Address Details:
|mailingAddressLine1|effectiveStartDate|effectiveEndDate|
|100                |${date}           |${expDate}      |
And To fill the Concact Person Details:
|attentionLine   |phone     |email          |fax          |ext    |
|Landmark        |3567894563|test@gmail.com |111-111-1111 |333333 |
And implicit wait '20' seconds
And To fill the Address Details:
|billingAddressHomeOrCorp|billingAddressContactPersonDetailsHomeOrCorp|
|Yes                     |Yes                                         |
When implicit wait '20' seconds
When move to 'Ownership' section
And implicit wait '20' seconds
And To fill the Ownership Section for Enrollment:
|ownershipCode    |lessThanFivePercent|personOwnership|entityOwnership|familymembersOwnership|ownersOwnership|
|Government - City|Yes                |No             |No             |No                    |No             |
And implicit wait '20' seconds
And To fill the Ownership Section for Enrollment:
|personOrEntityOwnership|
|No                     |
When implicit wait '20' seconds
When To fill the Ownership Section for Enrollment:
|subcontractorOwnership|
|No                   |
When implicit wait '20' seconds
When provider clicks on radio button for Ownership lessthanfivepercent
When implicit wait '20' seconds
When move to 'Key Personnel' section
When implicit wait '10' seconds
Then click on the Addline
When implicit wait '10' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|managingEmployeeType|employeeStatus        |gender|firstName|middleName|lastName|ssn       |dob       |ssnStartDate |ssnEndDate |
|ADMINISTRATOR       |Managing Non Convicted|Male  |John     |William   |Dezouzer|876543235 |15-08-1947|${date}      |${expDate} |
When implicit wait '10' seconds
When To fill the OwerKeyPersonel Information for Enrollment:
|dob       |
|02-23-1954|
When To fill the OwerKeyPersonel Information for Enrollment:
|addressLine1 |
|100          |
When implicit wait '10' seconds
Then click on the Save button in Key Personel
When implicit wait '15' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '10' seconds
And To fill the Exclusion Sanction Section:
|fraudAlligations|fiduciaryResponsibility |perjury |serviceAbuse |criminalInvestigation |unlawfulSubstances |healthCareCrime |convictedFelony|
|No              |No                      |No      |No           |No                    |No                 |No              |No             |
And To fill the Exclusion Sanction Section:
|paymentInformation |disclosureInformation |businessOrProffesionalLicense|suspensionOfAccreditation |suspendedOrExcluded|paymentSuspension |falseClaimsAct |owesMoneyToMedicaid |
|No                 |No                    |No                           |No                        |No                 |No                |No             |No                  |
And implicit wait '30' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName|lastName|
|John     |Dezouzer|
Then Agree Term and conditions to Sign
When implicit wait '10' seconds
When submit enrollment application
And implicit wait '10' seconds
When click on navigate to dashboard for Proceed To Sign
When implicit wait '5' seconds
When log out from portal

