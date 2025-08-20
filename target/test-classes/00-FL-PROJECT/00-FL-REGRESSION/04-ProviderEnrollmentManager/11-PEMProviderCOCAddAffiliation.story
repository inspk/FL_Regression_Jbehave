Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario:PEM Provider Add Affiliation COC flow to Approve
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When save current date plus 1 one day to variable end data 'tmrwDate'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '5' seconds
When select add affiliation type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '15' seconds
When move to 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
And implicit wait '5' seconds
When set npi search value '1326418153' in affiliation section
And implicit wait '5' seconds
When set type search value 'Entity' in affiliation section
And implicit wait '5' seconds
When click search by npi in affiliation section
And implicit wait '5' seconds
When click add button in affiliation section
And implicit wait '5' seconds
When fill the location effective start '${date}' and location effective end '${expDate}' in affiliation popup
And implicit wait '5' seconds
When click add button in affiliation pop-up
And implicit wait '3' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When sign/submit application
And implicit wait '15' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
And click on CoC tab on header
When implicit wait '20' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '5' seconds
When log out from PE portal
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - sanivar.providers+2610@gmail.com and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When navigate to Message Center
And implicit wait '5' seconds
When click on 'Confirm your affiliation to the PEM' in message center
And implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When click navigate to dashboard link after sign
And implicit wait '30' seconds



Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC Add Affiliation
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
And save value 'Hutchinson Area Health Care' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And implicit wait '5' seconds
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '20' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request Under Clearing House Check status to - 'Clearing House Check Completed'
When implicit wait '5' seconds
And select provider reason 'Positive Background Results' and 'Clearing House Check Completed note' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
And refresh page
And implicit wait '20' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '10' seconds
And refresh page
And implicit wait '15' seconds
When log out from IU portal
And implicit wait '5' seconds
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And implicit wait '5' seconds
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '15' seconds
When log out from IU portal
And refresh page
And implicit wait '10' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'
And implicit wait '10' seconds
And refresh page
And implicit wait '15' seconds
When click on Providers tab on header
When implicit wait '5' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
Then click on 'Affiliation Information' tab in IU
When implicit wait '5' seconds
Then verify Provider Name '${providerLegalBusinessName}' and Affiliation Type 'PEM to Entity' in Affiliation Tab
When implicit wait '5' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And click on Affiliations tab on header
When implicit wait '5' seconds
Then verify Provider Name '${providerLegalBusinessName}' and Affiliation Type 'PEM to Entity' in Affiliation Tab
When implicit wait '5' seconds
