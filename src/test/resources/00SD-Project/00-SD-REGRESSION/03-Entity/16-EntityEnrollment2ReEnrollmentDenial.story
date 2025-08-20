Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Terminate the Group Provider
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Approved' and use in session
Given user navigated to landing page
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
Then save ProviderID
When implicit wait '15' seconds
When click on Providers tab on header
And refresh page
When implicit wait '10' seconds
Then search with providerID in provider tab
When implicit wait '10' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Ineligible - Other' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
Then rewrite stage of credentials to 'Terminated' for 'Group2'



Scenario: Re-Enrollment For Terminated
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Terminated' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And get random npi from file 'SdNPI'
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on reenrollment button
When implicit wait '10' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|enrollmentDate |reasonCode    |
|${date}        |${reasonCode} |
When implicit wait '5' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '2' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '3' seconds
When move to 'EFT Information' section
And implicit wait '3' seconds
When move to 'Address Details' section
And implicit wait '3' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '3' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When click on 'Yes' for the question 'Do you want to affiliate with Individual Providers?' in affiliation
When set SSN search value '456-76-5451' in affiliation section
And implicit wait '2' seconds
When set DOB search value '10-11-1980' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When select affliation type 'Entity to Individual'
When fill the effective start '${date}' and effective end '${expDate}' to enrollment end affiliation type page
And implicit wait '5' seconds
When click on 'Do you want to affiliate with Primary service location ?' to 'true' in affiliation popup
And implicit wait '3' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '5' seconds
When select 'In-Person' for Manner of Service in affiliation popup
When select 'Primary Care Provider (PCP)' with '${date}' and '${expDate}' in affiliation popup
And implicit wait '5' seconds
When click 'Yes' for Accepting New Patients in affiliation popup
And implicit wait '5' seconds
When click add button in affiliation pop-up
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
When implicit wait '10' seconds
When move to 'School District' section
And implicit wait '5' seconds
When move to 'Provider Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user titel & '${providerLegalBusinessName}'
And implicit wait '20' seconds
When move to 'Summary' section
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
And implicit wait '15' seconds
And refresh page
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - len.providers+3920@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the group' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And implicit wait '5' seconds
When click on Proceed To Sign button
And implicit wait '2' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '60' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
Then save the request ID of the reenrollment to deny the request of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'Reenrollment' for 'Group2'


Scenario: Reenrollment deny
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Reenrollment' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '10' seconds
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
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '15' seconds
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on Yes to waive Site Visit
And implicit wait '5' seconds
When select reason 'Onsite Created in Error' and 'invalid site visit' create site visit popup
And implicit wait '5' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
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
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Denied' for 'Group2'

