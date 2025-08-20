Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Terminate the Trading Partner Provider
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner2' and 'Submitted' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save current date 'dateformat'
And save value 'CORUS AT HOME LLC' to variable 'businessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
Then save ProviderID
When implicit wait '15' seconds
When click on Providers tab on header
And refresh page
When implicit wait '20' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
When implicit wait '15' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Ineligible - Other' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
Then rewrite stage of credentials to 'Terminated' for 'TradingPartner2'

Scenario: Re-Enrollment For Terminated
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner2' and 'Terminated' and use in session
And save value 'CORUS AT HOME LLC' to variable 'businessName'
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on reenrollment button
When implicit wait '10' seconds
When move to 'Identifying Information' section
When implicit wait '5' seconds
When move to 'Classification' section
And implicit wait '5' seconds
When move to 'Exclusion/Sanction Information' section
And implicit wait '5' seconds
When move to 'Affiliation' section
And implicit wait '3' seconds
When move to 'Trading Partner Agreement' section
And implicit wait '5' seconds
When click on sign button in the provider agreement section
And implicit wait '15' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '5' seconds
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
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName}|${lastName}'
When implicit wait '60' seconds
When click navigate to dashboard link after sign
And implicit wait '5' seconds
Then save the request ID of the reenrollment to deny the request of the provider
When implicit wait '10' seconds
Then rewrite stage of credentials to 'Reenrollment' for 'TradingPartner2'


Scenario: Reenrollment deny
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner2' and 'Reenrollment' and use in session
And save value 'CORUS AT HOME LLC' to variable 'businessName'
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
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
When click to provider data with text '${businessName}' on IU portal
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
When click to provider data with text '${businessName}' on IU portal
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
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with reenrollment request ID to deny the request of the provider in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '10' seconds