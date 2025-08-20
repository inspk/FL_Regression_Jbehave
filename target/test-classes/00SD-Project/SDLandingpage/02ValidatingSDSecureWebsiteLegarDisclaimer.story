Meta:
@sdsanity
Narrative:
1.Verifying U.S. Government and State of South Dakota in internal user portal
2.Scenario: Verifying  U.S. Government and State of South Dakota for registered user

Scenario: Verifying U.S. Government and State of South Dakota in internal user portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
Then validation message 'This system contains U.S. Government and State of South Dakota confidential information' should be displayed in agree page
When implicit wait '2' seconds

Scenario: Verifying  U.S. Government and State of South Dakota for registered user
Given generate firstname, lastname and email credentials for '<index>'
And save value '<phoneno>' to variable 'phoneno'
When user navigated to landing page
When click create account link in the landing page
And wait for screening process execution during '3' seconds
When fill Email with value '${email}' on registration page
And fill Password with value 'Aa123321!' on registration page
When click on continue button in the registartion page
And fill Organization Name field with value 'HHSTECHGROUP' on registration page
And fill Organization description with value 'HHSOrg' on registration page
When click on continue button in the registartion page
And fill First name  with value '${firstName}' on registration page
And fill Last name with value '${lastName}' on registration page
And fill Phone with value '${phoneno}' on registration page
When click on create account link in the registartion page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '2' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '2' seconds
Then click on new user link from the gmail
When implicit wait '2' seconds
Then navigate Back to Login page
When implicit wait '2' seconds
And refresh page
When implicit wait '2' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '2' seconds
Then validation message 'This system contains U.S. Government and State of South Dakota confidential information' should be displayed in agree page
When implicit wait '5' seconds
Examples:testdata/Individual.table