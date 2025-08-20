Meta:

Narrative:
As the DYP System,
system should have the auto approval process for CoCs based on screening results

Scenario: Individual
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
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned on
Then switch off the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned off
Then switch on the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '5' seconds

Scenario: Entity
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
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned on
Then switch off the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned off
Then switch on the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '5' seconds


Scenario: PEM
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
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned on
Then switch off the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned off
Then switch on the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '5' seconds


Scenario: TP
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partners' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned on
Then switch off the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
Then 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' switch should be turned off
Then switch on the 'Request is automatically approved if the COC screening score is greater than or equal to latest screening score' auto configuration in coc approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '5' seconds