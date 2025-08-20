Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC Group Enrollment
Meta:
Given user navigated to landing page
And save value 'Mediplus Community Service' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
Then search with RequestID '086'
When implicit wait '20' seconds
Then check results after search
When implicit wait '20' seconds
Then click on the 'CoC' provider
When implicit wait '40' seconds
When implicit wait '40' seconds
When get authorization user 'cookies'
When replace request id '086' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
When implicit wait '20' seconds
And click on CoC tab on header
Then search with RequestID '086'
Then check results after search
When implicit wait '20' seconds
Then click on the 'CoC' provider
When implicit wait '40' seconds
Then verify provider status should be 'PENDING APPROVAL' on the Enrollment tab in IU portal
When click on 'Change status' button from the enrollment details page
When implicit wait '20' seconds
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'
And wait for screening process execution during '15' seconds
Then verify provider status should be 'APPROVED' on the Enrollment tab in IU portal
When implicit wait '5' seconds
And implicit wait '20' seconds
