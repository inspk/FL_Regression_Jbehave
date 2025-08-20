Meta:
@regression
Narrative:
- Provider Enrollment Manager
Scenario: Denying Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Initialized' and use in session
And save current date to variable 'date'
Given user navigated to landing page
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
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
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
Then rewrite stage of credentials to 'COC' for 'ProviderEnrollmentManager3'

