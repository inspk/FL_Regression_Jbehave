Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '10' seconds

Scenario: Invite a new MCO Admin to the Group Health Plan
Meta:
Given generate firstname, lastname, middlename and email credentials for 'Individual2'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '20' seconds
Then click on 'Users' links in system options
When implicit wait '20' seconds
When click on adduser
When implicit wait '5' seconds
And Fill First name with value '${firstName}' on Add New User
When implicit wait '5' seconds
And Fill Last name with value '${lastName}' on Add New User
When implicit wait '5' seconds
And Fill Email with '${email}' on Add New User
When implicit wait '5' seconds
And select roles as 'MCO Admin'
When implicit wait '5' seconds
And select grpup type as 'Simply Healthcare Plans'
When implicit wait '5' seconds
Then click on add button from the user page
When implicit wait '15' seconds
Then search with '${email}' on User Management page
When implicit wait '10' seconds
Then verify the status as 'INVITED' on User Management page
When implicit wait '5' seconds
When log out from IU portal
When implicit wait '5' seconds
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '5' seconds
When search for message by email - ${email}
When open new 'Registration in IU Portal' email
When implicit wait '5' seconds
Then click on the link to complete registration
When implicit wait '5' seconds
Then switch to user set password window
When implicit wait '5' seconds
Then enter 'Internaluser1!' as password and confirm passowrd
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '10' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '10' seconds
Then click on 'Users' links in system options
When implicit wait '20' seconds
Then search with '${email}' on User Management page
When implicit wait '15' seconds
Then verify the status as 'ACTIVE' on User Management page
When implicit wait '10' seconds
When click on adduser
When implicit wait '10' seconds
And Fill First name with value '${firstName}' on Add New User
When implicit wait '5' seconds
And Fill Last name with value '${lastName}' on Add New User
When implicit wait '5' seconds
And Fill Email with '${email}' on Add New User
When implicit wait '5' seconds
And select roles as 'MCO Admin'
When implicit wait '5' seconds
Then click on add button from the user page
When implicit wait '5' seconds
Then verify the error message 'An MCO Admin already exists for organization'


Scenario: Delete added MCO Admin for the Group Health Plan
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