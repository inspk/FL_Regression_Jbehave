Meta:
@systemoptions
Narrative:
1.Login as InternalUser
2.Navigate to System Options
3.Click on the Approvals tab
4.Select the Enrollment types for Provider Enrollment Manager
5.Set 1 Approver and 2 Reviewers in Enrollment
6.Set 1 Approver and 2 Reviewers in COC
7.Set 1 Approver and 2 Reviewers in Appeal
8.Set 1 Approver and 2 Reviewers in Revalidation

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
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
And turn on NEW configuration in System Options
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
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '0' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
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
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
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
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When verify 'COC Screening' configuration is off in coc approval page
When enable 'COC Screening' configuration in coc approval page
When implicit wait '3' seconds
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
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
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
When verify that 'Reviewer' with 'Frank Walker' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Lewis Wood' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When verify that 'Approver' with 'Leonard Peterson' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
And click on save changes button in System Options
