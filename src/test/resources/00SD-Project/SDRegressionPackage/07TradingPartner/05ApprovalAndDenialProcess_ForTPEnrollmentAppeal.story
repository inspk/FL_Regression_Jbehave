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
Given take firstname, lastname and email credentials for type 'TradingPartner2' and 'Denied' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click Reconsideration button on enrollment section
And implicit wait '5' seconds
When fill Reconsideration application with:
|reason          |firstName   |lastName   |
|Documents update|${firstName}|${lastName}|
And wait for screening process execution during '5' seconds
And upload new Appeal document text_file.txt
And implicit wait '10' seconds
When sign Appeal application
And implicit wait '5' seconds
And submit Appeal application
When implicit wait '5' seconds
Then success message with text - Success!Your request was submitted. should be displayed
When implicit wait '5' seconds
Then rewrite stage of credentials to 'CreatedAppeal' for 'TradingPartner2'

Scenario:Verify Appeal approvals based on System Options Configuration:1 approver,2 reviewers to Deny Appeal Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner3' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click Reconsideration button on enrollment section
And implicit wait '5' seconds
When fill Reconsideration application with:
|reason          |firstName   |lastName   |
|Documents update|${firstName}|${lastName}|
And wait for screening process execution during '5' seconds
And upload new Appeal document text_file.txt
And implicit wait '10' seconds
When wait for screening process execution during '10' seconds
When sign Appeal application
And implicit wait '5' seconds
And submit Appeal application
When implicit wait '5' seconds
Then success message with text - Success!Your request was submitted. should be displayed
When implicit wait '5' seconds
Then rewrite stage of credentials to 'CreatedAppeal' for 'TradingPartner3'

