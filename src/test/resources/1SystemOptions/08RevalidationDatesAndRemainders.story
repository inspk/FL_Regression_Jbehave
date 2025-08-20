Meta:
@systemoptions
Narrative:
As an Admin I can modify the revalidation dates and remainders
I can set the default configaration

Scenario: modifying revalation dates and remainders
Meta:
When user navigated to landing page
Given save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Revalidation' links in system options
When implicit wait '5' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the EffectiveStartDate '${date}' Enrollment type Page
And set next revalidation settings in System Options:
|section                                 |notification    |revalidationSettings|
|Revalidation date calculation           |                |3                   |
|Reminders                               |1st notification|75                  |
|Reminders                               |2nd notification|45                  |
|Reminders                               |3rd notification|15                  |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds


Scenario: default configaration of revalidation
Meta:
When user navigated to landing page
Given save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Revalidation' links in system options
When implicit wait '5' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the EffectiveStartDate '${date}' Enrollment type Page
When implicit wait '5' seconds
And set next revalidation settings in System Options:
|section                                 |notification    |revalidationSettings|
|Revalidation date calculation           |                |1                   |
|Reminders                               |1st notification|90                  |
|Reminders                               |2nd notification|60                  |
|Reminders                               |3rd notification|30                  |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds