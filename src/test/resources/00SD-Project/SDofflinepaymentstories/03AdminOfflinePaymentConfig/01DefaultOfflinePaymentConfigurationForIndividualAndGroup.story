Meta:
@systemoptions
Narrative:
As an Admin I can set the Offline payment fees for IE,GE

Scenario:Set the Offline payment fees
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
When implicit wait '5' seconds
Then click on the payment and fees 'Collect Fees For Individual Provider Enrollment' edit button
When Disable 'Individual Provider Enrollment Fees' online Payment
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
When implicit wait '5' seconds
Then click on the payment and fees 'Collect Fees For Group Provider Enrollment' edit button
When Disable 'Group Provider Enrollment Fees' online Payment
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
When implicit wait '5' seconds
Then click on the payment and fees 'Collect Fees For Provider Enrollment Manager Enrollment' edit button
When Disable 'Provider Enrollment Manager Enrollment Fees' online Payment
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
When implicit wait '5' seconds
Then click on the payment and fees 'Collect Fees For Trading Partner Enrollment' edit button
When Disable 'Trading Partner Enrollment Fees' online Payment
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
When implicit wait '5' seconds




