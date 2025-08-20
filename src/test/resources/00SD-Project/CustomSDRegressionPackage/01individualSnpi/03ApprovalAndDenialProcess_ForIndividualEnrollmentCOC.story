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

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories      |
|Address Details |
And implicit wait '10' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|
|4514 Laramie St Cheyenne WY|
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'Individual1'

Scenario: Approve Coc by 1 approver,2 reviewers to Deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Missing Document' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
And implicit wait '5' seconds
When search for provider by name '${firstName} ${lastName}' with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '10' seconds
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on Yes to waive Site Visit
And implicit wait '5' seconds
When select reason 'Invalid Site Visit' and 'invalid site visit' create site visit popup
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username -  provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
!-- And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to Deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories      |
|Address Details |
And implicit wait '10' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|
|4514 Laramie St Cheyenne WY|
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ReviewDeniedCoc' for 'Individual1'

Scenario: Deny Coc by 1 approver,2 reviewers to Deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Deny' button on decision panel
And implicit wait '5' seconds
When select deny reason 'Enrollment Rules Violation' in Approval popup
And implicit wait '5' seconds
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
And implicit wait '5' seconds
And set enrollment request status - 'Denied' with reason - 'Missing Document'