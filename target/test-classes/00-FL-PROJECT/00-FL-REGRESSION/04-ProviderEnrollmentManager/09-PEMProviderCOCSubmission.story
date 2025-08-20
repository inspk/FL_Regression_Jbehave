Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Requesting COC for PEM Enrollment to approve
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Submitted' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for pem next categories:
|categories             |
|Identifying Information|
And implicit wait '15' seconds
When move to 'Identifying Information' section
And implicit wait '5' seconds
And To fill the identifying information section for Enrollment:
|fax       |
|9852536273|
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Upload supporting documents if needed (Optional)' document text_file.txt
And implicit wait '5' seconds
When move to new 'Summary' section
When implicit wait '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When implicit wait '10' seconds
And refresh page
And implicit wait '20' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC1' for 'ProviderEnrollmentManager3'


Scenario:Requesting COC for PEM Enrollment to deny
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager3' and 'Submitted' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for pem next categories:
|categories      |
|Address Details |
And implicit wait '15' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1                    |
|5503 COLLEGE RD SUITE 209 KEY WEST, FL |
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Upload supporting documents if needed (Optional)' document text_file.txt
And implicit wait '5' seconds
When move to new 'Summary' section
When implicit wait '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
And refresh page
And implicit wait '20' seconds
Then save coc request ID to deny the request of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'ReviewDeniedCoc2' for 'ProviderEnrollmentManager3'

