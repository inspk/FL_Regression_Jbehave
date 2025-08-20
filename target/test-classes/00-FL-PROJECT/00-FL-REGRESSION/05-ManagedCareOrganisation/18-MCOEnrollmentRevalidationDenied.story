Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Create Revalidation For MCO Enrollment for 1 month
Meta:
Given take firstname, lastname and email credentials for type 'MCO3' and 'Approved' and use in session
Given user navigated to landing page
And save value 'Mediplus Community Services' to variable 'planLegalName'
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
When click to provider data with text '${planLegalName}' on IU portal
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
And implicit wait '15' seconds
When move to 'Identifying Information' section
And implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
When move to 'Ownership' section
And implicit wait '5' seconds
When move to 'Key Personnel' section
When implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents (Optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
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
And implicit wait '10' seconds
Then save the tracking ID of the revalidation
When implicit wait '5' seconds


Scenario: Approve Revalidation request for MCO Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'MCO3' and 'Approved' and use in session
Given user navigated to landing page
And save value 'Mediplus Community Services' to variable 'planLegalName'
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
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
When click to provider data with text '${planLegalName}' on IU portal
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
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '15' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with the revalidation request ID
When implicit wait '5' seconds
When click to provider data with text '${planLegalName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And implicit wait '10' seconds