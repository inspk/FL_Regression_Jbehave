Meta:

Narrative:
As DYP system,
I can configure the signature required for site visit
from internal users and providers individually in Approvals configurations

Scenario: Enable and Disable Sitevisit sign checkbox of Individual
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Individual Providers Approval configuration for 'Individual Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page

Scenario: Enable and Disable Sitevisit sign checkbox of Group
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Group Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page

Scenario: Enable and Disable Sitevisit sign checkbox of ORP
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Ordering/Referring/Prescribing Provider Approval configuration for 'Facility Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page


Scenario: Enable and Disable Sitevisit sign checkbox of Facility
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Facility Provider Enrollment Application Approval configuration for 'Facility Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page

Scenario: Enable and Disable Sitevisit sign checkbox of Pharmacy
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Pharmacy Providers Approval configuration for 'Facility Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page

Scenario: Enable and Disable Sitevisit sign checkbox of PEM
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Facility Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page

Scenario: Enable and Disable Sitevisit sign checkbox of TP
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Facility Providers'  Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
Then click on exit Approvals link from the Approvals page
