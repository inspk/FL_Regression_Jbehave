Meta:

Narrative:
As the DYP IU,
I can see the monitoring details
along with Medicare Exclusions as per the SD need.

Scenario: Verifying monitoring parameters and columns for Individual
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
And implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Monitoring' on provider data page
And implicit wait '5' seconds
Then validate all the parameters should be displayed on monitoring tab:
|parameters|
|Licensure|
|NPPES (NPI)|
|PECOS|
|OIG/LEIE Sanctions|
|Death Master|
|SAM|
|CLIA|
|DEA|
|Adverse Action|
|Medicare Exclusions|
When implicit wait '5' seconds
Then click 'Medicare Exclusions' in monitoring tab
When implicit wait '5' seconds
Then validate all the columns should be displayed on monitoring tab:
|columns|
|NPI|
|First Name|
|Middle Name|
|Last Name|
|Verification Status|
|Rein Date|
|SSN|
|Record Type|
|Matching Criteria|
|Monitoring Flag|
When implicit wait '5' seconds

Scenario: Verifying monitoring parameters and columns for Group
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
Given save value 'VIP Community Services' to variable 'providerLegalBusinessName'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|providerNameAndId           |
|${providerLegalBusinessName}|
And implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Monitoring' on provider data page
And implicit wait '5' seconds
Then validate all the parameters should be displayed on monitoring tab:
|parameters|
|Licensure|
|NPPES (NPI)|
|PECOS|
|OIG/LEIE Sanctions|
|Death Master|
|SAM|
|CLIA|
|DEA|
|Adverse Action|
|Medicare Exclusions|
When implicit wait '5' seconds
Then click 'Medicare Exclusions' in monitoring tab
When implicit wait '5' seconds
Then validate all the columns should be displayed on monitoring tab:
|columns|
|NPI|
|First Name|
|Middle Name|
|Last Name|
|Verification Status|
|Rein Date|
|SSN|
|Record Type|
|Matching Criteria|
|Monitoring Flag|
When implicit wait '5' seconds

Scenario: Verifying monitoring parameters and columns for PEM
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
And implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Monitoring' on provider data page
And implicit wait '5' seconds
Then validate all the parameters should be displayed on monitoring tab:
|parameters|
|Licensure|
|NPPES (NPI)|
|PECOS|
|OIG/LEIE Sanctions|
|Death Master|
|SAM|
|CLIA|
|DEA|
|Adverse Action|
|Medicare Exclusions|
When implicit wait '5' seconds
Then click 'Medicare Exclusions' in monitoring tab
When implicit wait '5' seconds
Then validate all the columns should be displayed on monitoring tab:
|columns|
|NPI|
|First Name|
|Middle Name|
|Last Name|
|Verification Status|
|Rein Date|
|SSN|
|Record Type|
|Matching Criteria|
|Monitoring Flag|
When implicit wait '5' seconds

Scenario: Verifying monitoring parameters and columns for Trading partner
Given take firstname, lastname and email credentials for type 'TradingPartner1' and 'Approved' and use in session
Given save value 'AVERA AT HOME' to variable 'businessName'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And implicit wait '5' seconds
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${businessName}  |
And implicit wait '5' seconds
When click to provider data with text '${businessName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Monitoring' on provider data page
And implicit wait '5' seconds
Then validate all the parameters should be displayed on monitoring tab:
|parameters|
|Licensure|
|NPPES (NPI)|
|PECOS|
|OIG/LEIE Sanctions|
|Death Master|
|SAM|
|CLIA|
|DEA|
|Adverse Action|
|Medicare Exclusions|
When implicit wait '5' seconds
Then click 'Medicare Exclusions' in monitoring tab
When implicit wait '5' seconds
Then validate all the columns should be displayed on monitoring tab:
|columns|
|NPI|
|First Name|
|Middle Name|
|Last Name|
|Verification Status|
|Rein Date|
|SSN|
|Record Type|
|Matching Criteria|
|Monitoring Flag|
When implicit wait '5' seconds