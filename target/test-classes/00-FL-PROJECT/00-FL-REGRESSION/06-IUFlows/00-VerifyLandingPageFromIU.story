Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verify the dashboard page all the tabs is displaying
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
Then validation message 'This system contains U.S. Government and State of Florida information. By accessing and using this computer system you are consenting to system monitoring for law enforcement, auditing, and other purposes. Unauthorized use of, or access to, this computer system may subject your to state and federal. criminal prosecution and penalties, as well as civil penalties. Unauthorized use of the system is prohibited.' should be displayed in agree page
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
Then news should be displayed on dashboard page
When implicit wait '3' seconds
Then verify the 'All Requests' should be displayed on dashboard page
When click on the 'All Requests' in dashboard Page
When implicit wait '3' seconds
Then verify the 'Enrollments' should be displayed on dashboard page
When click on the 'Enrollments' in dashboard Page
When implicit wait '3' seconds
Then verify the 'COC' should be displayed on dashboard page
When click on the 'COC' in dashboard Page
When implicit wait '3' seconds
Then verify the 'Site Visit' should be displayed on dashboard page
When click on the 'Site Visit' in dashboard Page
When implicit wait '3' seconds