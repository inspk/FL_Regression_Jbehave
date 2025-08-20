Meta:
@regression
Narrative:


Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to Deny Group Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'TradingPartner3' and 'Created' and use in session
And save value 'Catholic Family Services' to variable 'businessName'
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName|
|${businessName} |
When click to provider data with text '${businessName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Denied' for 'TradingPartner3'