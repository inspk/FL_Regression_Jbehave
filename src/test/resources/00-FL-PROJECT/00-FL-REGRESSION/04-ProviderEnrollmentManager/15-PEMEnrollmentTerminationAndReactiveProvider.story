Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario:Terminate and Reactivate the PEM Provider
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Submitted' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save current date 'dateformat'
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
When implicit wait '10' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'LIC EXPIRED' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
When log out from IU portal
And refresh page
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And close informational pop-up
Then provider status as 'TERMINATED' is displaying
When implicit wait '5' seconds
When log out from IU portal
And refresh page
And implicit wait '5' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
Then search with providerID in provider tab
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Reactivate' from the provider details page
And set the provider reactivate date '${date}' from the Provider Reactivate popup
And select provider reactivation reason 'Positive Enrollment History' and 'reactivation note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Reactivate' button reactivate or terminate the provider
And implicit wait '10' seconds
When log out from IU portal
And refresh page
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds