Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario:Group Provider Enrollment Screening flow
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Submitted' and use in session
Given user navigated to landing page
And save value 'Medplus Community Service PNC' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When submits screening with status 'UNDER SCREENING' and get specific request id and save it to 'requestId' with delay '10'
When get authorization user 'cookies'
When replace request id '${requestId}' screening file '100screening.xml'
When send screening request 1 with file '100screening.xml' with '${cookies}'
And refresh page
And implicit wait '15' seconds