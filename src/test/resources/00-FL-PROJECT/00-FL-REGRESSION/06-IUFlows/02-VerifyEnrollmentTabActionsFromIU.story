Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verifying the search criteria and tabs in Enrollment
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When save yesterday's date to variable 'yesterdayDate'
And implicit wait '15' seconds
And click on Enrollment tab on header
!-- When search for enrollment data on IU portal by next parameters:
!-- |enrollType|requestType|
!-- |Individual|Enrollment |
!-- And implicit wait '2' seconds
!-- Then check results after search
!-- When implicit wait '5' seconds
!-- When click reset filters for enrollment data on IU portal
!-- When implicit wait '15' seconds
!-- When search for enrollment data on IU portal by next parameters:
!-- |enrollType|requestType |fromDate        |toDate |
!-- |Individual|Revalidation|${yesterdayDate}|${date}|
!-- And implicit wait '2' seconds
!-- Then check results after search
!-- When implicit wait '5' seconds
!-- When click reset filters for enrollment data on IU portal
!-- When implicit wait '15' seconds
!-- When search for enrollment data on IU portal by next parameters:
!-- |status        |enrollType|
!-- |Approved      |Entity    |
!-- And implicit wait '5' seconds
!-- Then check results after search
!-- When implicit wait '10' seconds
!-- When click reset filters for enrollment data on IU portal
!-- When implicit wait '15' seconds
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |Individual|Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '20' seconds
Then verify provider status should be 'APPROVED' on the Enrollment tab in IU portal
Then click on 'Application' tab in IU
When implicit wait '25' seconds
!-- Then verify the enrollment data by next parameters:
!-- |applicationType     |practiceType            |firstName |
!-- |provider in Medicaid|select the practice type|First Name|
!-- When implicit wait '2' seconds
!-- Then click on 'Screening' tab in IU
!-- When implicit wait '5' seconds
!-- Then screening risk score text should be displayed
!-- Then verify screening risk score should be displayed
!-- Then check 'View Screening Proof Document' is present
!-- When implicit wait '2' seconds
!-- Then check 'Download Screening Proof Document' is present
!-- When implicit wait '5' seconds
!-- Then click on 'Clearing House' tab in IU
!-- When implicit wait '5' seconds
!-- Then verify the data in Clearing house tab
!-- When implicit wait '5' seconds
!-- Then click on 'Indicators' tab in IU
!-- When implicit wait '5' seconds
!-- Then verify the data under the tab
!-- When implicit wait '5' seconds
!-- Then click on 'Duplicity' tab in IU
!-- When implicit wait '10' seconds
!-- Then verify the enrollment data by next parameters:
!-- |providerEnrollmentDetails  |duplicatesFound |
!-- |Provider Enrollment Details|Duplicates Found|
!-- When implicit wait '3' seconds
Then click on 'Files and documents' tab in IU
When implicit wait '5' seconds
Then verify 'Add File' button and select upload file section
When implicit wait '3' seconds
When upload the 'Upload Files' document text_file.txt
Then click on 'Notes' tab in IU
When implicit wait '5' seconds
Then verify 'Add Note' button, add subject 'First Note' and type note 'Sending First note' in Notes tab
When implicit wait '5' seconds
Then verify the added note subject 'First Note' and note message 'Sending First note' is displaying in Notes tab
When implicit wait '5' seconds
Then click on 'Messages' tab in IU
Then verify 'ADD MESSAGE' button, add subject 'First Message' and type message 'Sending First Messag' in Message tab
When implicit wait '5' seconds
Then verify added message subject 'First Message' is diaplaying in Message tab
When click on hidden 'Provider Contracts' tab in IU
When implicit wait '5' seconds
Then verify the data in Provider Contracts tab
When implicit wait '5' seconds
When click on hidden 'Background Screening' tab in IU
When implicit wait '3' seconds
Then verify the 'Background Screening Result' is displaying
When implicit wait '3' seconds
When click on hidden 'Alternate Identifier' tab in IU
When implicit wait '5' seconds
Then verify 'Add Alternate Identifier' button is displaying
When implicit wait '5' seconds
Then verify the enrollment data by next parameters:
|identifierLevel|identifierName|identifierType|identifierValue|identifierReasonCode|startDate|
|NPI/Provider   |1932136173    |Phone Number  |1234567890     |New Enrollment      |${date}  |
When implicit wait '5' seconds
Then click on the 'Save'
When implicit wait '5' seconds
Then verify added Alternative Identifier 'NPI/Provider' is displaying
When implicit wait '5' seconds
When click on hidden 'Florida Medicaid Provider ID' tab in IU
When implicit wait '5' seconds
Then verify data is present in Florida Medicaid Provider ID