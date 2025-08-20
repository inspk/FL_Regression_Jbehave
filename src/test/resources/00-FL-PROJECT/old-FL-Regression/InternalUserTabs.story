Meta:
@sanity
Narrative:
Login as Internal User And Verifying All the Tabs In IU

Scenario:Verifying all the tabs in IU portal
Meta:
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When click on Providers tab on header
Then page with url 'providers-list' should be opened
When search for enrollment data on IU portal by next parameters:
|enrollmentType|
|Entity        |
Then check results after search
When implicit wait '5' seconds
When click on Enrollment tab on header
Then page with url 'requests' should be opened
When search for enrollment data on IU portal by next parameters:
|status        |enrollType|
|Approved      |Entity    |
And implicit wait '5' seconds
Then check results after search
When implicit wait '5' seconds
When click on CoC tab on header
Then page with url 'coc-list' should be opened
When search for enrollment data on IU portal by next parameters:
|type             |
|EFT Information  |
Then check results after search
When click on Reconsideration tab on header
Then page with url 'appeal-list' should be opened
When search for enrollment data on IU portal by next parameters:
|status        |
|Approved      |
Then check results after search
When click on Audit tab on header
Then page with url 'audit' should be opened
When click on Payments tab on header
Then page with url 'payments' should be opened
When search for enrollment data on IU portal by next parameters:
|status |
|Paid   |
Then check results after search
When implicit wait '5' seconds
When click on Claims tab on header
Then page with url 'claims' should be opened
When search for enrollment data on IU portal by next parameters:
|status  |
|Denied  |
Then check results after search
When implicit wait '5' seconds
When click on 1099 tab on header
Then page with url '1099-list' should be opened
When click on Reports tab on header
Then page with url 'reports' should be opened
When implicit wait '5' seconds
When click on Site visits tab on header
Then page with url 'site-visit' should be opened
When search for enrollment data on IU portal by next parameters:
|type   |
|Entity |
Then check results after search
When implicit wait '5' seconds
When click on Voting tab on header
Then page with url 'voting' should be opened
Then validate 'Payer-initiated change requests to provider data are stored here. Vote to approve or deny changes' text is displayed
When implicit wait '5' seconds
When click on Help center tab on header
When implicit wait '5' seconds
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

When click on Documents tab on header
!-- When select hidden tab 'Documents'
Then page with url 'csdn-redirect' should be opened
When implicit wait '5' seconds
Then click on type to search with 'doc' in document tab



Scenario:Verifying all Systemoption tails in IU portal
Meta:
Given save current date to variable 'date'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Affiliations' links in system options
Then page with url '/system/affiliations' should be opened
Then check 'Affiliation Configuration for' text is displayed in system options
Then validate '←  Exit Affiliations' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Approvals' links in system options
Then page with url '/system/approvals-type' should be opened
Then check 'Approval configuration for' text is displayed in system options
Then validate '←Exit Approvals' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Auto Archive' links in system options
Then page with url '/system/autoarchive' should be opened
Then check 'Auto Archive' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Auto Archive' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Builder' links in system options
Then page with url '/builder/provider' should be opened
When implicit wait '2' seconds
Then check 'Individual Provider Enrollment Application' text is displayed in system options
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Custom Sections' links in system options
Then page with url 'system/custom-sections' should be opened
Then check 'Custom Sections' text is displayed in system options
Then validate '←  Exit Custom Sections' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Data Change' links in system options
Then page with url '/system/data-change-actions' should be opened
Then check 'Actions on data change' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Data Change Management' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Duplicity' links in system options
Then page with url '/system/duplicity' should be opened
Then check 'Configuration for Duplicity & Data Matching' text is displayed in system options
Then validate 'Exit Duplicity' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Enrollment Types' links in system options
Then page with url '/system/enrollment-types' should be opened
Then check 'Edit' button is displayed in system options
Then validate '←Exit Enrollment types' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
Then page with url '/system/error-message-dropdowns' should be opened
Then check 'Taxonomy' text is displayed in system options
Then validate '←Exit Externalization' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Licensure' links in system options
Then page with url '/system/licensure' should be opened
Then check 'Licensure' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Licensure' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Notification Engine' links in system options
Then page with url '/system/notification-Engine-actions' should be opened
Then check 'Notification Engine' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Notification Engine Management' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Payments & Fees' links in system options
Then page with url '/system/paymentsandfees' should be opened
Then check 'Payments and Fees Configuration' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Payments & Fees Configuration' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Reminders to Reviewers' links in system options
Then page with url '/system/reminders-to-reviewers' should be opened
Then check 'Edit' button is displayed in system options
Then validate '←Exit Reminders to Reviewers' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Request additional Information' links in system options
Then page with url '/system/requestaddionalInfo' should be opened
Then check 'Request Additional Information Reminders' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Request Additional Info' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Revalidation' links in system options
Then page with url '/system/revalidation' should be opened
Then check 'Revalidation configuration for' text is displayed in system options
Then validate '←Exit Revalidation' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Roles' links in system options
Then page with url '/system/roles' should be opened
Then check 'Role Management' text is displayed in system options
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Rules' links in system options
Then page with url '/system/rules' should be opened
Then check 'Rules' text is displayed in system options
Then validate '←Exit Rules' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Screening' links in system options
Then page with url '/system/screening' should be opened
Then check 'Monitoring Frequency' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then check 'Screening Issues Ranking' text is displayed in system options
Then validate '←Exit Screening' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Security Policy' links in system options
Then page with url '/system/passwordpolicy' should be opened
Then check 'Login Timeout' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then check 'Auto Terminate' text is displayed in system options
Then validate '←Exit Security Policy' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Site Visit' links in system options
Then page with url '/system/site-visit' should be opened
Then check 'Site Visit Schedule' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit Site Visit' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'User Deactivation' links in system options
Then page with url '/system/userdeactivation' should be opened
Then check 'User Inactivity' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit User Deactivation' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'User Profile' links in system options
Then page with url '/system/userprofile' should be opened
Then check 'User Profile Configuration' text is displayed in system options
Then check 'Edit' button is displayed in system options
Then validate '←Exit User Profile' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Users' links in system options
Then page with url '/system/users' should be opened
Then check 'User Management' text is displayed in system options
Then validate '←Exit User Management' Exit link is displayed
When implicit wait '2' seconds
When navigate to 'System Options' page from user pop-up
