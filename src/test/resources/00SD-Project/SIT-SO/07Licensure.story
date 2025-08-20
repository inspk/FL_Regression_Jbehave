Meta:
@systemoptions
Narrative:
As an Admin I can modify the Licensure
and I can set the default configaration

Scenario:set the Licensue configuration
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Licensure' links in system options
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the Licensure Remainders notifications info:
|fisrtNotification|secondNotification|thirdNotification|
|45               |30                |15               |
When implicit wait '5' seconds
When click on save changes button in Licensure page
Then click on '←Exit Licensure' exit links and navigate back to system option page


