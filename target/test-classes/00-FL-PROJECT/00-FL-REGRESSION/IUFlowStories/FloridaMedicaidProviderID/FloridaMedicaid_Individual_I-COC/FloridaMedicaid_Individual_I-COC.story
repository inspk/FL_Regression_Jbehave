Meta:
Narrative:
  As an internal user
  I want to verify and edit FloridaMedicaid in both Enrollment and Providers Module.

Scenario: Verify Florida Medicaid ID for Individual Enrollment- ICOC
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '20' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Individual Providers' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Change of Circumstance'
When implicit wait '5' seconds
Then verify configuration for FloridaMedicaid in SystemOption
When implicit wait '5' seconds
Then click on Dashboard tab on header
When implicit wait '5' seconds
When click on Enrollment tab on header
When implicit wait '5' seconds
Then search with ProviderID '4000002'
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '20' seconds
Then verify BaseProviderID , LocationProviderID and status
When implicit wait '20' seconds
When edit date and status
When implicit wait '2' seconds
Then I should see edit confirmation message :  "Medicaid Provider has been updated successfully."
When implicit wait '40' seconds
When click on Providers tab on header
When implicit wait '5' seconds
Then search with ProviderID '4000002'
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '20' seconds
Then verify BaseProviderID , LocationProviderID and status
When implicit wait '20' seconds
When edit date and status
When implicit wait '2' seconds
Then I should see edit confirmation message :  "Medicaid Provider has been updated successfully."
When implicit wait '40' seconds
When log out from portal