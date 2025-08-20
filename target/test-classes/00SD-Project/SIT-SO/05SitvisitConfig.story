Meta:
@systemoptions
Narrative:
As an Admin I can verify System Options Tiles page
I can create an Site Visit Risk level
I can modify the Risk Level
I can Remove the Risk Level

Scenario: System Options Tiles Page
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then page with url '/systemoptions' should be opened
Then Validating all the name should be displayed on system option page:
|names                         |
|Affiliations                  |
|Approvals                     |
|Auto Archive                  |
|Builder                       |
|Custom Sections               |
|Data Change                   |
|Duplicity                     |
|Enrollment Types              |
|Externalization               |
|Licensure                     |
|Notification Engine           |
|Payments & Fees               |
|Reminders to Reviewers        |
|Request additional Information|
|Revalidation                  |
|Reports                       |
|Roles                         |
|Rules                         |
|Screening                     |
|Security Policy               |
|Site Visit                    |
|User Deactivation             |
|User Profile                  |
|Users                         |
When implicit wait '5' seconds


Scenario:Creating,Modifying and Deleting the Risk Level
Meta:
Given unique risk Level name value for variable 'riskLevelName1' is generated
Given unique risk Level name value for variable 'riskLevelName2' is generated
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Site Visit' links in system options
When implicit wait '5' seconds
Then click on 'Edit Button' in the sitevisit page
When implicit wait '5' seconds
Then select Risk level based on Taxonomy
When implicit wait '5' seconds
Then verify Schedule Site Visit Based on:
|Risk level based on Taxonomy|Risk level based on Screening score|Higher of the two Risk Levels|
|True                        |False                              |False                        |
When implicit wait '5' seconds
When click on save changes button in site visit risk level page
When implicit wait '5' seconds



