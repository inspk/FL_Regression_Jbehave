Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Coc-affiliation
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select edit affiliation type in coc pop-up
When move to 'Affiliation' section
When expand 'group' service location in coc affiliation section
When click Edit service location in coc affiliation section
When select 'No patient presents' Manner of Sevice in coc affiliation section
When update service location in coc affiliation section
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '30' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'Individual1'