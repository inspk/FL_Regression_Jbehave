Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual3' and 'ApprovedReviewCOC1' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And refresh page
And implicit wait '20' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '10' seconds
And refresh page
And implicit wait '20' seconds
When log out from IU portal
And implicit wait '5' seconds
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '10' seconds
When log out from IU portal
And refresh page
And implicit wait '10' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'
And implicit wait '10' seconds



Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual3' and 'DeniedReviewCOC2' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
Then search with coc request id to deny the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And refresh page
And implicit wait '20' seconds
And click on CoC tab on header
Then search with coc request id to deny the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '10' seconds
When log out from IU portal
And refresh page
And implicit wait '10' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to deny the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '15' seconds
When log out from IU portal
And refresh page
And implicit wait '5' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to deny the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And implicit wait '15' seconds