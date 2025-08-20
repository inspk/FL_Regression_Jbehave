Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Individual Provider I-COC flow
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on 'Agree' button in the Portal page
And implicit wait '15' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on 'Add I Coc'
When set enrollment type 'Individual' in i-Coc popup
When click search in I-Coc popup
And implicit wait '5' seconds
When select provider in i-Coc popup
When click next in i-Coc popup
When implicit wait '5' seconds
When select add affiliation data type in i-coc popup
And implicit wait '2' seconds
When click Create CoC  for group button  on categories modal window
And implicit wait '15' seconds
Then affiliate 'MCO' with provider of 'Long Term Care'
When implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
When implicit wait '15' seconds
When click on Go to Change of Circumstance button
When implicit wait '20' seconds
When log out from portal