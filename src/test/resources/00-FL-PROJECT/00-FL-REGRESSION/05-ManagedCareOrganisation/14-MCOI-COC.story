Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: scenario description
Given take firstname, lastname and email credentials for type 'MCO3' and 'Submitted' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save value 'Mediplus Community Services' to variable 'planLegalName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on 'Add I Coc'
When set provider name '${planLegalName}' in i-Coc popup
When set enrollment type 'MCO' in i-Coc popup
When click search in I-Coc popup
And implicit wait '5' seconds
When select provider in i-Coc popup
When click next in i-Coc popup
And implicit wait '5' seconds
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
|mailingAddressLine1              |
|1677 ATLANTA PLAZA DR SANIBEL, FL|
And implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '5' seconds
When upload new 'Additional Documents(Optional)' document text_file.txt
And implicit wait '5' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When implicit wait '20' seconds