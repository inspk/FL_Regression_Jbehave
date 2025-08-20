Meta:
@systemoptions
Narrative:
As an Admin I can modify the affiliation for all enrollment


Scenario: Modify Affiliation configuration for Individual Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'Individual to Facility' switchs in Affiliation page
Then Enable the 'Individual to ORP' switchs in Affiliation page
Then Enable the 'Individual to Pharmacy' switchs in Affiliation page
Then Enable the 'Individual to PEM' switchs in Affiliation page
Then Enable the 'Individual to TP' switchs in Affiliation page
Then Enable the 'Individual to Group' switchs in Affiliation page
Then Enable the 'Individual to Individual' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page


Scenario: Modify Affiliation configuration for Group Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'Group to Facility' switchs in Affiliation page
Then Enable the 'Group to ORP' switchs in Affiliation page
Then Enable the 'Group to Pharmacy' switchs in Affiliation page
Then Enable the 'Group to PEM' switchs in Affiliation page
Then Enable the 'Group to TP' switchs in Affiliation page
Then Enable the 'Group to Group' switchs in Affiliation page
Then Enable the 'Group to Individual' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page


Scenario: Modify Affiliation configuration for Facility Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Facility Provider Enrollment Application Approval configuration for 'Facility Provider Enrollment Application' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'Facility to Facility' switchs in Affiliation page
Then Enable the 'Facility to ORP' switchs in Affiliation page
Then Enable the 'Facility to Pharmacy' switchs in Affiliation page
Then Enable the 'Facility to PEM' switchs in Affiliation page
Then Enable the 'Facility to TP' switchs in Affiliation page
Then Enable the 'Facility to Individual' switchs in Affiliation page
Then Enable the 'Facility to Group' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page


Scenario: Modify Affiliation configuration for Pharmacy Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Pharmacy Providers Approval configuration for 'Pharmacy' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'Pharmacy to Facility' switchs in Affiliation page
Then Enable the 'Pharmacy to ORP' switchs in Affiliation page
Then Enable the 'Pharmacy to Pharmacy' switchs in Affiliation page
Then Enable the 'Pharmacy to PEM' switchs in Affiliation page
Then Enable the 'Pharmacy to TP' switchs in Affiliation page
Then Enable the 'Pharmacy to Individual' switchs in Affiliation page
Then Enable the 'Pharmacy to Group' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page


Scenario: Modify Affiliation configuration for PEM Enrollment
Meta:

When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '5' seconds
When verify that the Effective Start present in Affiliation page
When verify that the Effective End present in Affiliation page
When verify Download Excel button present in Affiliation page
When verify View History present in Affiliation page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'PEM to Facility' switchs in Affiliation page
Then Enable the 'PEM to ORP' switchs in Affiliation page
Then Enable the 'PEM to Pharmacy' switchs in Affiliation page
Then Enable the 'PEM to PEM' switchs in Affiliation page
Then Enable the 'PEM to TP' switchs in Affiliation page
Then Enable the 'PEM to Individual' switchs in Affiliation page
Then Enable the 'PEM to Group' switchs in Affiliation page
When implicit wait '5' seconds
Then Enable the 'Auto affiliation with Individual provider' switch in Affiliation page
Then click on the Save button in the Affiliation page


Scenario: Modify Affiliation configuration for ORP Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Ordering/Referring/Prescribing Provider Approval configuration for 'Ordering/Referring/Prescribing Provider' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'ORP to Facility' switchs in Affiliation page
Then Enable the 'ORP to ORP' switchs in Affiliation page
Then Enable the 'ORP to Pharmacy' switchs in Affiliation page
Then Enable the 'ORP to PEM' switchs in Affiliation page
Then Enable the 'ORP to TP' switchs in Affiliation page
Then Enable the 'ORP to Individual' switchs in Affiliation page
Then Enable the 'ORP to Group' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page



Scenario: Modify Affiliation configuration for TP Enrollment
Meta:
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '3' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
When implicit wait '10' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partners' Enrollment type Page
When implicit wait '5' seconds
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'TP to Facility' switchs in Affiliation page
Then Enable the 'TP to ORP' switchs in Affiliation page
Then Enable the 'TP to Pharmacy' switchs in Affiliation page
Then Enable the 'TP to PEM' switchs in Affiliation page
Then Enable the 'TP to TP' switchs in Affiliation page
Then Enable the 'TP to Individual' switchs in Affiliation page
Then Enable the 'TP to Group' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page