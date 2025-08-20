Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Roles' links in system options
Then page with url '/system/roles' should be opened
When implicit wait '5' seconds
And refresh page
When implicit wait '5' seconds
When search for role - 'Provider Supervisor'
When click the role with Provider Supervisor
When activate edit mode
When implicit wait '5' seconds
When expand the permission with label Provider - Display page
When implicit wait '5' seconds
When verify that below permissions are given to Provider - Notes by default:
|permissions|
|Read       |
|Edit       |
|Create     |
|Delete     |
When implicit wait '5' seconds
When save role permission changes
When implicit wait '5' seconds


