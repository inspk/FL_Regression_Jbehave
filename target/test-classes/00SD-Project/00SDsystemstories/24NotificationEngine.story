Meta:

Narrative:
As the DYP internal user,
I can configure for sending E-mails to registered E-mail ID or
application contact E-mail ID or
both under notification engine in system options

Scenario: Modify the notification engine
Meta:
Given user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Notification Engine' links in system options
When implicit wait '5' seconds
When click on 'Edit Button' in the notification engine page
When set the effective start date '${date}' in notification engine page
When Enable trigger all the E-mail communications to application Contact E-mail ID button
When implicit wait '5' seconds
When click on the save button in the notification engine page
When implicit wait '5' seconds
When click on 'Edit Button' in the notification engine page
When set the effective start date '${date}' in notification engine page
When Disable trigger all the E-mail communications to registered E-mail ID button
When Disable trigger all the E-mail communications to application Contact E-mail ID button
When implicit wait '5' seconds
When verify the popup message 'At least one E-mail trigger switch should be ON.' on notification engine page
When Enable trigger all the E-mail communications to registered E-mail ID button
When implicit wait '5' seconds
When click on the save button in the notification engine page
When implicit wait '5' seconds