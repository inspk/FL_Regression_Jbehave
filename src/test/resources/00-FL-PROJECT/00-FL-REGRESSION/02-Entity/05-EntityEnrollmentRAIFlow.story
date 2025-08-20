Meta:
Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Request Additional Information
Meta:
Given take firstname, lastname and email credentials for type 'Group2' and 'Submitted' and use in session
Given user navigated to landing page
And save value 'Medplus Community Service' to variable 'providerLegalBusinessName'
And get random npi from file 'SdNPI'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '25' seconds
When click on 'Change status' button from the enrollment details page
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
And refresh page
When implicit wait '15' seconds
When click on Enrollment tab on header
Then search with tracking num in Enrollment tab
When implicit wait '5' seconds
When click to provider data with text '${providerLegalBusinessName}' on IU portal
And implicit wait '25' seconds
When click on 'Change status' button from the enrollment details page
When set enrollment request from document review status to - 'Requested Additional Information'
When implicit wait '5' seconds
And select provider reason 'Enrollment Missing Information' and 'requesting information' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
And refresh page
When implicit wait '15' seconds
When log out from IU portal
When implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on continue button from the provider
When implicit wait '30' seconds
When move to 'Provider Identifiers' section
And implicit wait '5' seconds
And To fill the Provider Identification Number:
|npi      |
|${npi}   |
When implicit wait '5' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Additional Documents (optional)' document text_file.txt
When upload the Enrollment document text_file.txt
And implicit wait '5' seconds
When move to new 'Non-Institutional Provider Agreement' section
And implicit wait '15' seconds
When click on sign button in the provider agreement section
And implicit wait '5' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
When submit enrollment application
And implicit wait '15' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '10' seconds
When click on Proceed To Sign button
And implicit wait '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '30' seconds
When click navigate to dashboard link after sign
When implicit wait '5' seconds
