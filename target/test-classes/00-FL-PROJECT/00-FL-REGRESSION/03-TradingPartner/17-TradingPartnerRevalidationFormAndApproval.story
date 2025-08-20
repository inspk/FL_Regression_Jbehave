Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Create Revalidation For TP Enrollment for 1 month
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Submitted' and use in session
Given user navigated to landing page
And save value 'CORUS AT HOME PVT' to variable 'businessName'
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
When click to provider data with text '${businessName}' on IU portal
When implicit wait '10' seconds
And get authorization user 'cookies'
When implicit wait '10' seconds
When send revalidation request with '${cookies}' and time to revalidation for third notification '30d'
When implicit wait '5' seconds
When log out from IU portal
When implicit wait '5' seconds
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
Then verify the revalidation ' a month' text is displaying in the dashboard
When implicit wait '10' seconds
When click on Create Revalidation button
And implicit wait '15' seconds
Then Validating all the sections should be displayed:
|names                                                                      |
|Identifying Information                                                    |
|Taxonomy / Specialty / Provider Type / License Certification Information   |
|Provider Identifiers                                                       |
|Address Details                                                            |
|Classification                                                             |
|Affiliation                                                                |
|Ownership                                                                  |
|Key Personnel                                                              |
|Exclusion/Sanction Information                                             |
|Authorized Signature                                                       |
|Upload Documents                                                           |
|Secondary Service Location                                                 |
|Provider Agreement                                                         |
|Summary                                                                    |
When move to 'Identifying Information' section
And implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When move to 'Affiliation' section
And implicit wait '2' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000000' in affiliation section
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
When set providerid search value '4000000' in affiliation section
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
Then verify the '3' Affiliations in Affiliation Section
Then edit the details of the 'TP to INDIVIDUAL' provider in Affiliation section
When implicit wait '3' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '10' seconds
Then click on the 'Update'
When implicit wait '5' seconds
Then verify whether 'TP to INDIVIDUAL' provider Affiliation Effective end date '${expDate}' is displayed
When implicit wait '5' seconds
Then End Affiliation for 'TP to Entity'
When implicit wait '5' seconds
Then verify the '2' Affiliations in Affiliation Section
When implicit wait '5' seconds
When move to 'Ownership' section
When implicit wait '2' seconds
When move to 'Key Personnel' section
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
When move to 'Authorized Signature' section
And implicit wait '5' seconds
When move to 'Secondary Service Location' section
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
When new user logs to Provider Enrollment portal with username - len.providers+3920@gmail.com and password - Aa123321!
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
Examples:testdata/CustomSDtradingPartner.table


Scenario: TP Enrollment Status changing from NEW to APPROVED
Meta:
Given user navigated to landing page
And save value 'CORUS AT HOME PVT' to variable 'businessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
When implicit wait '25' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
When implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '10' seconds
And refresh page
When implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
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
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '20' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '20' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set date '${date}' and set agentId '${requestId}' with reason - 'Approved Based Documents'
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'ACTIVE' is displaying
When implicit wait '10' seconds
