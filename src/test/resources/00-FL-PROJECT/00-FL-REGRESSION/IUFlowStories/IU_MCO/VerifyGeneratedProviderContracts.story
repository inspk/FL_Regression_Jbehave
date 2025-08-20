Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify automatically generated provider contracts
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
When search with request id in providers page
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'MCO' provider
When implicit wait '5' seconds
Then verify BaseProviderID , LocationProviderID and status
When implicit wait '20' seconds
Then verify generated provider contracts