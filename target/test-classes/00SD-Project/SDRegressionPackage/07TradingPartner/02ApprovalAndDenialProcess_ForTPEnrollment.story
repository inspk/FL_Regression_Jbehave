Meta:
@regression
Narrative:
- Configuration for Enrollment in Approvals- 1 approver:user,  2 reviewer: user
1-->1.Login as First Reviewer and Approve the Enrollment
    2.Login as Second Reviewer and Approve the Enrollment
    3.Login as Approver and Approve the Enrollment
2-->1.Login as First Reviewer and Deny the Enrollment
    2.Login as Second Reviewer and Deny the Enrollment
    3.Login as Approver and Deny the Enrollment

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to approve Group Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Created' and use in session
And save value 'AVERA AT HOME' to variable 'businessName'
And save current date to variable 'date'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'TradingPartner1'

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to Deny Group Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner2' and 'Created' and use in session
And save value 'Salvation Army' to variable 'businessName'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Denied' for 'TradingPartner2'