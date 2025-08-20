Meta:
@regression
Narrative:
- Configuration for Appeal in Approvals- 1 approver:user,2 reviewer: user
1-->1.Login as First Reviewer and Approve the Appeal
    2.Login as Second Reviewer and Approve the Appeal
    3.Login as Approver and Approve the Appeal
2-->1.Login as First Reviewer and Deny the Appeal
    2.Login as Second Reviewer and Deny the Appeal
    3.Login as Approver and Deny the Appeal

Scenario:Verify Appeal approvals based on System Options Configuration:1 approver,2 reviewers to approve Appeal Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager2' and 'Denied' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on Reconsideration tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Change status' button from the enrollment details page
When set to the original status for appeal request status - 'Approved' and reason - 'Approved Based Documents' with status - 'Approved'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Appeal' for 'ProviderEnrollmentManager2'

Scenario:Verify Appeal approvals based on System Options Configuration:1 approver,2 reviewers to Deny Appeal Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Initialized' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on Reconsideration tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And wait for screening process execution during '5' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Appeal' for 'ProviderEnrollmentManager3'

