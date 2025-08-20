Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Suspened and Reactivate the Individual Provider
Meta:
Given take firstname, lastname and email credentials for type 'Individual2' and 'Submitted' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
And save current date to variable 'date'
And save current date 'dateformat'
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
Then save ProviderID
When implicit wait '15' seconds
When click on Providers tab on header
And refresh page
When implicit wait '10' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Suspended' from the provider details page
And set the provider suspended date '${date}' from the Provider suspended popup
And select provider reactivation reason 'MEDICAID AUTH' and 'suspended note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Suspend' button reactivate or terminate the provider
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'SUSPENDED' is displaying
When implicit wait '5' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Reactivate' from the provider details page
And set the provider reactivate date '${date}' from the Provider Reactivate popup
And select provider reactivation reason 'Positive Enrollment History' and 'reactivation note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Reactivate' button reactivate or terminate the provider
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
