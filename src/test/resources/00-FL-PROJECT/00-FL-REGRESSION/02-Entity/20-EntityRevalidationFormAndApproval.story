Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Create Revalidation For Entity Enrollment for 1 month
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
Given user navigated to landing page
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And save current date to variable 'date'
And save current date 'dateformat'
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
Then save ProviderID
When implicit wait '15' seconds
When click on Providers tab on header
When implicit wait '5' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When implicit wait '10' seconds
And get authorization user 'cookies'
When implicit wait '10' seconds
When send revalidation request with '${cookies}' and time to revalidation for third notification '30d'
When implicit wait '5' seconds
When log out from IU portal
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And close informational pop-up
When skip help tour if exists
And implicit wait '10' seconds
Then verify the revalidation ' a month' text is displaying in the dashboard
When implicit wait '10' seconds
When click on Create Revalidation button
And implicit wait '85' seconds
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
When implicit wait '10' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '10' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|2251C2600X           |
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
When implicit wait '8' seconds
When upload document 'Upload License/Certificate Document*' document text_file.txt in Taxonomy/Speciality/License Certification Info section
When implicit wait '5' seconds
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '45' seconds
Then verify the '2' taxonomies in Taxonomy/Speciality/License Certification section info
When implicit wait '3' seconds
Then Edit taxonomy for '2251C2600X'
When implicit wait '5' seconds
Then click on the 'Edit'
When implicit wait '5' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|licenseCertificateNumber|
|786A3545                |
When click on 'Add' in Taxonomy/Speciality/License Certification Info section
When implicit wait '3' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '20' seconds
Then verify whether the updated License No '786A3545' is displayed in Taxonomy Section
When implicit wait '3' seconds
Then Remove/End taxonomy for '22510000X'
When implicit wait '5' seconds
Then verify the text for Approved taxonomy 'Removing/Ending this program information will result in this data being deleted in Servicing Location as well. Do you desire to continue?' and select 'Yes' option
When implicit wait '25' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
Then Edit Service Location for 'Primary' in COC page
When implicit wait '5' seconds
When click on Add Taxonomy/Speciality in Service Location section
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|specialty               |
|PHYSICAL THERAPIST - 091|
When implicit wait '5' seconds
Then select Taxonomy '2251C2600X'
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '5' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '5' seconds
Then click new Save button
When implicit wait '5' seconds
When click on Add Location in Service Location section
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName    |addressLine1               |attentionLine|email   |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Secondary clinic|${secondaryServiceLocation}|${firstName} |${email}|${phoneno} |Yes           |Yes                      |
When implicit wait '5' seconds
Then click new Save button
When implicit wait '50' seconds
When verify the '2' Service locations in Service Location Section
Then Remove/End Service Location for 'Secondary'
When implicit wait '35' seconds
When verify the '1' Service locations in Service Location Section
When move to 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000013' in affiliation section
And implicit wait '5' seconds
When set type search value 'PEM' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '5' seconds
When click add button in affiliation pop-up
And implicit wait '15' seconds
When set npi search value '1942589486' in affiliation section
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
When select '111NN0400X - CHIROPRACTOR - NEUROLOGY' with '${date}' and '${tmrwDate}' in affiliation popup
And implicit wait '10' seconds
When click add button in affiliation pop-up
And implicit wait '10' seconds
Then verify the '2' Affiliations in Affiliation Section
Then edit the details of the 'INDIVIDUAL' provider in Affiliation section
When implicit wait '10' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation
And implicit wait '10' seconds
Then click on the 'Update'
When implicit wait '15' seconds
Then verify whether 'INDIVIDUAL' provider Affiliation Effective end date '${expDate}' is displayed
When implicit wait '5' seconds
Then End Affiliation for 'ENTITY to INDIVIDUAL'
When implicit wait '25' seconds
Then verify the '1' Affiliations in Affiliation Section
When implicit wait '5' seconds
When move to new 'Non-Institutional Provider Agreement' section
And implicit wait '10' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '40' seconds
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
And implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - dyp.provider+mansoor@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the group' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Proceed To Sign button
And implicit wait '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
Then save the tracking ID of the revalidation
When implicit wait '5' seconds


Scenario:Approve Revalidation request for Entity Enrollment with 2 Reviewers and 1 Approver
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
When implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
And implicit wait '45' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And refresh page
And implicit wait '20' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
When implicit wait '30' seconds
Then verify provider status should be 'APPROVED' on the Enrollment tab in IU portal
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And implicit wait '15' seconds
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
Then verify all the tabs should be displayed:
|names             |
|Dashboard         |
|Screening         |
|Affiliations      |
|CoC               |
|Provider Data     |
|Help center       |
