Meta:
@systemoptions
Narrative:
As an Admin
I can modify the user profile congiguration

Scenario: Delete all existing emails
Meta:
When login to Internal User gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario: modify the user profile
Meta:
Given save current date to variable 'date'
Given user navigated to landing page
And save value '<roleName>' to variable 'roleName'
And save value '<roleDescription>' to variable 'roleDescription'
And save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<user>' to variable 'user'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Roles' links in system options
Then page with url '/system/roles' should be opened
When click Add new button
And create new user with role - '${roleName}', description - '${roleDescription}' and effective date - '${date}'
When click 'Users' tab on left panel
When Click on Add User button from User page
Then Verifying Add new user pop-up is opened
When fill User firstname field with value '${firstName}'
When fill User lastname field with value '${lastName}'
When fill user Email ID 'wy.internalusers+${user}@gmail.com'
When select role 'Provider Supervisor' from the user list
When select timezone 'Alaska' from the user list
When select languages 'French' from the user list
When implicit wait '3' seconds
When fill display name '${firstName} ${lastName}' from the user list
When fill company 'HHS' from the user list
When fill job title '${roleName}' from the user list
When fill department 'HHS' from the user list
When fill location 'South Dakota' from the user list
When fill mobile '(123)123-2132' from the user list
When fill phone '(123)123-2132' from the user list
When fill ext '33' from the user list
When fill fax '(235)435-4354' from the user list
Then click on add button from the user page
When implicit wait '5' seconds
And click 'Users' tab on left panel
When search for ${user} in site visit user
When log out from IU portal
When login to Internal User gmail
Then go to gmail to inbox page
When implicit wait '40' seconds
When search for message by email - wy.internalusers+${user}@gmail.com
When implicit wait '10' seconds
When open new 'Registration in IU Portal' email
When implicit wait '10' seconds
When click on user link in gmail page
Then switch to user set password window
Then enter password to reset the user password 'Aa123321!'
Then confirm the password by re entering the user password 'Aa123321!'
Then click on set password fro the user
Then navigate Back to Login page after set the password
When implicit wait '5' seconds
When user navigated to landing page
When implicit wait '5' seconds
When new user logs to Internal User portal with username - wy.internalusers+${user}@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'User Profile' links in system options
Then page with url '/system/userprofile' should be opened
Then click on edit button in user profile configuration page
When wait for screening process execution during '3' seconds
Then Enable the switch in user profile configuration page
Then set the '1' days in the user profile configuaration page
Then click on the save button in user profile configuration page
Then click on '←Exit User Profile' exit links and navigate back to system option page
Examples:testdata/UserProfile.table

Scenario: modify the user profile
Given user navigated to landing page
And save value '<user>' to variable 'user'
When implicit wait '5' seconds
When new user logs to Internal User portal with username - wy.internalusers+${user}@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'User Profile' links in system options
Then page with url '/system/userprofile' should be opened
Then click on edit button in user profile configuration page
When wait for screening process execution during '3' seconds
Then Disable the switch in user profile configuration page
Then click on the save button in user profile configuration page
Then click on '←Exit User Profile' exit links and navigate back to system option page
Examples:testdata/UserProfile.table