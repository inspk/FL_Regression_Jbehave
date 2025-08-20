Meta:
@regression
Narrative:
- Provider Enrollment Manager
Scenario: Denying Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Initialized' and use in session
And save current date to variable 'date'
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
Then rewrite stage of credentials to 'COC' for 'ProviderEnrollmentManager3'

