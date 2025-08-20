Meta:
@systemoptions
Narrative:
As an Admin I can modify the password policy
I can disable the Captcha Verification configaration

Scenario: Disable the Captcha Verification Button in the  password policy
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
When click on edit button in password policy page
When implicit wait '6' seconds
Then disable the 'Enable Captcha Verification' button for provider registration switch in password policy page
When implicit wait '5' seconds
When click on save button in password policy page
When implicit wait '5' seconds


