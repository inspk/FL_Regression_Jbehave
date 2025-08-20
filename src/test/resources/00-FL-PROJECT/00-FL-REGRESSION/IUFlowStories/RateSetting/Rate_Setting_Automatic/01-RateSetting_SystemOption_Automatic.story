Meta:
Narrative:
As an internal user
  I want to verify the RateSetting toggle button in SystemOption.

Scenario:Verify RateSetting toggle button in SystemOption.
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '10' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '10' seconds
When click on View button for request 'Enrollment'
When implicit wait '20' seconds
Then verify ratesetting toggle in SystemOption for Auto
When implicit wait '5' seconds