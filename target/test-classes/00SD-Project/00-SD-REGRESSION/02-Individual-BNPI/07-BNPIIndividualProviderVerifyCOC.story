Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario:Individual Provider COC flow to Approve
Meta:
Given take firstname, lastname and email credentials for type 'Individual2' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
When click on dashboard 'CoC' from the provider portal
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '2' seconds
When select enrollment data type in coc pop-up
And implicit wait '2' seconds
When click next button in select coc type pop-up
And implicit wait '2' seconds
And create Change of Circumstance request for group next categories:
|categories      |
|EFT Information |
And implicit wait '15' seconds
When move to 'EFT Information' section
And implicit wait '5' seconds
Then To fill the EFT Information:
|financialInstitution    |EFTRoutingNumber |
|Pharma Mediplus Pvt Lmt |98765243         |
When implicit wait '2' seconds
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
And refresh page
And implicit wait '20' seconds
Then save coc request ID to approve the request of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC1' for 'Individual2'


Scenario:Individual Provider COC flow to Deny
Meta:
Given take firstname, lastname and email credentials for type 'Individual2' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
When click on dashboard 'CoC' from the provider portal
And implicit wait '5' seconds
When click on Change request button on Coc page
And implicit wait '2' seconds
When select enrollment data type in coc pop-up
And implicit wait '2' seconds
When click next button in select coc type pop-up
And implicit wait '2' seconds
And create Change of Circumstance request for group next categories:
|categories      |
|Address Details |
And implicit wait '15' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1           |
|1810 VISTA RIDGE PL PIERRE, SD|
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
And refresh page
When implicit wait '20' seconds
Then save coc request ID to deny the request of the provider
When implicit wait '5' seconds
Then rewrite stage of credentials to 'DeniedReviewCOC2' for 'Individual2'