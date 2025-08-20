Meta:
@systemoptions
Narrative:
As an Admin I can modify the data change
and I can set the default configaration

Scenario: Modify the Notification in the datachange page
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Data Change' links in system options
Then page with url '/system/data-change-actions' should be opened
Then click on 'Edit Button' in the datachange page
When set the effective start date '${date}' in data change page
Then Enable the 'Enrollments' Notification in the data change page
!-- Then Enable the 'Change of Circumstance' Notification in the data change page
!-- Then Enable the 'Appeals' Notification in the data change page
Then Enable the 'Provider data' Notification in the data change page
Then click on the save button in the data change page
Then click on 'Edit Button' in the datachange page
Then Disable the 'Enrollments' Notification in the data change page
!-- Then Disable the 'Change of Circumstance' Notification in the data change page
!-- Then Disable the 'Appeals' Notification in the data change page
Then Disable the 'Provider data' Notification in the data change page
When implicit wait '5' seconds
Then click on the save button in the data change page

Scenario: Modify the Confirmation in the datachange page
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Data Change' links in system options
Then page with url '/system/data-change-actions' should be opened
Then click on 'Edit Button' in the datachange page
When set the effective start date '${date}' in data change page
Then Enable the 'Enrollments' Corfimation in the data change page
!-- Then Enable the 'Change of Circumstance' Corfimation in the data change page
!-- Then Enable the 'Appeals' Corfimation in the data change page
Then Enable the 'Provider data' Corfimation in the data change page
Then click on the save button in the data change page
Then click on 'Edit Button' in the datachange page
Then Disable the 'Enrollments' Corfimation in the data change page
!-- Then Disable the 'Change of Circumstance' Corfimation in the data change page
!-- Then Disable the 'Appeals' Corfimation in the data change page
Then Disable the 'Provider data' Corfimation in the data change page
When implicit wait '5' seconds
Then click on the save button in the data change page