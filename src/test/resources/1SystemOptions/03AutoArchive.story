Meta:
@systemoptions
Narrative:
As an Admin I can modify the auto archive data and files
I can set the default auto archive data and files

Scenario: modifying auto archive data and files
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Auto Archive' links in system options
When click on edit 'Auto Archive Data' page
When user fill auto archive info:
|schedule|
|30      |
When click on cancel button in auto archive page
When click on edit 'Auto Archive Files' page
When user fill auto archive info:
|scheduleForFiles|
|30              |
When click on cancel button in auto archive page
When click on edit 'Auto Archive Data' page
When user fill auto archive info:
|schedule|
|3       |
When click on cancel button in auto archive page
When click on edit 'Auto Archive Files' page
When user fill auto archive info:
|scheduleForFiles|
|3               |
When click on cancel button in auto archive page
Then click on '←Exit Auto Archive' exit links and navigate back to system option page


