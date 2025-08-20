Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verifying the search criteria and tabs in COC
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When save yesterday's date to variable 'yesterdayDate'
And implicit wait '15' seconds
And click on CoC tab on header
When search for enrollment data on IU portal by next parameters:
|type             |requestStatus |
|EFT Information  |Pending Review|
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
When click reset filters for enrollment data on IU portal
When search for enrollment data on IU portal by next parameters:
|fromDate        |toDate |
|${yesterdayDate}|${date}|
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
When click reset filters for enrollment data on IU portal
When implicit wait '5' seconds
When search for enrollment data on IU portal by next parameters:
|type       |requestStatus|
|Affiliation|Approved     |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Affiliation' provider
When implicit wait '20' seconds
Then click on 'Application' tab in IU
When implicit wait '5' seconds
When move to 'Affiliation' section
When implicit wait '5' seconds
Then verify that the affiliation details are displayed
When implicit wait '5' seconds
Then click on 'Screening' tab in IU
When implicit wait '5' seconds
Then verify screening risk score should be displayed
Then check 'View Screening Proof Document' is present
When implicit wait '2' seconds
Then check 'Download Screening Proof Document' is present
When implicit wait '5' seconds
Then click on 'Notes' tab in IU
When implicit wait '5' seconds
Then verify 'Add Note' button, add subject 'First COC Note' and type note 'Sending First COC note' in Notes tab
When implicit wait '5' seconds
Then verify the added note subject 'First COC Note' and note message 'Sending First COC note' is displaying in Notes tab
When implicit wait '5' seconds
Then click on 'Messages' tab in IU
Then verify 'ADD MESSAGE' button, add subject 'First COC Message' and type message 'Sending First COC Message' in Message tab
When implicit wait '5' seconds
Then verify added message subject 'First COC Message' is diaplaying in Message tab
