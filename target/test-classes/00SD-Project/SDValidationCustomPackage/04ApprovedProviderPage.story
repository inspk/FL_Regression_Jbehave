Meta:
@sanity
Narrative:
Login as Provider And Verifying All the Tabs


Scenario:Login as Provider And Dashboard Fields
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And close informational pop-up
And implicit wait '5' seconds
When click on Dashboard tab on header
Then page with url 'dashboard' should be opened
When implicit wait '5' seconds
Then Validating all the fields should be displayed on dashboard page:
|fields             |
|Status             |
|Provider ID        |
|Revalidation Date  |

Scenario:Login as Provider And Dashboard Fields
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And close informational pop-up
And implicit wait '5' seconds
When click on Provider Data tab on header
Then page with url 'provider-data' should be opened
When implicit wait '5' seconds
Then Validating all the fields should be displayed on provider data page:
|FIELDS             |
|PROVIDER ID        |
|NPI                |
|TYPE               |
|NEXT REVALIDATION DATE  |
|STATUS             |

Scenario:Login as Provider And Verifying All the Tabs
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - ${email} and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '5' seconds
When click on Dashboard tab on header
Then page with url 'dashboard' should be opened
When implicit wait '5' seconds
When click on Screening tab on header
Then page with url 'screening' should be opened
When implicit wait '5' seconds
When click on Affiliations tab on header
Then page with url 'affiliations' should be opened
When implicit wait '5' seconds
When click on Reconsideration tab on header
Then page with url 'appeals-list' should be opened
When implicit wait '5' seconds
When click on CoC tab on header
Then page with url 'coc-list' should be opened
When implicit wait '5' seconds
When click on Provider Data tab on header
Then page with url 'provider-data' should be opened
When implicit wait '5' seconds
When click on Site visits tab on header
Then page with url 'site visits' should be opened
When implicit wait '5' seconds
When click on Help center tab on header
Then page with url 'help center' should be opened
When implicit wait '5' seconds


