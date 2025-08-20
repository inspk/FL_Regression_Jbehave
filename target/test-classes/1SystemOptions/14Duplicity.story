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
When implicit wait '5' seconds
When click on edit button in Duplicity from System Options
When implicit wait '5' seconds
When user fill the screening info:
|npi|fein|
|3  |3   |
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on 'Exit Duplicity' exit links and navigate back to system option page
Then click on 'Duplicity' links in system options
When implicit wait '5' seconds
When click on edit button in Duplicity from System Options
When implicit wait '5' seconds
When user fill the screening info:
|npi|fein|
|3  |9   |
When implicit wait '5' seconds
And click on save changes button in System Options

