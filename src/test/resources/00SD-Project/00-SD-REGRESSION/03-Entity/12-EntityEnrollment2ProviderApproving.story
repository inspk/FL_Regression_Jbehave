Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver to approve Group Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Submitted' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Mediplus Community Service CSC' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Other Documentation Supported'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'Group2'


