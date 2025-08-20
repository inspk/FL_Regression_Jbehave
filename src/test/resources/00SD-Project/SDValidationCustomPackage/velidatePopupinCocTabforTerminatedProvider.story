Meta:

Narrative:
As the IU,
While opening COC system should show a popup
to display the Caution Message for terminated providers request

Scenario: Verify that the system is showing caution message in COC module if Internal user opens any COC request of terminated provider
Given take firstname, lastname and email credentials for type 'Individual5' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
Then verify popup message 'The status of this provider is terminated' is displaying on IU portal
When implicit wait '20' seconds
