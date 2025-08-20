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
When implicit wait '5' seconds
Then click on 'Notification Engine' links in system options
When implicit wait '5' seconds
Then verify Notification Engine details:
|Info type                               |Message center|Email|
|Enrollments                             |True          |True |
|Revalidation Request                    |True          |True |
|Re Enrollment                           |True          |True |
|Change of Circumstance                  |True          |True |
|Reconsideration                         |True          |True |
|Site visit                              |False         |False|
|Termination                             |True          |True |
|Request Additional Information Reminders|True          |True |
|Revalidation Reminders                  |True          |True |
|Licensure Expiration Reminders          |True          |True |
|Suspension                              |True          |True |
|Termination Request                     |True          |True |
|Re Activation                           |True          |True |
|Data change                             |True          |True |
When implicit wait '5' seconds
When click on 'Edit Button' in the notification engine page
When implicit wait '5' seconds
When click on the save button in the notification engine page
When implicit wait '5' seconds

