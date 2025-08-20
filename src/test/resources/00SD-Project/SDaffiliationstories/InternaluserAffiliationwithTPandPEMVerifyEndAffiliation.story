Meta:
Narrative:
As the DYP Internal user,
I can add affiliation with TP and PEM
with only the affiliation type and effective dates


Scenario:Verify that the system is not showing service location in affiliations result for individual to TP
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When save current date to variable 'date'
And save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${lastName}      |
When click to provider data with text '${firstName}' on IU portal
When click tab with name 'Enrollment Information' on provider data page
When move to new 'Affiliation' section
When implicit wait '5' seconds
When click Add Affiliation button in affiliation section
When set type search value 'TP' in affiliation section
When click search by npi in affiliation section
When click add button in affiliation section
When select affliation type 'Individual to TP'
When fill the effective start '${date}' and effective end '${enddate}' to enrollment end affiliation type page
When add transaction type '837D(837 Dental)' transaction value 'Retrieve'
And implicit wait '5' seconds
When click add button in affiliation pop-up
When verify system should not display service locations under affiliations tab
And implicit wait '10' seconds
When log out from IU portal

Scenario:Verify that the system is not showing service location in affiliations result for individual to PEM
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When save current date to variable 'date'
And save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${lastName}      |
When click to provider data with text '${firstName}' on IU portal
When click tab with name 'Enrollment Information' on provider data page
When move to new 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
When set type search value 'PEM' in affiliation section
When click search by npi in affiliation section
When click add button in affiliation section
When select affliation type 'Individual to PEM'
When fill the effective start '${date}' and effective end '${enddate}' to enrollment end affiliation type page
And implicit wait '5' seconds
When click add button in affiliation pop-up
When verify system should not display service locations under affiliations tab
And implicit wait '10' seconds

Scenario:Verify that the system is showing the mentioned content in Bulk add affiliations pop-up
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
Given user navigated to landing page
When save current date to variable 'date'
And save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${lastName}      |
When click to provider data with text '${firstName}' on IU portal
When click tab with name 'Enrollment Information' on provider data page
When move to new 'Affiliation' section
And implicit wait '5' seconds
When click Add Affiliation button in affiliation section
When click search by npi in affiliation section
When select all affiliations in affiliation section
When click Bulk Add Affiliations in affiliation section
When select affliation type 'Individual to PEM'
When fill the effective start '${date}' and effective end '${enddate}' to enrollment end affiliation type page
And implicit wait '5' seconds
When click add button in affiliation pop-up
When verify system should not display service locations under affiliations tab
And implicit wait '10' seconds