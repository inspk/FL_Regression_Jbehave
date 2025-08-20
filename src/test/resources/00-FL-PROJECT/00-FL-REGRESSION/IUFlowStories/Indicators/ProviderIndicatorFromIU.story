Meta:

Narrative:
As an Internal User
I want to verify the Provider Indicator tab for enrolled providers
So that I can ensure indicators are updated and displayed correctly

Scenario: Provider Indicator Verification for Enrolled Providers
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
When user calls Provider Indicator API
When implicit wait '5' seconds
When user clicks on Providers tab
When implicit wait '5' seconds
When searchAndVerifyIndicatorsForAllPES_IDs
When implicit wait '5' seconds