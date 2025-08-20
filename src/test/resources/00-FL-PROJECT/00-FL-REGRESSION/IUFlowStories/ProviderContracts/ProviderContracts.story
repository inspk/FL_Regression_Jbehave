Meta:

Narrative:
As a user
I want to verify Provider Contracts in both Enrollment and Providers module

Scenario: Verify Provider Contracts for Individual Enrollment
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|enrollType|requestType|
|Individual|Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '5' seconds
Then verify Provider Contracts in IU

Scenario: Verify Provider Contracts for Entity Enrollment
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|enrollType|requestType|
|Entity    |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Entity' provider
When implicit wait '5' seconds
Then verify Provider Contracts in IU

Scenario: Verify Provider Contracts for MCO Enrollment
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status|enrollType|requestType|
|New   |MCO       |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'MCO' provider
When implicit wait '5' seconds
Then verify Provider Contracts in IU