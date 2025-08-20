
Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Disable the Captcha Verification Button in the  password policy
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '3' seconds
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
When implicit wait '6' seconds
Then disable the 'Enable Captcha Verification' button for provider registration switch in password policy page
When implicit wait '5' seconds
When click on save button in password policy page
When implicit wait '5' seconds

Scenario: Set the Auto Termination Configuration in Security Policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '3' seconds
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
Then click on '← Exit Security Policy' exit links and navigate back to system option page
When implicit wait '5' seconds

Scenario: Enable and Disable Temporary password expiration
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '3' seconds
Then click on 'Security Policy' links in system options
When implicit wait '3' seconds
When click on edit button in password policy page
When implicit wait '5' seconds
When disable the 'Enable Temporary password expiration for the providers created by PEM' checkbox in configure password policy page
When implicit wait '5' seconds
When click on save button in password policy page
When implicit wait '5' seconds
When click on edit button in password policy page
When implicit wait '5' seconds
When enable the 'Enable Temporary password expiration for the providers created by PEM' checkbox in configure password policy page
When implicit wait '5' seconds
When click on save button in password policy page
When implicit wait '5' seconds

Scenario: modifying password policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '3' seconds
Then click on 'Security Policy' links in system options
When implicit wait '3' seconds
When click on edit button in password policy page
When implicit wait '3' seconds
And set up start date '${date}' in password policy
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|9             |24                  |24           |80                |3          |15          |
When click on save button in password policy page
Then click on '← Exit Security Policy' exit links and navigate back to system option page
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|10            |24                  |24           |100                |3          |15          |
When click on save button in password policy page
Then click on '← Exit Security Policy' exit links and navigate back to system option page

Scenario: default configaration of password policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '3' seconds
Then click on 'Security Policy' links in system options
When implicit wait '3' seconds
When click on edit button in password policy page
When implicit wait '3' seconds
And set up start date '${date}' in password policy
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|8             |24                  |24           |120                |3          |15          |
When click on save button in password policy page
Then click on '← Exit Security Policy' exit links and navigate back to system option page
