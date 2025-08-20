Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Individual - Coc - Affiliation
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be enabled
When outstate switch should be enabled
When bothstate switch should be enabled
When implicit wait '5' seconds
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be disabled
When outstate switch should be disabled
When bothstate switch should be disabled
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds


Scenario: Group - Coc - Affiliation
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be enabled
When outstate switch should be enabled
When bothstate switch should be enabled
When implicit wait '5' seconds
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be disabled
When outstate switch should be disabled
When bothstate switch should be disabled
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds


Scenario: PEM - Coc - Affiliation
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be enabled
When outstate switch should be enabled
When bothstate switch should be enabled
When implicit wait '5' seconds
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be disabled
When outstate switch should be disabled
When bothstate switch should be disabled
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds

Scenario: TP - Coc - Affiliation
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partner' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be enabled
When outstate switch should be enabled
When bothstate switch should be enabled
When implicit wait '5' seconds
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When instate switch should be disabled
When outstate switch should be disabled
When bothstate switch should be disabled
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds