Meta:

Narrative:
As an Internal User
I want to perform credentialing for providers
So that providers can be properly verified and approved

Scenario: Entity Provider Credentialing Flow
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
And click on Credentialing tab on header
When implicit wait '5' seconds
When user clicks on Add Credentialing button
When implicit wait '5' seconds
When user searches for provider by NPI '1740519073'
When implicit wait '5' seconds
When user clicks on NPI search button
When implicit wait '20' seconds
When user clicks on Create button
When implicit wait '5' seconds
When user clicks on Credentialing Details section
When implicit wait '10' seconds
When user saves credentialing request ID
When implicit wait '10' seconds
When user fills credentialing information with radio button value 'No'
When implicit wait '2' seconds
When user clicks on Upload Credentialing Documents section
When implicit wait '2' seconds
When user clicks on Go to Credentialing link
When implicit wait '10' seconds
When user performs Co Review and Medical Director actions for NPI '1740519073'
When implicit wait '10' seconds
Then credentialing request ID should be saved
When implicit wait '5' seconds
When implicit wait '10' seconds
When log out from portal
When implicit wait '20' seconds
When new user logs to Internal User portal with username - cvocommitteereview.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When user assigns credentialing to CVO Medical Director for Enrollment 'Entity'
When implicit wait '10' seconds
Then credentialing request ID should be saved
When implicit wait '10' seconds
When log out from portal
When implicit wait '20' seconds
When new user logs to Internal User portal with username - cvomedicaldirector.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
And click on Credentialing tab on header
When implicit wait '5' seconds
When user approves credentialing as CVO Medical Director
When implicit wait '10' seconds
Then credentialing should be completed successfully
When implicit wait '5' seconds
When log out from portal

Scenario: Individual Provider Credentialing Flow
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
And click on Credentialing tab on header
When implicit wait '5' seconds
When user clicks on Add Credentialing button
When implicit wait '5' seconds
When user searches for provider by NPI '1013321959'
When implicit wait '5' seconds
When user clicks on NPI search button
When implicit wait '20' seconds
When user clicks on Create button
When implicit wait '5' seconds
When user clicks on Credentialing Details section
When implicit wait '10' seconds
When user saves credentialing request ID
When implicit wait '10' seconds
When user fills credentialing information with radio button value 'No'
When implicit wait '2' seconds
When user clicks on Upload Credentialing Documents section
When implicit wait '2' seconds
When user clicks on Go to Credentialing link
When implicit wait '10' seconds
When user performs Co Review and Medical Director actions for NPI '1013321959'
When implicit wait '10' seconds
Then credentialing request ID should be saved
When implicit wait '5' seconds
When implicit wait '10' seconds
When log out from portal
When implicit wait '20' seconds
When new user logs to Internal User portal with username - cvocommitteereview.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When user assigns credentialing to CVO Medical Director for Enrollment 'Individual'
When implicit wait '10' seconds
Then credentialing request ID should be saved
When implicit wait '10' seconds
When log out from portal
When implicit wait '20' seconds
When new user logs to Internal User portal with username - cvomedicaldirector.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
And click on Credentialing tab on header
When implicit wait '5' seconds
When user approves credentialing as CVO Medical Director
When implicit wait '10' seconds
Then credentialing should be completed successfully
When implicit wait '5' seconds
When log out from portal