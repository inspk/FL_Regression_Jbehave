Meta:
@systemoptions
Narrative:
As an Admin I can modify the user deactivation days
and I can set the default configaration

Scenario: Modifying user deactivation days
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'User Deactivation' links in system options
Then click on 'Edit Button' in the user inactivity page
When implicit wait '5' seconds
When Set the User Deactivation Date '${date}'
When implicit wait '5' seconds
Then set the internal user inactive days '190'
Then set the internal user invitation is not acceptable days '10'
Then click on cancel button in the user inactivity page



