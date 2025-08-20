Meta:
@systemoptions
Narrative:
As an Admin I can modify the affiliation for all enrollment


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
When verify that the Auto affiliation with Individual provider button is off by default in Affiliation page
When click on edit button in System Options
When implicit wait '5' seconds
Then Disable the 'Auto affiliation with Individual provider' switch in Affiliation page
Then click on the Save button in the Affiliation page
When click on edit button in System Options
When implicit wait '5' seconds
Then Enable the 'Auto affiliation with Individual provider' switch in Affiliation page
Then click on the Save button in the Affiliation page


Scenario: Auto affiliation with Individual provider in PEM Enrollment reenrollment revalidation COC and Data Change.
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
When verify that the Auto affiliation with Individual provider button is on by default in Affiliation page
When click on edit button in System Options
When implicit wait '5' seconds
Then Disable the 'Auto affiliation with Individual provider' switch in Affiliation page
Then click on the Save button in the Affiliation page
When click on edit button in System Options
