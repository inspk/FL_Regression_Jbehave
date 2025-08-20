Meta:
@regression
Narrative:
1--->1.Login as InternalUser
     2.Navigate to System Options
     3.Click on the Autoassign tab
     4.Create the rule for Individual Document Review
2--->1.Login as InternalUser
     2.Navigate to System Options
     3.Click on the Autoassign tab
     4.Create the rule for Group Document Review


Scenario:Creating the AutoAssign Rule for Document Review for Individual
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
Then click on 'Rules' links in system options
Then page with url '/system/rules' should be opened
When click on 'Auto Assign' in rules
When click on create rule button
When create an rule with an name '${ruleName}'
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
When fill the effective from'${date}' and effective end '${expDate}' to create the rule
When select the parameter 'Select Application Type ' and '${selectapplicationtype}' in the rule
When select the parameter 'Parameter' and '${condition1}' in the rule
When select the parameter 'Enrollment type value' and '${enrollmenttypevalue}' in the rule
When click on add condition link to select the parameters
When select the second parameter 'Parameter' and '${condition2}' in the rule
When select the document review parameter 'Select-' and '${specialtytypevalue}' in the rule
When implicit wait '3' seconds
When select the if 'ALL' condition in the rule
When select the parameter 'Assign To' and 'User' in the rule
When implicit wait '3' seconds
When select the parameter 'Value' and 'Richard Copeland' in the rule
When cilck on 'Save' button in the rule
Then click on '←Exit Auto Assign' exit links and navigate back to system option page
Examples:testdata/RuleForIndividualDocumentReview.table

Scenario:Creating the AutoAssign Rule for Document Review for Group
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
Then click on 'Rules' links in system options
Then page with url '/system/rules' should be opened
When click on 'Auto Assign' in rules
When click on create rule button
When create an rule with an name '${ruleName}'
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
When fill the effective from'${date}' and effective end '${expDate}' to create the rule
When select the parameter 'Select Application Type ' and '${selectapplicationtype}' in the rule
When select the parameter 'Parameter' and '${condition1}' in the rule
When select the parameter 'Enrollment type value' and '${enrollmenttypevalue}' in the rule
When click on add condition link to select the parameters
When select the second parameter 'Parameter' and '${condition2}' in the rule
When select the document review parameter 'Select-' and '${specialtytypevalue}' in the rule
When implicit wait '3' seconds
When select the if 'ALL' condition in the rule
When select the parameter 'Assign To' and 'User' in the rule
When implicit wait '3' seconds
When select the parameter 'Value' and 'Richard Copeland' in the rule
When cilck on 'Save' button in the rule
Then click on '←Exit Auto Assign' exit links and navigate back to system option page
Examples:testdata/RuleForGroupDocumentReview.table
