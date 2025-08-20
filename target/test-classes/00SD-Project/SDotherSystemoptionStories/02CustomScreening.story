Meta:

Narrative:
As the DYP IU,
I can configure for the parameters to screen as per the need from SD


Scenario: Verifying that the system is screening the mentioned parameters
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${firstName}    |
When click to provider data with text '${firstName}' on IU portal
When implicit wait '3' seconds
When click tab with name 'Screening' on provider data page
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


Scenario: configure for the Individual parameters to screen Auto Deny
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When implicit wait '3' seconds
Then click on 'Screening Issues Ranking' in the Screening page
When implicit wait '2' seconds
When select custom screening  thresholds option
When implicit wait '2' seconds
When expand Screening 'Individual Parameters' provider name from the Screening Page
When click Auto Deny in Screening page:
|Auto Deny Switches|
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
When close Screening 'Individual Parameters' provider name from the Screening Page
And click on save changes button in Screening page

Scenario: configure for the Individual parameters to screen Manual Review
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When implicit wait '3' seconds
Then click on 'Screening Issues Ranking' in the Screening page
When implicit wait '2' seconds
When select custom screening  thresholds option
When implicit wait '2' seconds
When expand Screening 'Individual Parameters' provider name from the Screening Page
When click Manual Review in Screening page:
|Manual Review Switches|
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
When close Screening 'Individual Parameters' provider name from the Screening Page
And click on save changes button in Screening page

Scenario: verify the view history and download as an excel button
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '3' seconds
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
When implicit wait '3' seconds
Then click on 'Screening Issues Ranking' in the Screening page
When implicit wait '2' seconds
When verify Download Excel button present for 'Screening Issues Ranking' in Screening page
When verify View History button present for 'Screening Issues Ranking' in Screening page
When verify Effective Start Date present for 'Screening Issues Ranking' in Screening page
