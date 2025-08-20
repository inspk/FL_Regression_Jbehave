Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Login as Approved Provider And Verifying All the Tabs
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - dyp.provider+samplee@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Dashboard tab on header
Then page with url 'dashboard' should be opened
When implicit wait '5' seconds
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
When click on Screening tab on header
When implicit wait '5' seconds
Then page with url 'screening' should be opened
Then verify screening risk score should be displayed
When implicit wait '5' seconds
Then check 'View Screening Proof Document' is present
When implicit wait '5' seconds
Then check 'Download Screening Proof Document' is present
When implicit wait '5' seconds
When click on Affiliations tab on header
Then page with url 'affiliations' should be opened
When implicit wait '5' seconds
When click on search in affiliation coc
When implicit wait '5' seconds
When select checkbox 'Show only Ended Affiliations' in the Affiliation Page
When implicit wait '5' seconds
Then check results after search
When click on CoC tab on header
Then page with url 'coc-list' should be opened
When implicit wait '5' seconds
Then check 'Add Change of Circumstance' is present in COC tab
When implicit wait '5' seconds
When click on Provider Data tab on header
Then page with url 'provider-data' should be opened
When implicit wait '20' seconds
Then check 'Details' section is displaying in provider data
When implicit wait '5' seconds
Then verify the enrollment data by next parameters:
|applicationType     |practiceType            |firstName |
|provider in Medicaid|select the practice type|First Name|
When implicit wait '2' seconds
Then check 'Enrollment Span' section is displaying in provider data
Then check 'Service Location' section is displaying in provider data
Then check 'Files and documents' section is displaying in provider data
Then check 'Enrollments' section is displaying in provider data
Then check 'Affiliations' section is displaying in provider data
When click on Help center tab on header
When implicit wait '15' seconds