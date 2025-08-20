Meta:

Narrative:
As the DYP system,
system should screen the CoC based on the configuration (Comprehensive screening- most recent data and added with CoC changed data).

Scenario: Verifying that the system is screening the mentioned parameters
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${firstName}    |
When click to provider data with text '${firstName}' on IU portal
When implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '3' seconds
When click tab with name 'Screening' on provider data page
When implicit wait '5' seconds
Then Validating all the parameters should be displayed on Provider Data Page:
|screening  parameters|
|NPI invalid type/deactivated|
|NPI enumeration timing|
|FEIN invalid|
|Name mismatch|
|License/Certificate # invalid.|
|License/Certificate expired/invalid type.|
|License issuer/location mismatch|
|CLIA # invalid/expired|
|DEA|
|Record found in Death checks (DMF & other sources)|
|Record found in list of Excluded Individuals/Entities (OIG LEIE)|
|Record found as excluded System for Award Management (SAM)|
|Record found in DEX- Adverse Action Report|
|Record found in DEX- Medicare Exclusions|
|Historical exclusion record found (OIG LEIE, SAM, DEX)|
|PECOS Ownership mismatch|
|Address mismatch|
|Invalid Practice Location|
|Medicare Enrollment Condition of Participation|
|Negative Balance Flag|

Scenario: Verifying that the system is updating latest Screening score under screening tab in Internal user portal
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${firstName}    |
When click to provider data with text '${firstName}' on IU portal
When implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '3' seconds
When click tab with name 'Screening' on provider data page
When implicit wait '5' seconds
Then screening risk score text should be displayed
When implicit wait '5' seconds

Scenario: Verify that the system is allowing the user to view the screening proof document
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${firstName}    |
When click to provider data with text '${firstName}' on IU portal
When implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '3' seconds
When click tab with name 'Screening' on provider data page
When implicit wait '5' seconds
Then screening risk score text should be displayed
Then verify the 'View Screening Proof Document' is displaying
Then click on the 'View Screening Proof Document' in the screening page
When implicit wait '5' seconds

Scenario: Verify that the system is allowing the user to download the screening proof document
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${firstName}    |
When click to provider data with text '${firstName}' on IU portal
When implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '3' seconds
When click tab with name 'Screening' on provider data page
When implicit wait '5' seconds
Then verify the 'Download Screening Proof Document' is displaying
Then click on the 'Download Screening Proof Document' in the screening page
When implicit wait '5' seconds

Scenario: Verifying that the system is updating latest Screening score under screening tab in Provider portal
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - ${email} and password - Aa123321!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
And close informational pop-up
When click on Screening tab on header
When implicit wait '3' seconds
Then screening risk score text should be displayed
Then verify the 'View Screening Proof Document' is displaying
Then click on the 'View Screening Proof Document' in the screening page
Then verify the 'Download Screening Proof Document' is displaying
Then click on the 'Download Screening Proof Document' in the screening page