Meta:
@systemoptions
Narrative:
As an Admin I can modify the Auto Terminate Configuration in Security Policy
I can set the default configaration

Scenario: Set the Auto Termination Configuration in Security Policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
When implicit wait '5' seconds
Then click on Auto terminate edit button in password policy page
When implicit wait '5' seconds
Then turn on the 'Enable Auto Terminate' switch in password policy page
When implicit wait '5' seconds
When set the remainder  notification Period After which suspended Providers will be terminated:
|suspendedProvidersTerminated|fisrtNotification|secondNotification|thirdNotification|
|60                          |45               |30                |7                |
When implicit wait '5' seconds
Then click on Auto Terminate save button in the password policy page
When implicit wait '5' seconds
Then click on '←Exit Security Policy' exit links and navigate back to system option page
When implicit wait '5' seconds


