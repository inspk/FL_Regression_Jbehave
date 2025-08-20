Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '20' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '20' seconds
When click on View button for request 'Revalidation'
When implicit wait '20' seconds
Then verify Credentialing toggle in SystemOption
When implicit wait '5' seconds