Meta:
@systemoptions
Narrative:
As an Admin I can modify the password policy
I can set the default configaration

Scenario: Enable and Disable Temporary password expiration
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
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
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
And set up start date '${date}' in password policy
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|9             |24                  |24           |80                |3          |15          |
When click on save button in password policy page
Then click on '←Exit Security Policy' exit links and navigate back to system option page
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|10            |24                  |24           |100                |3          |15          |
When click on save button in password policy page
Then click on '←Exit Security Policy' exit links and navigate back to system option page

Scenario: default configaration of password policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
And set up start date '${date}' in password policy
When user is fill the password policy info:
|passwordlength|preventPasswordReuse|passwordReset|passwordExpiration|accountLock|lockoutPeriod|
|8             |24                  |24           |120                |3          |15          |
When click on save button in password policy page
Then click on '←Exit Security Policy' exit links and navigate back to system option page
