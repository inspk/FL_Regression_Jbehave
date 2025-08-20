Meta:
@systemoptions
Narrative:
As an Admin I can modify the payment fees for all enrollment

Scenario:Set the Payment and Fees configuration for Individual Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Individual Provider Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|individualPaymentFees|inStatePaymentFees|outStatePaymentFees|
|150                  |200               |300                |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page

Scenario:Set the Payment and Fees configuration for Group Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Group Provider Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|groupPaymentFees |groupinStatePaymentFees|groupoutStatePaymentFees|
|150              |200                    |300                     |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page

Scenario:Set the Payment and Fees configuration for Facility Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Facility Provider Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|facilityPaymentFees |facilityinStatePaymentFees|facilityoutStatePaymentFees|
|150                 |200                       |300                        |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page

Scenario:Set the Payment and Fees configuration for Pharmacy Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Pharmacy Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|pharmacyPaymentFees |pharmacyinStatePaymentFees|pharmacyoutStatePaymentFees|
|150                 |200                       |300                        |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page

Scenario:Set the Payment and Fees configuration for PEM Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Provider Enrollment Manager Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|pemPaymentFees |peminStatePaymentFees|pemoutStatePaymentFees|
|150            |200                  |300                   |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page

Scenario:Set the Payment and Fees configuration for ORP Enrollment
Meta:
When user navigated to landing page
And save current date to variable 'date'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then click on the payment and fees 'Collect Fees For Ordering/Referring/Prescribing Provider Enrollment' edit button
When set the effective start date '${date}' in payment fees page
When implicit wait '5' seconds
When user fill the payment fees info:
|orpPaymentFees |orpinStatePaymentFees|orpoutStatePaymentFees|
|150            |200                  |300                   |
When implicit wait '5' seconds
And click on save changes button in Payment Fees page
Then click on '←Exit Payments & Fees Configuration' exit links and navigate back to system option page
