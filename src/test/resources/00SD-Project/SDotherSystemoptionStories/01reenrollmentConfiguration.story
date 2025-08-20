Meta:
Narrative:
As the DYP system,
system should not have Re-enrollment option
based on the configuration under approvals configuration in system options.

Scenario:Re-enrollment configuration for for Provider Enrollment Manager
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Re Enrollment'
When click on edit button in System Options
When implicit wait '5' seconds
When verify 'Re-enrollment required for PEM providers' configuration is ON in Re-enrollment approval page
When disable 'Re-enrollment required for PEM providers' configuration in Re-enrollment approval page
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds



Scenario:Verify that the system is not showing Re-enrollment options in provider portal based on the configuration
Meta:
Given user navigated to landing page
When implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When skip help tour if exists
When verify that Re-Enrollment Button presents

