Meta:
@systemoptions
Narrative:
1.Delete all existing emails
2.Creating  roles
3.Creating multiple of Users

Scenario: Delete all existing emails
Meta:
When login to Internal User gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Creation of multiple Users
Meta:
Given save current date to variable 'date'
Given user navigated to landing page
Given save value '<roleName>' to variable 'roleName'
Given save value '<roleDescription>' to variable 'roleDescription'
Given save value '<firstName>' to variable 'firstName'
And save value '<lastName>' to variable 'lastName'
And save value '<user>' to variable 'user'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Roles' links in system options
Then page with url '/system/roles' should be opened
When implicit wait '5' seconds
When click Add new button
And create new user with role - '${roleName}', description - '${roleDescription}' and effective date - '${date}'
When implicit wait '5' seconds
And click 'Users' tab on left panel
When Click on Add User button from User page
When implicit wait '5' seconds
Then Verifying Add new user pop-up is opened
When fill User firstname field with value '${firstName}'
When fill User lastname field with value '${lastName}'
When fill user Email ID 'wy.internalusers+${user}@gmail.com'
When implicit wait '5' seconds
When select role 'Provider Supervisor' from the user list
Then click on add button from the user page
When implicit wait '5' seconds
!-- When search for ${user} in site visit user
When log out from IU portal
When implicit wait '5' seconds
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When search for message by email - wy.internalusers+${user}@gmail.com
When implicit wait '10' seconds
When open new 'Registration in IU Portal' email
When implicit wait '10' seconds
When click on user link in gmail page
Then switch to user set password window
Then enter password to reset the user password 'Internaluser1!'
Then confirm the password by re entering the user password 'Internaluser1!'
Then click on set password fro the user
When implicit wait '10' seconds
Examples:testdata/users.table














