Meta:
@systemoptions
Narrative:
As an Admin I can modify the Screening scores
and I can set the default configaration

Scenario: Modify the Monitoring Frequency section
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When implicit wait '3' seconds
Then click on 'Monitoring Frequency Edit Button' in the Screening page
When implicit wait '5' seconds
Then Enable the 'Allow Periodic Monitoring' switch in Screening  page
Then click on the Save button in the Screening page
Then click on 'Monitoring Frequency Edit Button' in the Screening page
When implicit wait '5' seconds
Then Disable the 'Allow Periodic Monitoring' switch in Screening  page
Then click on the Save button in the Screening page

Scenario: Modify the screening section
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When implicit wait '5' seconds
When click on edit button in Screening from System Options
When select the 'Default Screeing Thresholds' option
When implicit wait '2' seconds
When expand Screening 'Enrollment and screening of providers' provider name from the Screening Page
When implicit wait '5' seconds
When user fill the screening info:
|screeingproviderdob|gender|
|2                  |2     |
When close Screening 'Enrollment and screening of providers' provider name from the Screening Page
And click on save changes button in Screening page
When implicit wait '5' seconds
When click on edit button in Screening from System Options
When expand Screening 'Enrollment and screening of providers' provider name from the Screening Page
When implicit wait '5' seconds
When user fill the screening info:
|screeingproviderdob|gender|
|1                  |1     |
When close Screening 'Enrollment and screening of providers' provider name from the Screening Page
And click on save changes button in Screening page
When implicit wait '5' seconds
When click on edit button in Screening from System Options
When implicit wait '5' seconds
When expand Screening 'Revalidation of enrollment' provider name from the Screening Page
When implicit wait '5' seconds
When user fill the screening info:
|revalidationMissed|
|3                 |
When close Screening 'Revalidation of enrollment' provider name from the Screening Page
When implicit wait '5' seconds
And click on save changes button in Screening page
When click on edit button in Screening from System Options
When implicit wait '5' seconds
When expand Screening 'Revalidation of enrollment' provider name from the Screening Page
When implicit wait '5' seconds
When user fill the screening info:
|revalidationMissed|
|1                 |
When close Screening 'Revalidation of enrollment' provider name from the Screening Page
And click on save changes button in Screening page

Scenario: Modify Group Custom Screening Thresholds  section
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When click on edit button in Screening from System Options
When select custom screening  thresholds option
