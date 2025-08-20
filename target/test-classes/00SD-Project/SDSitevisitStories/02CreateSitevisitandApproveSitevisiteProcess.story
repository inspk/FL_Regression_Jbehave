Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Create Site Visit in Enrollment Tab
Meta:
Given take firstname, lastname and email credentials for type 'IndividualFingerprint1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${lastName}    |
When click to provider data with text '${lastName}' on IU portal
And implicit wait '5' seconds
When click on create site visit button
Then select locations 'Primary clinic' to create sitevisit
When set the date '${expDate}' from the create sitevisit popup
When click on No to waive Site Visit
When select reason 'S01' and 'note' create site visit popup
And implicit wait '5' seconds
When log out from IU portal
Given user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Site visits tab on header
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When click reset filters for provider data on IU portal
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When select 'View' from the site visit list
When implicit wait '10' seconds
When move to site visit 'Upload Site Visit Documents' section
When implicit wait '5' seconds
When submit sitevisit application
When implicit wait '10' seconds
When click on go to sitevisit button
When implicit wait '10' seconds
When click on Site visits tab on header
When implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When click reset filters for provider data on IU portal
When implicit wait '10' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When select 'Sign' from the site visit list
When implicit wait '5' seconds
And sign provider application for user '${firstName} ${lastName}'
When wait for screening process execution during '40' seconds

Scenario: Sign Individual Provider Site Visit
Meta:
Given take firstname, lastname and email credentials for type 'IndividualFingerprint1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to Message Center
When open message in the 'Sign site visit application' message center
When sign provider application for user '${firstName} ${lastName}'
And wait for screening process execution during '40' seconds

Scenario: Verify SiteVisit approvals based on System Options Configuration:1 approver,2 reviewers to approve Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'IndividualFingerprint1' and 'Created' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Site visits tab on header
When implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When select 'View' from the site visit list
And refresh page
When implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+lewis.wood@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Site visits tab on header
When implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When click reset filters for provider data on IU portal
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When select 'View' from the site visit list
And refresh page
When implicit wait '10' seconds
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Site visits tab on header
When implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${lastName}              |
When implicit wait '5' seconds
When select 'View' from the site visit list
And refresh page
When implicit wait '10' seconds
When click on 'Change status' button from the enrollment details page
When set to the status for enrollment request status - 'Approved' and reason - 'Positive referrals'
And wait for screening process execution during '5' seconds
