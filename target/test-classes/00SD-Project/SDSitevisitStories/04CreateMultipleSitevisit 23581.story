Meta:

Narrative:
As the DYP IU, I can create multiple sitevisits for each service location in pending review stage


Scenario: Creating sitevisit with secondary service location
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
And save current date to variable 'date'
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
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
Then select locations 'Secondary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on No to waive Site Visit
And implicit wait '5' seconds
When select reason 'S01' and 'note' create site visit popup
And implicit wait '5' seconds
When log out from IU portal
And implicit wait '5' seconds
