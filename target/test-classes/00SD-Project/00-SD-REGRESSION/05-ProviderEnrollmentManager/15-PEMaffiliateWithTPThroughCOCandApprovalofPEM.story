Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Affiliation with TP for PEM Provider Enrollment through COC
Given user navigated to landing page
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And close informational pop-up
When implicit wait '5' seconds
When click on 'Coc' provider  data tab on the dashboard
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '5' seconds
When select add affiliation type in coc pop-up
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to new 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set providerid search value '4000074' in affiliation section
And implicit wait '5' seconds
When set type search value 'TP' in affiliation section
When click search by npi in affiliation section
When click add button in affiliation section
When select affliation type 'PEM to TP'
When fill the effective start '${date}' and effective end '${expDate}' to enrollment end affiliation type page
And implicit wait '5' seconds
When click add button in affiliation pop-up
And implicit wait '10' seconds
When move to new 'Summary' section
And implicit wait '10' seconds
When sign/submit application
And implicit wait '15' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '25' seconds
When click navigate to dashboard link after sign
When wait for screening process execution during '5' seconds
When log out from PE portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - len.providers+2255@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the PEM' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When log out from PE portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on 'Coc' provider  data tab on the dashboard
And implicit wait '20' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '5' seconds



Scenario: Approve Coc by 1 approver,2 reviewers to approve COC PEM Enrollment
Meta:
Given user navigated to landing page
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'
And implicit wait '15' seconds
