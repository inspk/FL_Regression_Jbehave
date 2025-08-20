Meta:
@sanity
Narrative:
Login as Provider And Verifying All the Tabs

Scenario:Login as Provider And Verifying All the Tabs
Meta:
Given take firstname, lastname and email credentials for type 'IndividualProvider1' and 'Created' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
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
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
When click on Screening tab on header
Then page with url 'screening' should be opened
When implicit wait '5' seconds
Then check 'View Screening Proof Document' is present
When implicit wait '5' seconds
Then check 'Download Screening Proof Document' is present
When implicit wait '5' seconds
When click on Affiliations tab on header
Then page with url 'affiliations' should be opened
When implicit wait '5' seconds
When click on search in affiliation coc
When implicit wait '5' seconds
When select checkbox 'Show only Ended Affiliations' in the Affiliation Page
When implicit wait '5' seconds
When click on Reconsideration tab on header
Then page with url 'appeals-list' should be opened
When implicit wait '5' seconds
Then click on reconsideration type to search with 'Enrollment'  in reconsideration tab
When implicit wait '15' seconds
Then check results after search
When click on CoC tab on header
Then page with url 'coc-list' should be opened
When implicit wait '5' seconds
Then check 'Add Change of Circumstance' is present in COC tab
When implicit wait '5' seconds
When click on Provider Data tab on header
Then page with url 'provider-data' should be opened
When implicit wait '10' seconds
Then check 'Details' section is displaying in provider data
Then check 'Enrollment Span' section is displaying in provider data
Then check 'Service Location' section is displaying in provider data
Then check 'Timeline' section is displaying in provider data
Then check 'Enrollments' section is displaying in provider data
Then check 'Affiliations' section is displaying in provider data

When click on Site visits tab on header
Then page with url 'site-visits' should be opened
When implicit wait '5' seconds
Then click on site visit FAQ to verify 'State may conduct site visits at individual and group practices' text
When implicit wait '5' seconds

When click on Help center tab on header
When implicit wait '15' seconds
Then user should redirected to tha page having the 'helpcenter-iuat.dyp.cloud/helpcenter/'
When implicit wait '5' seconds
Then click on General category in  help center
Then page with url 'section/general/' should be opened
When implicit wait '5' seconds
Then click on Will I be charged an application fee? in General category
When implicit wait '5' seconds
Then page with url 'knowledgebase/are-there-any-application-fees/' should be opened
Then validate 'You may be charged an application fee if you do not participate in Medicare' text is displayed
When implicit wait '5' seconds
Then click on 'Home' to navigate back
When implicit wait '5' seconds
Then click on Enrollment category in  help center
Then page with url 'section/enrollment/' should be opened
When implicit wait '5' seconds
Then click on What information will I need to provide when I enroll? in Enrollment category
When implicit wait '5' seconds
Then page with url 'knowledgebase/what-information-is-it-required-to-provide-during-enrollment-application/' should be opened
Then validate 'You will need to provide the following information during the enrollment process:' text is displayed
When implicit wait '5' seconds
Then click on 'Home' to navigate back
Then click on Affiliations category in  help center
Then page with url 'section/affiliations/' should be opened
When implicit wait '5' seconds
Then click on What is an Affiliation? in Affiliations category
When implicit wait '5' seconds
Then page with url 'knowledgebase/what-is-an-affiliation/' should be opened
Then validate 'An billing affiliation is an association of a provider with a group of providers.' text is displayed
When implicit wait '5' seconds
Then click on 'Home' to navigate back
When implicit wait '5' seconds
Then click on Revalidation category in  help center
Then page with url 'section/revalidation/' should be opened
When implicit wait '5' seconds
Then click on Who is required to revalidate? in Revalidation category
When implicit wait '5' seconds
Then page with url 'knowledgebase/which-providers-are-considered-to-be-revalidated/' should be opened
Then validate 'All Medicaid providers in an Active status must revalidate every five (5) years.' text is displayed
When implicit wait '5' seconds
Then click on 'Home' to navigate back