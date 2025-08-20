Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Verify that System will send an email to the provider that your enrollment request has been approved
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'FutureApproved' and use in session
And save current date to variable 'date'
When save current date plus 1 one day to variable end data 'expDate'
When login to user gmail
Then go to gmail to inbox page
When implicit wait '2' seconds
When search for message by email - ${email}
When implicit wait '2' seconds
When open 'Enrollment request Future Approved' email
When implicit wait '2' seconds
Then email with text 'Your Enrollment Request will be Approved on ${expDate}' is displayed

Scenario:Verify that System will send an notification to the provider that your enrollment request has been approved
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'FutureApproved' and use in session
And save current date to variable 'date'
When save current date plus 1 one day to variable end data 'expDate'
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And close informational pop-up
When navigate to Message Center
When open message 'future approved' message center
Then verify the '${expDate}' is displaying in the message