Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal




Scenario:PEM Provider End Affiliation COC flow to Approve
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '5' seconds
When select end affiliation type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '15' seconds
When move to 'Affiliation' section
And implicit wait '5' seconds
Then click on ellipsis and End Affiliation for 'PEM to Entity' with reason 'Incorrectly linked'
When implicit wait '5' seconds
When move to new 'Summary' section
When implicit wait '5' seconds
When submit application
When implicit wait '10' seconds
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When implicit wait '40' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '10' seconds


Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve COC End Affiliation
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Hutchinson Area Health Care' to variable 'providerLegalBusinessName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
Then save the providerID from COC tab
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
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
And implicit wait '10' seconds
When log out from IU portal
And refresh page
And implicit wait '10' seconds
Given user navigated to landing page
When new user logs to Internal User portal with username - martin.providers+gussie.luther@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '30' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '10' seconds
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
And implicit wait '5' seconds
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
When select 'Show only Ended Affiliations' in the Affiliation Page
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
When click on search in Affiliation tab
When implicit wait '2' seconds
When select checkbox 'Show only Ended Affiliations' in the Affiliation Page
When implicit wait '2' seconds
Then verify Provider Name '${providerLegalBusinessName}' and Affiliation Type 'PEM to Entity' in Affiliation Tab
When implicit wait '5' seconds