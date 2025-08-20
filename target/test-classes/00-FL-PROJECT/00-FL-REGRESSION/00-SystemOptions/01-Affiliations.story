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
Then Enable affiliation 'Individual to PEM' switchs in Affiliation page
Then Enable affiliation sign 'Individual to PEM' switchs in Affiliation page
Then Enable affiliation 'Individual to TP' switchs in Affiliation page
Then Enable affiliation sign 'Individual to TP' switchs in Affiliation page
Then Enable affiliation 'Individual to Entity' switchs in Affiliation page
Then Enable affiliation sign 'Individual to Entity' switchs in Affiliation page
Then Enable affiliation 'Individual to MCO' switchs in Affiliation page
Then Enable affiliation sign 'Individual to MCO' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page
When implicit wait '5' seconds


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
Then Enable affiliation 'Entity to PEM' switchs in Affiliation page
Then Enable affiliation sign 'Entity to PEM' switchs in Affiliation page
Then Enable affiliation 'Entity to TP' switchs in Affiliation page
Then Enable affiliation sign 'Entity to TP' switchs in Affiliation page
Then Enable affiliation 'Entity to MCO' switchs in Affiliation page
Then Enable affiliation sign 'Entity to MCO' switchs in Affiliation page
Then Enable affiliation 'Entity to Individual' switchs in Affiliation page
Then Enable affiliation sign 'Entity to Individual' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page
When implicit wait '5' seconds


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
Then Enable affiliation 'PEM to TP' switchs in Affiliation page
Then Enable affiliation sign 'PEM to TP' switchs in Affiliation page
Then Enable affiliation 'PEM to Individual' switchs in Affiliation page
Then Enable affiliation sign 'PEM to Individual' switchs in Affiliation page
Then Enable affiliation 'PEM to Entity' switchs in Affiliation page
Then Enable affiliation sign 'PEM to Entity' switchs in Affiliation page
When implicit wait '5' seconds
Then Enable the 'Auto affiliation with Individual provider' switch in Affiliation page
Then click on the Save button in the Affiliation page
When implicit wait '5' seconds


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
Then Enable affiliation 'TP to PEM' switchs in Affiliation page
Then Enable affiliation sign 'TP to PEM' switchs in Affiliation page
Then Enable affiliation 'TP to Individual' switchs in Affiliation page
Then Enable affiliation sign 'TP to Individual' switchs in Affiliation page
Then Enable affiliation 'TP to Entity' switchs in Affiliation page
Then Enable affiliation sign 'TP to Entity' switchs in Affiliation page
When implicit wait '5' seconds
Then click on the Save button in the Affiliation page
When implicit wait '5' seconds


