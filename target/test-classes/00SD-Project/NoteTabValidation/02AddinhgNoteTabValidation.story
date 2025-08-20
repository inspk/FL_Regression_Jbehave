Meta:

Narrative:
As the DYP IU,
I can add the notes under the notes tab along with document upload in enrollment, CoC and site visit, appeal modules.

Scenario: scenario description
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When click on Enrollment tab on header
And implicit wait '2' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
And implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '5' seconds
When click Add Note button on Notes section
When implicit wait '3' seconds
When set note subject - 'Sent email for additional information'
When implicit wait '3' seconds
When select note text from template - 'Sent email for additional information'
When implicit wait '3' seconds
When upload file text_file.txt in add note popup
When implicit wait '10' seconds
When click Add Note button on Add Note pop-up
When implicit wait '10' seconds
When search for note by criteria - 'Sent email for additional information'
When implicit wait '5' seconds
When download file text_file.txt in notes tab
When implicit wait '5' seconds

Scenario: scenario description
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When click on CoC tab on header
And implicit wait '2' seconds
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
And implicit wait '5' seconds
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '5' seconds
When click Add Note button on Notes section
When implicit wait '3' seconds
When set note subject - 'Sent email for additional information'
When implicit wait '3' seconds
When select note text from template - 'Sent email for additional information'
When implicit wait '3' seconds
When upload file text_file.txt in add note popup
When implicit wait '10' seconds
When click Add Note button on Add Note pop-up
When implicit wait '10' seconds
When search for note by criteria - 'Sent email for additional information'
When implicit wait '5' seconds
When download file text_file.txt in notes tab
When implicit wait '5' seconds

Scenario: scenario description
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When click on Site visits tab on header
And implicit wait '2' seconds
And search for enrollment data on IU portal by next parameters:
|sitevisitProviderNameAndId|
|${firstName} ${lastName}  |
And implicit wait '5' seconds
When select 'View' from the site visit list
And implicit wait '5' seconds
When click tab with name 'Notes' on provider data page
When implicit wait '5' seconds
When click Add Note button on Notes section
When implicit wait '3' seconds
When set note subject - 'Sent email for additional information'
When implicit wait '3' seconds
When select note text from template - 'Sent email for additional information'
When implicit wait '3' seconds
When upload file text_file.txt in add note popup
When implicit wait '10' seconds
When click Add Note button on Add Note pop-up
When implicit wait '10' seconds
When search for note by criteria - 'Sent email for additional information'
When implicit wait '5' seconds
When download file text_file.txt in notes tab
When implicit wait '5' seconds