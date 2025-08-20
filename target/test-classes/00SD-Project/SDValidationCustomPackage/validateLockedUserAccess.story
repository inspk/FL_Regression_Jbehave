Meta:

Narrative:
As the DYP system,
system should not allow the locked user
to access forget password for the locked period

Scenario: scenario description
Given generate firstname, lastname and email credentials for '<index>'
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
And fill Phone with value '3534534534' on registration page
When click on create account link in the registartion page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '5' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '5' seconds
Then click on new user link from the gmail
When implicit wait '5' seconds
Then navigate Back to Login page
When implicit wait '5' seconds
And refresh page
When implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321
And implicit wait '2' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321
And implicit wait '2' seconds
Then click on the Ok button in the password policy popup page
When implicit wait '2' seconds
When click Forgot password link
And implicit wait '5' seconds
When fill Email with value '${email}' on registration page
When click on Reset Password button
Then should show that user locked popup with 'User is locked, please try after 15 minutes.'
When implicit wait '5' seconds