Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Meta:

Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Message Icon in internal user header tab
And implicit wait '5' seconds
When click on New message
And implicit wait '2' seconds
When enter the provider email wy.harrypotter+tp@gmail.com
And implicit wait '2' seconds
When fill the Subject of the Message
And implicit wait '2' seconds
When Verify Provider name and NPI is displaying
And implicit wait '5' seconds
Then click on Send message
