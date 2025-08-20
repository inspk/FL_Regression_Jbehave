Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Florida Medicaid ID for TP Enrollment
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '10' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
When implicit wait '10' seconds
Then click on 'Approvals' links in system options
When implicit wait '10' seconds
When expand the Group Providers Approval configuration for 'Trading Partners' Enrollment type Page
When implicit wait '10' seconds
When click on View button for request 'Enrollment'
When implicit wait '10' seconds
Then verify configuration for FloridaMedicaid in SystemOption
When implicit wait '10' seconds
Then click on Dashboard tab on header
When implicit wait '10' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |TP       |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'TP' provider
When implicit wait '20' seconds
Then verify BaseProviderID , LocationProviderID and status
When implicit wait '20' seconds
When edit date and status
When implicit wait '2' seconds
Then I should see edit confirmation message :  "Medicaid Provider has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |TP           |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'TP' provider
When implicit wait '5' seconds
Then verify BaseProviderID, LocationProviderID and status for Provider tab
When implicit wait '20' seconds
When edit date and status
When implicit wait '2' seconds
Then I should see edit confirmation message :  "Medicaid Provider has been updated successfully."