Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal



Scenario: Approvals Reviewers Configuration in Enrollment,COC,Appeal and Revalidation for Individual Providers
Meta:
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
When click on View button for request 'Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When implicit wait '3' seconds
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Revalidation'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Reconsideration'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '3' seconds
When turn on Assignee configuration in System Options
When turn on Coc Screening configuration in System Options
And turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
Then click Required site visit signature from Internal user checkbox
Then click Required site visit signature from Provider checkbox
When click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Re Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
And turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '3' seconds


Scenario: Approvals Reviewers Configuration in Enrollment,COC,Appeal and Revalidation for Group Providers
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Group Providers Approval configuration for 'Group Providers' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Revalidation'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Reconsideration'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '3' seconds
When turn on Assignee configuration in System Options
When turn on Coc Screening configuration in System Options
And turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Re Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of reviewers '1' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When turn on Assignee configuration in System Options
And turn on Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '3' seconds


Scenario: Approvals Reviewers Configuration in Enrollment,COC,Appeal and Revalidation for Provider Enrollment Manager
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Revalidation'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Reconsideration'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
When turn on Coc Screening configuration in System Options
And turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
And turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Re Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
And turn on Auto Approve configuration in System Options
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn off Assignee configuration in System Options
When turn off PEM Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds


Scenario: Approvals Reviewers Configuration in Enrollment,COC,Appeal and Revalidation for Trading Partners
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Trading Partner Provider Enrollment Application Approval configuration for 'Trading Partners' Enrollment type Page
When implicit wait '5' seconds
When click on View button for request 'Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Revalidation'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Reconsideration'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
When turn on Coc Screening configuration in System Options
And turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Site Visit'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When click on save changes button in System Options
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '5' seconds
When turn on Assignee configuration in System Options
Then set auto approve slider
When turn off Auto Approve configuration in System Options
When implicit wait '5' seconds
When click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When click on View button for request 'Re Enrollment'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
And turn on Auto Approve configuration in System Options
When remove approver 'Provider supervisor' in System Options
When implicit wait '3' seconds
And set number of approvers '0' in System Options
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When turn off TP Auto Approve configuration in System Options
When turn off Assignee configuration in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
