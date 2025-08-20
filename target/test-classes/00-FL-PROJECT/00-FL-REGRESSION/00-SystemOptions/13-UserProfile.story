Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: modify the user profile
Given user navigated to landing page
When implicit wait '5' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'User Profile' links in system options
Then page with url '/system/userprofile' should be opened
When implicit wait '5' seconds
Then click on edit button in user profile configuration page
When implicit wait '5' seconds
Then Disable the switch in user profile configuration page
Then click on the save button in user profile configuration page
Then click on Ok button in user update profile page
Then click on '← Exit User Profile' exit links and navigate back to system option page
