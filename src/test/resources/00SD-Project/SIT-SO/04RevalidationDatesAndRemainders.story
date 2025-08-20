Meta:
@systemoptions
Narrative:
As an Admin I can modify the revalidation dates and remainders
I can set the default configaration

Scenario: modifying revalation dates and remainders for Individual Providers
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
|section                                 |notification    |revalidationSettings     |
|Revalidation date basis                 |                |Enrollment Approved Date |
|Revalidation date calculation           |                |5                        |
|Reminders                               |1st notification|90                       |
|Reminders                               |2nd notification|60                       |
|Reminders                               |3rd notification|30                       |
|Group provider:outstanding revalidations|                |15                       |
|After revalidation period               |                |1                        |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '10' seconds

Scenario: modifying revalation dates and remainders for Group Providers
Meta:
When user navigated to landing page
Given save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Revalidation' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Group Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the EffectiveStartDate '${date}' Enrollment type Page
And set next revalidation settings in System Options:
|section                                 |notification    |revalidationSettings     |
|Revalidation date basis                 |                |Enrollment Approved Date |
|Revalidation date calculation           |                |5                        |
|Reminders                               |1st notification|90                       |
|Reminders                               |2nd notification|60                       |
|Reminders                               |3rd notification|30                       |
|Group provider:outstanding revalidations|                |15                       |
|After revalidation period               |                |1                        |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '10' seconds

Scenario: modifying revalation dates and remainders for Provider Enrollment Manager
Meta:
When user navigated to landing page
Given save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Revalidation' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the EffectiveStartDate '${date}' Enrollment type Page
And set next revalidation settings in System Options:
|section                                 |notification    |revalidationSettings     |
|Revalidation date basis                 |                |Enrollment Approved Date |
|Revalidation date calculation           |                |5                        |
|Reminders                               |1st notification|90                       |
|Reminders                               |2nd notification|60                       |
|Reminders                               |3rd notification|30                       |
|Group provider:outstanding revalidations|                |15                       |
|After revalidation period               |                |1                        |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '10' seconds

Scenario: modifying revalation dates and remainders for Trading Partners
Meta:
When user navigated to landing page
Given save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Revalidation' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partners'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
When set the EffectiveStartDate '${date}' Enrollment type Page
And set next revalidation settings in System Options:
|section                                 |notification    |revalidationSettings     |
|Revalidation date basis                 |                |Enrollment Approved Date |
|Revalidation date calculation           |                |5                        |
|Reminders                               |1st notification|90                       |
|Reminders                               |2nd notification|60                       |
|Reminders                               |3rd notification|30                       |
|Group provider:outstanding revalidations|                |15                       |
|After revalidation period               |                |1                        |
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '10' seconds