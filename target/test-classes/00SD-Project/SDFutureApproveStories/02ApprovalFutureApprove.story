Meta:
@regression
Narrative:
- Configuration for Enrollment in Approvals- 1 approver:user,  2 reviewer: user
1-->1.Login as First Reviewer and Approve the Enrollment
    2.Login as Second Reviewer and Approve the Enrollment
    3.Login as Approver and change status to Future Approved the Enrollment

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to approve Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
And save current date to variable 'date'
When save current date plus 1 one day to variable end data 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+elon.mask@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${date}' from the create sitevisit popup
When click on Yes to waive Site Visit
When select reason 'Invalid Site Visit' and 'invalid site visit' create site visit popup
And implicit wait '3' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+lewis.wood@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Future Approved' and set the '${expDate}' with reason - 'Future approved as per provider request' and see 'Notes to provider' is displaying
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'FutureApproved' for 'Individual1'