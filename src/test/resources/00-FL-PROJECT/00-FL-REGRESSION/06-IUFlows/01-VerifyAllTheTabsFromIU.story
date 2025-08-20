Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal



Scenario:Verifing the tabs and titles in IU
Given user navigated to landing page
And save value 'Mediplus' to variable 'planLegalName'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
And click on Providers tab on header
When page with url '/providers-list' should be opened
And click on Enrollment tab on header
When page with url '/requests' should be opened
And click on CoC tab on header
When page with url '/coc-list' should be opened
And click on Reconsideration tab on header
When page with url '/appeal-list' should be opened
And click on Audit tab on header
When page with url '/audit' should be opened
And click on Payments tab on header
When page with url '/payments' should be opened
And click on Claims tab on header
When page with url '/claims' should be opened
And click on 1099 tab on header
When page with url '/1099-list' should be opened
And click on Reports tab on header
When page with url '/reports' should be opened
And click on Site visits tab on header
When page with url '/site-visit' should be opened
And click on Voting tab on header
When page with url '/voting' should be opened
And click on Help center tab on header
When page with url '/helpcenter' should be opened
And click on Documents tab on header
When page with url '/csdn-redirect' should be opened


