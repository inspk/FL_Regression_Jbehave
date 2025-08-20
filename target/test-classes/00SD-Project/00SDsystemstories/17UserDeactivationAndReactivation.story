Meta:
@systemoptions
Narrative:
1.Delete all existing emails
2.Creating the User
3.Navigate to System Options
4.Search the user in the user list
5.Deactivation the User and Verify the Notification in Gmail
6.Reactivation the User and Verify the Notification in Gmail

Scenario: Delete all existing emails
Meta:
When login to Internal User gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Creating the new users
Meta:
Given save current date to variable 'date'
Given user navigated to landing page
Given save value '<roleName>' to variable 'roleName'
Given save value '<roleDescription>' to variable 'roleDescription'
Given save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<user>' to variable 'user'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
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
When select role '${roleName}' from the user list
Then click on add button from the user page
When implicit wait '10' seconds
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
When implicit wait '10' seconds
Examples:testdata/UserForActivationAndDeactivation.table

Scenario: Deactivation the User and Verify the Notification in Gmail
Meta:
Given save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<user>' to variable 'user'
Given save current date to variable 'date'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then page with url '/systemoptions' should be opened
Then click on 'Users' links in system options
When implicit wait '10' seconds
When search for ${user} in site visit user
And implicit wait '3' seconds
When select 'Deactivate' action for request 'wy.internalusers+${user}@gmail.com'
Then verify the User Deactivation Popup 'User Deactivation' is displaying
When select the reason 'Enrollment rules violation' and 'newnote' to the deactivation and inactive the user
Then click on 'DEACTIVATE' user Deactivation or Reactivation
When select 'View' action for request 'wy.internalusers+${user}@gmail.com'
When implicit wait '10' seconds
And user navigated to landing page
When login to Internal User gmail
Then go to gmail to inbox page
When implicit wait '15' seconds
When search for message by email - wy.internalusers+${user}@gmail.com
When open new 'User Deactivation in IU Portal' email to the Deaction and Activation user
Examples:testdata/DeactivateUser.table

Scenario: Reactivation the User and Verify the Notification in Gmail
Meta:
Given save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<user>' to variable 'user'
Given save current date to variable 'date'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then page with url '/systemoptions' should be opened
Then click on 'Users' links in system options
When implicit wait '10' seconds
When search for ${user} in site visit user
And implicit wait '3' seconds
When select 'Activate' action for request 'wy.internalusers+${user}@gmail.com'
Then verify the User Deactivation Popup 'User Reactivation' is displaying
When select the reason 'Positive enrollment history' and 'newnote' to the deactivation and inactive the user
Then click on 'REACTIVE' user Deactivation or Reactivation
When select 'View' action for request 'wy.internalusers+${user}@gmail.com'
When implicit wait '10' seconds
And user navigated to landing page
When login to Internal User gmail
Then go to gmail to inbox page
When implicit wait '15' seconds
When search for message by email - wy.internalusers+${user}@gmail.com
When open new 'User Activation in IU Portal' email to the Deaction and Activation user
Examples:testdata/DeactivateUser.table