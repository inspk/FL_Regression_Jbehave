Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verifying the links in Landing page and Maps
Given user navigated to landing page
When implicit wait '5' seconds
Then validate logo 'Provider Portal Logo' is displayed
Then verify 'Info for Providers' is displayed in landing page
Then verify 'Provider Search' is displayed in landing page
Then verify 'Create Account' is displayed in landing page
Then validate first privacy link in landing page for 'Privacy Policy' field
Then validate second privacy link in landing page for 'Terms & Conditions' field
Then click on 'Provider Search' in landing page
When implicit wait '5' seconds
Then verify the maps under Provider Search
When implicit wait '5' seconds
Then validate first privacy link in landing page for 'Privacy Policy' field
Then validate second privacy link in landing page for 'Terms & Conditions' field



Scenario:Verifying the Registration process and Enrollment types
Meta:
Given generate firstname, lastname, middlename and email credentials for '<index>'
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
When implicit wait '5' seconds
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
When implicit wait '15' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
Then validation message 'This system contains U.S. Government and State of Florida information. By accessing and using this computer system you are consenting to system monitoring for law enforcement, auditing, and other purposes. Unauthorized use of, or access to, this computer system may subject your to state and federal. criminal prosecution and penalties, as well as civil penalties. Unauthorized use of the system is prohibited.' should be displayed in agree page
When implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
Then print all the enrollment types displayed on the dashboard
When implicit wait '5' seconds
Examples:testdata/Individual.table