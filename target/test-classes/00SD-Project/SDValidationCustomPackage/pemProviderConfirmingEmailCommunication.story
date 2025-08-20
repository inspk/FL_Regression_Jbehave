Meta:

Narrative:
    1--> As the DYP system,
         system will trigger email communications to the mentioned email ID

    2-->As the DYP system,
          system will not trigger any email communications to the system generated email ID,
          if the email ID is reassigned with actual mail ID, then system will trigger the communications

Scenario:Login as PEM Provider And Enroll provider with Email ID Verify that the system is sending communications to the mentioned email ID
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given unique value for variable 'user' is generated
Given unique value for variable 'providerfirstName' is generated
Given unique value for variable 'providerlastName' is generated
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
And close informational pop-up
When click on plus enrollment provider button
And user click on Individual Enrollment type
When implicit wait '2' seconds
When click Yes on 'Do you have the Email-ID of the provider?'
When fill provider email 'provideruser543+${user}@gmail.com' firstname '${providerfirstName}' and lastname '${providerlastName}'
And refresh page
When implicit wait '10' seconds
When log out from PE portal
When login to gmail
Then go to gmail to inbox page
When implicit wait '10' seconds
When search for message by email - provideruser543+${user}@gmail.com
When implicit wait '5' seconds
When open new 'Registration in ProviderPortal' email
Then verify receiver email is 'provideruser543+${user}@gmail.com'

Scenario:Login as PEM Provider And Enroll provider with Email ID Verify mentioned email ID if not generate Email ID then verify the system is Email communications
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given unique value for variable 'user' is generated
Given unique value for variable 'providerfirstName' is generated
Given unique value for variable 'providerfirstName1' is generated
Given unique value for variable 'providerlastName' is generated
Given unique value for variable 'providerlastName1' is generated
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
And close informational pop-up
When click on plus enrollment provider button
When skip help tour if exists
And user click on Individual Enrollment type
When implicit wait '2' seconds
When click No on 'Do you have the Email-ID of the provider?'
When fill provider firstname '${providerfirstName}' and lastname '${providerlastName}'
And refresh page
When implicit wait '10' seconds
When log out from PE portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Users' links in system options
When implicit wait '5' seconds
When search for ${providerfirstName} in site visit user
And implicit wait '3' seconds
When select 'Reassign' action for request '${providerfirstName} ${providerlastName}'
Then verifying the Reassign Role pop-up is opened
When implicit wait '5' seconds
When fill User firstname field with value '${providerfirstName1}'
When implicit wait '1' seconds
When fill User lastname field with value '${providerlastName1}'
When implicit wait '1' seconds
When fill the Email in the Reassign Role page 'provideruser543+${user}@gmail.com'
When implicit wait '1' seconds
When select provider reason 'Reassign to new user' and 'Reassign note' Provider under screening
When implicit wait '3' seconds
Then click on Reassign button in the Reassign Role page
When implicit wait '5' seconds
When log out from IU portal
When login to gmail
Then go to gmail to inbox page
When search for message by email - provideruser543+${user}@gmail.com
And implicit wait '10' seconds
When open new 'Registration in ProviderPortal' email to the Reassign Provider
When implicit wait '5' seconds
Then verify receiver email is 'provideruser543+${user}@gmail.com'

