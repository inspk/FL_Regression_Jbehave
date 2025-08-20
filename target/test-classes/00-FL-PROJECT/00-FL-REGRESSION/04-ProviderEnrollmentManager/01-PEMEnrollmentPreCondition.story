Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Approvals Reviewers Configuration in Enrollment,COC and Revalidation for PEM Providers
Meta:
Given user navigated to landing page
Given save current date to variable 'startdate'
When save current date plus 1 years to variable 'enddate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When implicit wait '5' seconds
When expand the Provider Enrollment Manager Approval configuration for 'Provider Enrollment Manager' Enrollment type Page
When implicit wait '10' seconds
When click on View button for request 'Enrollment'
When implicit wait '5' seconds
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '3' seconds
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Elsie Delgado' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When implicit wait '3' seconds
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When verify 'New' configuration is off in approval page
When enable 'New' configuration in approval page
When implicit wait '5' seconds
When verify 'Configure Clearing House Check' configuration is off in approval page
When enable 'Configure Clearing House Check' configuration in approval page
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '3' seconds
When click on View button for request 'Revalidation'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '3' seconds
And turn on reviewers configuration in System Options
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Elsie Delgado' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When implicit wait '3' seconds
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When implicit wait '5' seconds
When verify 'New' configuration is off in approval page
When enable 'New' configuration in approval page
When implicit wait '5' seconds
When verify 'Configure Clearing House Check' configuration is off in approval page
When enable 'Configure Clearing House Check' configuration in approval page
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
When implicit wait '3' seconds
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
When fill the effective start '${startdate}' and effective end '${enddate}' to enrollment type page
When implicit wait '3' seconds
And turn on reviewers configuration in System Options
When implicit wait '3' seconds
When verify that 'Reviewer' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
When verify that 'Reviewer' with 'Elsie Delgado' is not displayed System Options and add new one with role 'User'
And set number of reviewers '2' in System Options
When implicit wait '3' seconds
When verify that 'Approver' with 'Cindy Duran' is not displayed System Options and add new one with role 'User'
And set number of approvers '1' in System Options
When verify 'COC Screening' configuration is off in approval page
When enable 'COC Screening' configuration in approval page
When verify 'Configure Clearing House Check' configuration is off in approval page
When enable 'Configure Clearing House Check' configuration in approval page
When implicit wait '3' seconds
And click on save changes button in System Options
When implicit wait '5' seconds
Then click on exit Approvals link from the Approvals page
