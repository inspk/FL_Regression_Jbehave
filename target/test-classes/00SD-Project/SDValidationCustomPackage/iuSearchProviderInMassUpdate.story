Meta:

Narrative:
As the DYP IU,
in the mass update,
1-->I can search for the providers by uploading the list of FEIN numbers
in an excel file and perform mass update.
2-->I can search with State dropdown multi-select,
servicing addresses, and program participation

Scenario: scenario description
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
Then click on the 'MASS UPDATE' Provider Details Page
When implicit wait '5' seconds
Then upload excel file 'massupdate_fein.xlsx'
When implicit wait '15' seconds
When search for provider inquiry data on IU portal by next parameters:
|massupdateStatus|
|Reactivated     |
When implicit wait '5' seconds

Scenario: scenario description
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
Then click on the 'MASS UPDATE' Provider Details Page
When implicit wait '5' seconds
When search for provider inquiry data on IU portal by next parameters:
|massupdateStatus|programParticipation       |state1      |serviceLocation  |
|Active          |Primary Care Provider (PCP)|South Dakota|3001 Henderson Dr|
When implicit wait '5' seconds