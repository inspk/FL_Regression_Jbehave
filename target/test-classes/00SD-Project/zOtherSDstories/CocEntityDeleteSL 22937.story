Meta:

Narrative:
As the SD approved Entity provider, while creating CoC, I can delete the primary service location given by the reason code and select the secondary service location as primary or add a new primary service location.

Scenario: Coc
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
Given user navigated to landing page
When save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And close informational pop-up
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Service Location' section
When implicit wait '5' seconds
Then Remove/End Primary Service Location for 'Primary' with reason 'Changing the location' note 'Removal note' in COC page
When implicit wait '5' seconds
Then click 'Yes' for the popup 'Removing/Ending this Service Location will result in this data being Removed/Ended in affiliation as well. Do you desire to continue?'
When implicit wait '5' seconds
Then click 'ok' for the popup 'Please add a new primary service location'
When implicit wait '5' seconds
And To fill the Service Location info:
|effectiveDate|locationName      |
|${date}      |New Primary clinic|
And To fill the Service Location info:
|addressLine1|attentionLine|email   |phoneNumber  |
|2321 DUNN AV|${firstName} |${email}|(213)213-2132|
When implicit wait '5' seconds
And To fill the Service Location info:
|officeLocation |
|No             |
When implicit wait '5' seconds
And To fill the Service Location info:
|languageSupported|genderServed|ageRangesServed|
|English          |Male        |All ages served|
When implicit wait '5' seconds
And To fill the Service Location info:
|acceptingNewPatients|ttdTty|county|open24Hours|emergencyServices|patientRecords|personnelRecords|phoneNumberOfPatients|mannerOfService|
|No                  |No    |None  |Yes        |No               |No            |No              |${phoneno}           |In-Person      |
And implicit wait '5' seconds
When click on 'Save' in Service Location section
When implicit wait '5' seconds