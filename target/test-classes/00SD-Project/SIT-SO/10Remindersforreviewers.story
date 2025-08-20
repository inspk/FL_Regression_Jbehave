Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Set the Auto Termination Configuration in Security Policy
Meta:
Given save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Reminders to Reviewers' links in system options
When implicit wait '3' seconds
When click on edit button in System Options
When implicit wait '3' seconds
And set next reminders for reviewers settings in System Options:
|notification    |days|
|1st notification|3   |
|2nd notification|5   |
|3rd notification|10  |
When implicit wait '3' seconds
And click on save changes button in Screening page
When implicit wait '3' seconds
