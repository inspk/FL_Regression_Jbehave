Meta:
@systemoptions
Narrative:
1.Login as User
2.Set 1 Approver and 2 Reviewers in Enrollment
3.Set 1 Approver and 2 Reviewers in COC
4.Set 1 Approver and 2 Reviewers in Appeal
5.Set 1 Approver and 2 Reviewers in Revalidation

Scenario: Approvals Reviewers Configuration in Enrollment,COC,Appeal and Revalidation
Meta:
Given user navigated to landing page
When user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
When click on View button for request 'Enrollment'
When click on edit button in System Options
And turn on reviewers configuration in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Frank Walker' in System Options
And click on Add button in popup in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Lewis Wood' in System Options
And click on Add button in popup in System Options
And set number of reviewers '2' in System Options
And add approver in System Options
And select 'User' in type dropdown in System Options
And select user 'Leonard Peterson' in System Options
And click on Add button in popup in System Options
And set number of approvers '1' in System Options
And click on save changes button in System Options
When click 'Approvals' tab on left panel
When click on View button for request 'Change of Circumstance'
When click on edit button in System Options
And turn on reviewers configuration in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Frank Walker' in System Options
And click on Add button in popup in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Lewis Wood' in System Options
And click on Add button in popup in System Options
And set number of reviewers '2' in System Options
And add approver in System Options
And select 'User' in type dropdown in System Options
And select user 'Leonard Peterson' in System Options
And click on Add button in popup in System Options
And set number of approvers '1' in System Options
And click on save changes button in System Options
When click 'Approvals' tab on left panel
When click on View button for request 'Appeal'
When click on edit button in System Options
And turn on reviewers configuration in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Frank Walker' in System Options
And click on Add button in popup in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Lewis Wood' in System Options
And click on Add button in popup in System Options
And set number of reviewers '2' in System Options
And add approver in System Options
And select 'User' in type dropdown in System Options
And select user 'Leonard Peterson' in System Options
And click on Add button in popup in System Options
And set number of approvers '1' in System Options
And click on save changes button in System Options
When click 'Approvals' tab on left panel
When click on View button for request 'Revalidation'
When click on edit button in System Options
And turn on reviewers configuration in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Frank Walker' in System Options
And click on Add button in popup in System Options
And add reviewer in System Options
And select 'User' in type dropdown in System Options
And select user 'Lewis Wood' in System Options
And click on Add button in popup in System Options
And set number of reviewers '2' in System Options
And add approver in System Options
And select 'User' in type dropdown in System Options
And select user 'Leonard Peterson' in System Options
And click on Add button in popup in System Options
And set number of approvers '1' in System Options
And click on save changes button in System Options

