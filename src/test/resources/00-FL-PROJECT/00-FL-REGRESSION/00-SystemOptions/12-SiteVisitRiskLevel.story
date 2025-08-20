Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: System Options Tiles Page
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then page with url '/systemoptions' should be opened
Then Validating all the name should be displayed on system option page:
|names                           |
|Affiliations                    |
|Approvals                       |
|Auto Archive                    |
|Builder                         |
|Custom Sections                 |
|Data Change                     |
|Duplicity                       |
|Enrollment Types                |
|Externalization                 |
|Field Office                    |
|Licensure                       |
|Notification Engine             |
|Payments & Fees                 |
|Reminders to Reviewers          |
|Request additional Information  |
|Revalidation                    |
|Reports                         |
|Roles                           |
|Rules                           |
|Screening                       |
|Security Policy                 |
|Site Visit                      |
|User Deactivation               |
|User Profile                    |
|Users                           |
|Configure Title, Icon & Site Map|
|Auth Profile                    |


Scenario:Creating,Modifying and Deleting the Risk Level
Meta:
Given unique risk Level name value for variable 'riskLevelName1' is generated
Given unique risk Level name value for variable 'riskLevelName2' is generated
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
When implicit wait '2' seconds
Then click on 'Site Visit' links in system options
When implicit wait '2' seconds
Then click on 'Edit Button' in the sitevisit page
When implicit wait '2' seconds
Then click on 'Add Button' in the risk Categories page
When the user is  navigate to 'Add Risk Level' page
Then fill the Risk Level identifier with value '${riskLevelName1}'
Then fill the Shedule no with value '3'
Then click on 'Shedule months or Year'
Then click on the 'Month(s)'
Then send the value to the first remainder '30'
Then select the first remainder drop drown
Then click the first remainder days
Then send the value to the second remainder '15'
Then select the second remainder drop drown
Then click the second remainder days
Then send the value to the third remainder '7'
Then select the third remainder drop drown
Then click the third remainder days
Then click on cancel button to cancel the Risk level
