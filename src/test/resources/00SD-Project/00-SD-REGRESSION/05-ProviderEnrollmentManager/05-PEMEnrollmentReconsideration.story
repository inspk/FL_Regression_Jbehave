Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Request for Reconsideration with PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Denied' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click Reconsideration button on enrollment section
And implicit wait '5' seconds
When fill Reconsideration application with:
|reason          |firstName   |lastName   |
|Documents update|${firstName}|${lastName}|
And implicit wait '5' seconds
And wait for screening process execution during '5' seconds
And upload new Appeal document text_file.txt
And implicit wait '10' seconds
When sign Appeal application
And implicit wait '5' seconds
And submit Appeal application
And implicit wait '5' seconds
Then success message with text - Success!Your request was submitted. should be displayed
When implicit wait '5' seconds
When click Navigate to Dashboard button after sign
When implicit wait '5' seconds
Then save the requestID of reconsideration
When implicit wait '5' seconds
Then rewrite stage of credentials to 'CreatedAppeal' for 'ProviderEnrollmentManager1'


Scenario:Verify Reconsideration approvals based on System Options Configuration:1 approver,2 reviewers to approve Reconsideration PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'CreatedAppeal' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on Reconsideration tab on header
And implicit wait '5' seconds
Then search with reconsideration requestID in reconsideration tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on Reconsideration tab on header
And implicit wait '5' seconds
Then search with reconsideration requestID in reconsideration tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on Reconsideration tab on header
Then search with reconsideration requestID in reconsideration tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When set to the original status for appeal request status - 'Approved' and reason - 'Other Documentation Supported' with status - 'Approved'
And wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'Approved' for 'ProviderEnrollmentManager1'
