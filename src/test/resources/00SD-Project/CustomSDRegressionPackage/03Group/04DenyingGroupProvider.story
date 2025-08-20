Meta:
@regression
Narrative:
- Denying group providers

Scenario: Denying group provider
Meta:
Given take firstname, lastname and email credentials for type 'Group3' and 'Created' and use in session
And save current date to variable 'date'
And save value 'Susans Place' to variable 'providerLegalBusinessName'
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on Yes to waive Site Visit
And implicit wait '5' seconds
When select reason 'Invalid Site Visit' and 'invalid site visit' create site visit popup
And implicit wait '5' seconds
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
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And refresh page
And implicit wait '5' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName            |
|${providerLegalBusinessName}|
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'COC' for 'Group3'