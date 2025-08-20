Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verifying the search criteria and tabs in Provider
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When save yesterday's date to variable 'yesterdayDate'
And implicit wait '15' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|enrollmentType|
|TP            |
And implicit wait '2' seconds
Then check results after search
When implicit wait '5' seconds
When click reset filters for enrollment data on IU portal
When search for enrollment data on IU portal by next parameters:
|enrollmentType|providerStatus|
|MCO           |Terminated    |
And implicit wait '2' seconds
Then check results after search
When implicit wait '5' seconds
When click reset filters for enrollment data on IU portal
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |Individual    |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '10' seconds
Then provider status as 'Active' is displaying
When implicit wait '5' seconds
Then click on 'Summary' tab in IU
When implicit wait '5' seconds
Then verify the 'Claims' data is present
Then click on 'Enrollment Information' tab in IU
When implicit wait '5' seconds
Then verify the enrollment data by next parameters:
|applicationType     |practiceType            |firstName |
|provider in Medicaid|select the practice type|First Name|
When implicit wait '2' seconds
Then click on 'Indicators' tab in IU
When implicit wait '5' seconds
Then verify the data under the tab
When implicit wait '5' seconds
Then click on the 'Add'
When implicit wait '5' seconds
Then verify the enrollment data by next parameters:
|indicatorLevel|indicatorType           |indicatorValue|providerStartDate|reasonCode  |
|NPI           |Fingerprint Verification|No            |${date}          |Reason Code1|
Then click on the 'Add' button in the popup
When implicit wait '5' seconds
Then verify the data under the tab
When implicit wait '5' seconds
Then click on 'Service Location' tab in IU
When implicit wait '5' seconds
Then verify 'Primary' Location type added in service location
When implicit wait '5' seconds
When click on hidden 'Florida Medicaid Provider ID' tab in IU
When implicit wait '5' seconds
Then verify data is present in Florida Medicaid Provider ID
When implicit wait '5' seconds
When click on hidden 'Affiliation Information' tab in IU
When implicit wait '5' seconds
Then verify the affiliations are present in Affiliation tab
When implicit wait '5' seconds
When select 'Show only Ended Affiliations' in the Affiliation Page
When implicit wait '5' seconds
Then check results after search
Then verify the affiliations are present in Affiliation tab
When click on hidden 'Medicaid Provider Agreement' tab in IU
When implicit wait '5' seconds
Then verify the data under the tab
When implicit wait '2' seconds
When click on hidden 'Provider Contracts' tab in IU
When implicit wait '5' seconds
Then click on the 'Add'
When implicit wait '2' seconds
Then verify the enrollment data by next parameters:
|providerType       |contracts       |financialPayer|contractStatus|providerStartDate|
|Audiologist (PT 60)|Hearing Services|Default       |AC - ACTIVE   |${date}          |
When implicit wait '2' seconds
Then click on the 'Add' button in the popup
When implicit wait '5' seconds
Then verify the data under the tab
When implicit wait '5' seconds
When click on hidden 'Payment Restrictions' tab in IU
When implicit wait '3' seconds
Then verify the data under the tab
When implicit wait '3' seconds
When click on hidden 'Files and documents' tab in IU
When implicit wait '3' seconds
Then verify the files and documents under the Files and documents tab
When implicit wait '3' seconds
When click on hidden 'Monitoring' tab in IU

When click on hidden 'History' tab in IU
When implicit wait '5' seconds
Then verify the data under history tab
When implicit wait '3' seconds
When click on hidden 'Timeline' tab in IU
When implicit wait '5' seconds

When click on hidden 'Revalidation' tab in IU
When implicit wait '2' seconds
Then verify and get the Next Revalidation Date
When implicit wait '2' seconds

When click on hidden 'Messages' tab in IU
When implicit wait '5' seconds
Then verify 'ADD MESSAGE' button, add subject 'First Provider Message' and type message 'Sending First Provider Message' in Message tab
When implicit wait '5' seconds
Then verify added message subject 'First Provider Message' is diaplaying in Message tab
When implicit wait '5' seconds
When click on hidden 'Site visits' tab in IU
When implicit wait '5' seconds
Then verify and click on 'View history' link
When implicit wait '5' seconds
When click on hidden 'Notes' tab in IU
When implicit wait '5' seconds
Then verify 'Add Note' button, add subject 'First Provider Note' and type note 'Sending First Provider note' in Notes tab
When implicit wait '5' seconds
Then verify the added note subject 'First Provider Note' and note message 'Sending First Provider note' is displaying in Notes tab
When implicit wait '5' seconds
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






