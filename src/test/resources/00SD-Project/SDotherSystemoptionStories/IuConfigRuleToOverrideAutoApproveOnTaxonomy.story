Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:Creating the AutoAssign Rule
Meta:
Given user navigated to landing page
Given unique rule name value for variable 'ruleName' is generated
And save value '<selectapplicationtype>' to variable 'selectapplicationtype'
And save value '<condition1>' to variable 'condition1'
And save value '<parametertypevalue1>' to variable 'parametertypevalue1'
And save value '<selectactionbasic>' to variable 'selectactionbasic'
And save value '<condition2>' to variable 'condition2'
And save value '<parametertypevalue2>' to variable 'parametertypevalue2'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And navigate to 'System Options' page from user pop-up
Then click on 'Rules' links in system options
Then page with url '/system/rules' should be opened
When click on 'Edit Rules' in rules
When click on create rule button
When create an rule with an name '${ruleName}'
And save current date to variable 'date'
And save current date plus 1 years to variable 'expDate'
When fill the effective from'${date}' and effective end '${expDate}' to create the rule
When select the parameter 'Select Application Type ' and '${selectapplicationtype}' in the rule
When select the parameter 'Parameter' and '${condition1}' in the rule
When select the parameter 'Parameter Type Value' and '${parametertypevalue1}' in the rule
When implicit wait '3' seconds
When select the parameter 'Select action basic' and '${selectactionbasic}' in the rule
When select the action parameter 'Parameter' and '${condition2}' in the rule
When select the action parameter 'Parameter Type Value' and '${parametertypevalue2}' in the rule
When implicit wait '3' seconds
When cilck on 'Save' button in the rule
When implicit wait '5' seconds
Examples:
|selectapplicationtype |condition1 |parametertypevalue1                        |selectactionbasic |condition2    |parametertypevalue2    |
|Enrollment            |Taxonomy   |207RN0300X-Internal Medicine -  Nephrology |Status Update     |Auto Approval |Override Auto Approval |
|CoC                   |Taxonomy   |207RN0300X-Internal Medicine -  Nephrology |Status Update     |Auto Approval |Override Auto Approval |
