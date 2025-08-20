Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: As a Approved Provider verify details in provider module
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'ApprovedReviewCOC' and use in session
When save current date plus 1 years to variable 'expDate'
When user navigated to landing page
When new user logs to Internal User portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on Provider Data tab on header
When implicit wait '10' seconds
Then verify the Provider data details 'Next Revalidation Date' is 'expDate'
Then validating 'Secondary Service Location' Tab in SD Provider Module
When implicit wait '5' seconds


Scenario: As a Internaluser verify details in provider module

Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
And refresh page
And implicit wait '5' seconds
And search for provider data on IU portal by next parameters:
|providerNameAndId        |
|${firstName} ${lastName} |
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '10' seconds
Then verify the Provider Module details 'Next Revalidation Date' is 'expDate'
Then validating 'Summary' Tab in SD Provider Module
When click 'Service Location' Tab in SD Provider Module
Then validating 'Location Type' Tab in Service location header