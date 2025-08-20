Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Group Provider Status Changing from New to Approved with 2 reviewers and 1 Approver
Meta:
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '10' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '20' seconds
!-- When click on Enrollment tab on header
!-- When implicit wait '5' seconds
!-- Then search with RequestID '446'
!-- When implicit wait '10' seconds
!-- Then check results after search
!-- When implicit wait '5' seconds
!-- Then click on the 'Entity' provider
!-- When implicit wait '40' seconds
!-- Then verify provider status should be 'NEW' on the Enrollment tab in IU portal
!-- When click on 'Change status' button from the enrollment details page
!-- When implicit wait '5' seconds
!-- When set enrollment request New status to - 'Document Review'
!-- When implicit wait '5' seconds
!-- And refresh page
!-- And implicit wait '40' seconds
!-- When click on 'Change status' button from the enrollment details page
!-- When implicit wait '5' seconds
!-- When set enrollment request document status to - 'Document Review Approved'
!-- When implicit wait '5' seconds
!-- And refresh page
!-- And implicit wait '40' seconds
!-- When click on 'Change status' button from the enrollment details page
!-- When implicit wait '5' seconds
!-- When set enrollment request ready for screening status to - 'Under Screening'
!-- When implicit wait '5' seconds
!-- And select provider reason 'Moving to Under screening' and 'screening note' Provider under screening
!-- When implicit wait '5' seconds
!-- When click on apply button in under screening page
!-- When implicit wait '5' seconds
!-- And refresh page
!-- When implicit wait '10' seconds
!-- When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When implicit wait '10' seconds
When get authorization user 'cookies'
When implicit wait '10' seconds
When replace request id '446' screening file '100screening.xml'
When implicit wait '10' seconds
When send screening request 1 with file '100screening.xml' with '${cookies}'
When implicit wait '10' seconds
And refresh page
And implicit wait '15' seconds
When click on Enrollment tab on header
And implicit wait '40' seconds
Then search with RequestID '446'
Then check results after search
When implicit wait '5' seconds
Then click on the 'Entity' provider
When implicit wait '10' seconds
Then verify provider status should be 'UNDER CLEARING HOUSE CHECK' on the Enrollment tab in IU portal
When implicit wait '2' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And implicit wait '40' seconds
And refresh page
And implicit wait '40' seconds
And refresh page
And implicit wait '40' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and set the '${date}' with reason - 'Approved Based Documents'
And implicit wait '30' seconds
Then verify provider status should be 'APPROVED' on the Enrollment tab in IU portal
When log out from IU portal