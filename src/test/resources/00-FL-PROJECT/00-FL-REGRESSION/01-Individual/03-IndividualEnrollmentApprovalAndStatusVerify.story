Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Individual Provider Status Changing from New to Approved with 2 reviewers and 1 Approver
Given take firstname, lastname and email credentials for type 'Individual1' and 'Initialized' and use in session
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
Then verify provider status should be 'NEW' on the Enrollment tab in IU portal
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
And implicit wait '35' seconds
Then verify provider status should be 'DOCUMENT REVIEW' on the Enrollment tab in IU portal
When implicit wait '2' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
And refresh page
And implicit wait '30' seconds
Then verify provider status should be 'READY FOR SCREENING' on the Enrollment tab in IU portal
When implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request ready for screening status to - 'Under Screening'
When implicit wait '5' seconds
And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
Then verify provider status should be 'UNDER CLEARING HOUSE CHECK' on the Enrollment tab in IU portal
When implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And refresh page
And implicit wait '20' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '30' seconds
Then verify provider status should be 'PENDING REVIEW' on the Enrollment tab in IU portal
When implicit wait '2' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And refresh page
And implicit wait '10' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '30' seconds
Then verify provider status should be 'PENDING REVIEW' on the Enrollment tab in IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And refresh page
When implicit wait '10' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '30' seconds
Then verify provider status should be 'PENDING APPROVAL' on the Enrollment tab in IU portal
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And wait for screening process execution during '15' seconds
Then verify provider status should be 'APPROVED' on the Enrollment tab in IU portal
When log out from IU portal
And refresh page
When implicit wait '10' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
Then verify all the tabs should be displayed:
|names             |
|Dashboard         |
|Screening         |
|Affiliations      |
|CoC               |
|Provider Data     |
|Help center       |
Then rewrite stage of credentials to 'Approved' for 'Individual1'
