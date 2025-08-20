Meta:
Narrative:
  As an internal user
  I want to add and edit alternate identifiers in both Enrollment and Providers Module.

Scenario: Add and edit alternate identifier for Individual Enrollment
Meta:
Given user navigated to landing page
When implicit wait '10' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '10' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |Individual|Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '20' seconds
Then I add an alternate identifier with level Key Personnel, type COBA ID, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |Individual    |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Individual' provider
When implicit wait '5' seconds
Then I add an alternate identifier in providers tab with level NPI/Provider, type COBA ID, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '10' seconds
When log out from portal

Scenario: Add and edit alternate identifier for Entity Enrollment
Meta:
Given user navigated to landing page
When implicit wait '10' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |Entity    |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '10' seconds
Then click on the 'Entity' provider
When implicit wait '20' seconds
Then I add an alternate identifier with level NPI/Provider, type Historical/Legacy NPI, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |Entity        |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'Entity' provider
When implicit wait '5' seconds
Then I add an alternate identifier in providers tab with level Ownership, type Historical/Legacy NPI, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '10' seconds
When log out from portal

Scenario: Add and edit alternate identifier for TP Enrollment
Meta:
Given user navigated to landing page
When implicit wait '10' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |TP        |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'TP' provider
When implicit wait '20' seconds
Then I add an alternate identifier with level Provider Medicaid Id, type Historical TaxID (FEIN), reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |TP            |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'TP' provider
When implicit wait '5' seconds
Then I add an alternate identifier in providers tab with level Key Personnel, type Phone Number, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '10' seconds
When log out from portal


!-- Scenario: Add and edit alternate identifier for PEM Enrollment
Meta:
Given user navigated to landing page
When implicit wait '10' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |PEM       |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'PEM' provider
When implicit wait '20' seconds
Then I add an alternate identifier with level Provider Medicaid Id, type Phone Number, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |PEM           |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'PEM' provider
When implicit wait '5' seconds
Then I add an alternate identifier in providers tab with level Provider Medicaid Id, type Historical TaxID (SSN), reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '10' seconds
When log out from portal

Scenario: Add and edit alternate identifier for MCO Enrollment
Meta:
Given user navigated to landing page
When implicit wait '10' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
Then statistics should be displayed on dashboard page
When implicit wait '3' seconds
When click on Enrollment tab on header
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|requestType|
|Approved      |MCO       |Enrollment |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'MCO' provider
When implicit wait '20' seconds
Then I add an alternate identifier with level Provider Medicaid Id, type Phone Number, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '40' seconds
And click on Providers tab on header
When search for enrollment data on IU portal by next parameters:
|providerStatus|enrollmentType|
|Active        |MCO           |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
Then click on the 'MCO' provider
When implicit wait '5' seconds
Then I add an alternate identifier in providers tab with level Provider Medicaid Id, type TP IP, reason New Enrollment
When implicit wait '2' seconds
Then I should see "Alternate Identifier has been added successfully."
When implicit wait '40' seconds
When I edit that alternate identifier to reason CHOW and status Inactive
When implicit wait '2' seconds
Then I should get "Alternate Identifier has been updated successfully."
When implicit wait '10' seconds
When log out from portal
