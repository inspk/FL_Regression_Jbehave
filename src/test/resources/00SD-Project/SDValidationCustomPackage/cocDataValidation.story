Meta:

@regression
Narrative:
    1.Login as Provider and create the COC
    2.Login as Provider and Verify the Provider details in coc tab


Scenario:Creating COC and verify details in provider coc tab
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for group next categories:
|categories      |
|Address Details |
And implicit wait '10' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|
|4514 Laramie St Cheyenne WY|
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'CLIA certification' document text_file.txt
And implicit wait '50' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '30' seconds
And implicit wait '10' seconds
When log out from PE portal
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'Individual1'

Scenario: verify details in provider coc tab

Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'ApprovedReviewCOC' and use in session
When save current date plus 1 years to variable 'expDate'
When user navigated to landing page
When new user logs to Internal User portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
When implicit wait '10' seconds
Then verify the Provider name submitted  COC 'Provider Name' is '${firstName}|${lastName}'
Then verify the Provider submitted COC details 'NPI' is '${npi}'
Then verify the Provider submitted COC details 'Revalidation Due Date' is '${exDate}'
