Meta:
@regression
Narrative:
1.As an Admin I can create the rule
2.Verify the Effective dates

Scenario:Creating the AutoAssign Rule
Meta:
Given user navigated to landing page
And save value '<ruleName>' to variable 'ruleName'
And save value '<selectapplicationtype>' to variable 'selectapplicationtype'
And save value '<condition1>' to variable 'condition1'
And save value '<enrollmenttypevalue>' to variable 'enrollmenttypevalue'
And save value '<condition2>' to variable 'condition2'
And save value '<specialtytypevalue>' to variable 'specialtytypevalue'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And navigate to 'System Options' page from user pop-up
When implicit wait '5' seconds
Then click on 'Rules' links in system options
When implicit wait '5' seconds
Then page with url '/system/rules' should be opened
When click on 'Auto Assign' in rules
When implicit wait '5' seconds
When click on create rule button
When implicit wait '5' seconds
When create an rule with an name '${ruleName}'
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
When fill the effective from'${date}' and effective end '${expDate}' to create the rule
When select the parameter 'Select Application Type ' and '${selectapplicationtype}' in the rule
When select the parameter 'Parameter' and '${condition1}' in the rule
When select the parameter 'Enrollment type value' and '${enrollmenttypevalue}' in the rule
When implicit wait '3' seconds
When click on add condition link to select the parameters
When select the second parameter 'Parameter' and '${condition2}' in the rule
When select the parameter 'Specialty type value' and '${specialtytypevalue}' in the rule
When implicit wait '3' seconds
When select the parameter 'Assign To' and 'User' in the rule
When implicit wait '5' seconds
When select the parameter 'Value' and 'Cindy Duran' in the rule
When cilck on 'Save' button in the rule
When search by rule '${ruleName}' from the rule list
When implicit wait '7' seconds
Then verifying the Auto Assignee rules:
|EFFECTIVE FROM  |EFFECTIVE END      |
|${date}         |${expDate}         |
Examples:testdata/RuleCreation.table

Scenario:Creating, Edit and Delete Auto Assign Rule
Meta:
Given user navigated to landing page
Given unique rule name value for variable 'ruleName' is generated
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And navigate to 'System Options' page from user pop-up
Then click on 'Rules' links in system options
Then page with url '/system/rules' should be opened
When click on 'Auto Assign' in rules
When implicit wait '5' seconds
When click on create rule button
When implicit wait '5' seconds
When create an rule with an name '${ruleName}'
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
And save current date plus 2 years to variable 'expDate1'
When fill the effective from'${date}' and effective end '${expDate}' to create the rule
When select the parameter 'Select Application Type ' and 'Authorization' in the rule
When select the parameter 'Parameter' and 'Enrollment Type' in the rule
When select the parameter 'Enrollment type value' and 'Individual' in the rule
When select the parameter 'Assign To' and 'User' in the rule
When select the parameter 'Value' and 'Cindy Duran' in the rule
When implicit wait '5' seconds
When cilck on 'Save' button in the rule
When implicit wait '5' seconds
When search by rule '${ruleName}' from the rule list
When implicit wait '5' seconds
When Select 'Edit' from the rule list
When implicit wait '5' seconds
When fill the effective from'${date}' and effective end '${expDate1}' to create the rule
When select the parameter 'Assign To' and 'Role' in the rule
When implicit wait '5' seconds
When select the parameter 'Value' and 'Provider Analyst' in the rule
When cilck on 'Save' button in the rule
When implicit wait '5' seconds
When log out from IU portal
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And navigate to 'System Options' page from user pop-up
Then click on 'Rules' links in system options
When implicit wait '5' seconds
When click on 'Auto Assign' in rules
When implicit wait '5' seconds
When search by rule '${ruleName}' from the rule list
When implicit wait '5' seconds
When Select 'Remove' from the rule list
When implicit wait '5' seconds
When click on ok button to remove the record from the rule list
When implicit wait '5' seconds

