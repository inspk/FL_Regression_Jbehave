Meta:

Narrative:
As the DYP IU, I can see the NPI, location full address in the top section of site visit

Scenario: scenario description
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
And save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Site visits tab on header
When implicit wait '5' seconds
When click reset filters for provider data on IU portal
When implicit wait '10' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${firstName}              |
When implicit wait '5' seconds
When select 'View' from the site visit list
When implicit wait '10' seconds
Then verify 'NPI' as '1760711337' in sitevisit
Then verify 'SITE VISIT SERVICE LOCATION' as '3001 Henderson Dr' in sitevisit
