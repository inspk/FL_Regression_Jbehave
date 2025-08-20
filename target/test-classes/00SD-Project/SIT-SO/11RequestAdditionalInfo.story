Meta:
@systemoptions
Narrative:
As an Admin I can modify the Request Addtional Information
and I can set the Request Addtional Information

Scenario:set the Request Addtional Information
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Request additional Information' links in system options
Then click on the edit button in the RequestAddtionalInfo page
When set the EffectiveStartDate '${date}' Enrollment type Page
When implicit wait '3' seconds
Then Disable the 'Enable Auto Deny' switch in RequestAddtionalInfo page
When implicit wait '2' seconds
Then Enable the 'Enable Auto Deny' switch in RequestAddtionalInfo page
When implicit wait '2' seconds
When set the RequestAddtionalInfomation Remainders notifications info:
|fisrtNotification|secondNotification|thirdNotification|
|3                |10                |30               |
When click on save changes button in requestAddtionalInfo page
Then click on '←Exit Request Additional Info' exit links and navigate back to system option page
When implicit wait '2' seconds
Then click on 'Request additional Information' links in system options
Then click on the edit button in the RequestAddtionalInfo page
When set the EffectiveStartDate '${date}' Enrollment type Page
When implicit wait '3' seconds
Then Disable the 'Enable Auto Deny' switch in RequestAddtionalInfo page
When implicit wait '2' seconds
Then Enable the 'Enable Auto Deny' switch in RequestAddtionalInfo page
When implicit wait '2' seconds
When verify the Request Addtional Infomation Remainders notifications info:
|firstNotification|secondNotification|thirdNotification|
|3                |10                |30               |
When click on save changes button in requestAddtionalInfo page
When implicit wait '2' seconds