Meta:
@systemoptions
Narrative:
As an Admin I can modify the duplicity data
I can set the default duplicity data

Scenario: modifying duplicity data
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Duplicity' links in system options
When click on edit button in Duplicity from System Options
When user fill the screening info:
|npi|fein|
|3  |3   |
And click on save changes button in System Options
And wait for screening process execution during '5' seconds
When click on edit button in Duplicity from System Options
When user fill the screening info:
|npi|fein|
|3  |9   |
And click on save changes button in System Options

