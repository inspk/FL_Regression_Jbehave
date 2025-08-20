Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Disable an MCO Admin's access
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '20' seconds
Then click on 'Users' links in system options
When implicit wait '20' seconds
Then search with '${email}' on User Management page
When implicit wait '10' seconds
Then Deactivate the user with reason 'Enrollment rules violation'
When implicit wait '10' seconds
Then verify the status as 'DEACTIVATE' on User Management page

Scenario: Once user is INACTIVE, they can no longer log into the system.
Meta:
When user navigated to landing page
When implicit wait '10' seconds
When deactivated user logs to Internal User portal with username - ${email} and password - Internaluser1!
When implicit wait '1' seconds
Then verify the alert message for MCO Admin

Scenario: Reactivate Inactive User & Verify Status
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '20' seconds
Then click on 'Users' links in system options
When implicit wait '20' seconds
Then search with '${email}' on User Management page
When implicit wait '10' seconds
Then reactivate the user with reason 'Positive enrollment history'

Scenario: activated MCO Admin can log in using their email and access the Affiliation Dashboard immediately.
Meta:
When user navigated to landing page
When implicit wait '10' seconds
When deactivated user logs to Internal User portal with username - ${email} and password - Internaluser1!
When implicit wait '1' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then verify 'MCO Admin' is displayed