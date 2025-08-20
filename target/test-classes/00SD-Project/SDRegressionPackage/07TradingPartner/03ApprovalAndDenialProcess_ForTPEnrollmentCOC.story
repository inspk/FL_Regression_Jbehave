Meta:
@regression
Narrative:
- Configuration for COC in Approvals- 1 approver:user,2 reviewer: user
1-->1.Login as First Reviewer and Approve the COC
    2.Login as Second Reviewer and Approve the COC
    3.Login as Approver and Approve the COC
2-->1.Login as First Reviewer and Deny the COC
    2.Login as Second Reviewer and Deny the COC
    3.Login as Approver and Deny the COC

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '5' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories     |
|Classification |
And implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When To fill the Classification Section:
|softwareVendorName|versionId|entityCode|
|Vanderbilt INC    |v3.0     |XMODEM    |
And implicit wait '3' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
When click on Go to Change of Circumstance button
When wait for screening process execution during '30' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'ProviderEnrollmentManager1'

Scenario: Approve Coc by 1 approver,2 reviewers to Deny COC Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to Deny COC Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '10' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories     |
|Classification |
And implicit wait '5' seconds
When move to 'Classification' section
When implicit wait '2' seconds
When To fill the Classification Section:
|softwareVendorName|versionId|entityCode|
|Cornelius INC     |v4.0     |YMODEM    |
And implicit wait '2' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
When click on Go to Change of Circumstance button
When wait for screening process execution during '30' seconds
Then rewrite stage of credentials to 'ReviewDeniedCoc' for 'ProviderEnrollmentManager1'

Scenario: Deny Coc by 1 approver,2 reviewers to Deny COC Provider Enrollment Manager
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '1' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'





