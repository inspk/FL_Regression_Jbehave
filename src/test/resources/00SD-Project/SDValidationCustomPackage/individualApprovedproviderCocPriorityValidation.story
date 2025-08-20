Meta:

Narrative:
As the approved Individual provider,
I can create the CoC for EFT information and
this request should be flagged as important to the internal users
so that the internal user can take action on the CoC as priority.

Scenario:Creating coc for EFT Information category
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
And implicit wait '5' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create COC request for group next categories:
|categories     |
|EFT Information|
And implicit wait '10' seconds
When move to 'EFT Information' section
And implicit wait '5' seconds
Then To fill the EFT Information:
|financialInstitution  |EFTRoutingNumber|
|SURGICAL SERVICES, LLC|55556666        |
When implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'CLIA certification' document text_file.txt
And implicit wait '10' seconds
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '30' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'Individual1'

Scenario: Approve Coc by 1 approver,2 reviewers to Deny COC Individual Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'ApprovedReviewCOC' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|cocType        |
|EFT Information|
When implicit wait '5' seconds
When verify provider data style color: red