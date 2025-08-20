Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Individual Provider End Taxonomy and SL COC flow to Approve
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And close informational pop-up
And implicit wait '3' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '5' seconds
When select next Change of Circumstance categories:
|Coc type                                                                       |
|Taxonomy / Specialty / Provider Type / License information and Service Location|
When click Create group CoC button on categories modal window in own
And implicit wait '25' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
Then Remove/End taxonomy for '225100000X'
Then verify the text for Approved taxonomy 'Ending this Taxonomy information will result in this data being deleted in Servicing Location' and select 'Yes' option
When implicit wait '15' seconds
When click Next button on Taxonomy / Specialty / Provider Type / License Certification Information section
When implicit wait '5' seconds
When move to 'Service Location' section
And implicit wait '5' seconds
Then Remove/End Service Location for 'Secondary'
When implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When implicit wait '20' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '5' seconds



Scenario:Verify COC approvals based on System Options Configuration:1 approver,2 reviewers to approve End Taxonomy and SL COC
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on CoC tab on header
Then search with coc request id to approve the request of the provider
When implicit wait '5' seconds
Then save the providerID from COC tab
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
And implicit wait '10' seconds
When log out from IU portal
And implicit wait '5' seconds
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
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
And implicit wait '10' seconds
When click on Providers tab on header
When implicit wait '5' seconds
Then search with providerID in provider tab
When implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
Then click on 'Enrollment Information' tab in IU
When implicit wait '5' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
Then verify the '1' taxonomies in Taxonomy/Speciality/License Certification section info
When implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When verify the '1' Service locations in Service Location Section
When implicit wait '5' seconds
When log out from IU portal
And implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And click on Provider Data tab on header
And implicit wait '15' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '5' seconds
Then verify the '1' taxonomies in Taxonomy/Speciality/License Certification section info
When implicit wait '3' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
When verify the '1' Service locations in Service Location Section
When implicit wait '5' seconds



