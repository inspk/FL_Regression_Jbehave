Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Individual Custom Sections
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Custom Sections' links in system options
When implicit wait '5' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then set the Custom Section Settings as:
|Sections                  |Switches|
|Secondary service location|ON      |
|Affiliation               |ON      |
|Payment                   |OFF     |
|Provider agreement        |ON      |
|Hello sign                |ON      |
|Summary                   |ON      |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds


Scenario: Entity Custom Sections
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Custom Sections' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then set the Custom Section Settings as:
|Sections                  |Switches|
|Secondary service location|ON      |
|Affiliation               |ON      |
|Payment                   |OFF     |
|Provider agreement        |ON      |
|Hello sign                |ON      |
|Summary                   |ON      |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds

Scenario: PEM Custom Sections
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Custom Sections' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then set the Custom Section Settings as:
|Sections                  |Switches|
|Secondary service location|ON      |
|Affiliation               |ON      |
|Payment                   |OFF     |
|Provider agreement        |ON      |
|Hello sign                |ON      |
|Summary                   |ON      |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds

Scenario: TP Custom Sections
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Custom Sections' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partners' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then set the Custom Section Settings as:
|Sections                  |Switches|
|Secondary service location|ON     |
|Affiliation               |ON      |
|Payment                   |OFF     |
|Provider agreement        |ON      |
|Hello sign                |ON      |
|Summary                   |ON      |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds