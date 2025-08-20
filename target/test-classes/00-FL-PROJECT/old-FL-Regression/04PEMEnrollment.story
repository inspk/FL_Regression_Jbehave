Meta:
@regression
Narrative:
1.I can Fill PEM Enrollment application
2.Sign performed with Hello Sign
3.Wait until status become Screening
4.Upload the Screening

Scenario:Delete all existing gmails
Meta:
When login to user gmail
When implicit wait '5' seconds
Then go to gmail to inbox page
When implicit wait '10' seconds
When Delete all existing Gmails
When implicit wait '5' seconds

Scenario:Provider Enrollment Manager  Flow
Meta:
Given generate firstname, lastname and email credentials for '<index>'
And save value '<provider>' to variable 'provider'
And save value '<gender>' to variable 'gender'
And save value '<dob>' to variable 'dob'
And save value '<ssn>' to variable 'ssn'
And save value '<mailingAddressLine1>' to variable 'mailingAddressLine1'
And save value '<mailingAddressZip>' to variable 'mailingAddressZip'
And save current date to variable 'date'
When user navigated to landing page
When click create account link in the landing page
And wait for screening process execution during '3' seconds
When fill Email with value '${email}' on registration page
And fill Password with value 'Aa123321!' on registration page
When click on continue button in the registartion page
And fill Organization Name field with value 'HHSTECHGROUP' on registration page
And fill Organization description with value 'HHSOrg' on registration page
When click on continue button in the registartion page
And fill First name  with value '${firstName}' on registration page
And fill Last name with value '${lastName}' on registration page
And fill Phone with value '3534534534' on registration page
When click on create account link in the registartion page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '5' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '5' seconds
Then click on new user link from the gmail
When implicit wait '5' seconds
Then navigate Back to Login page
When implicit wait '5' seconds
And refresh page
When implicit wait '5' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
And user click on Provider Enrollment Manager (PEM) type
And To fill the identifying information section for Enrollment:
|firstName   |lastName   |gender   |email    |phoneNumber|alternateEmail|
|${firstName}|${lastName}|${gender}|${email} |3534534534 |${email}      |
When implicit wait '2' seconds
When move to 'Address Details' section
When implicit wait '2' seconds
And To fill the Concact Person Details:
|attentionLine   |
|Landmark        |
When implicit wait '2' seconds
And To fill the Address Details:
|mailingAddressLine1    |
|${mailingAddressLine1} |
And implicit wait '5' seconds
When move to 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '40' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '30' seconds
And move to new 'Payment' section
And implicit wait '30' seconds
When perform personal payment
And implicit wait '5' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |
|${firstName}|${lastName}|
Then Agree Term and conditions to Sign
When submit enrollment application
And implicit wait '20' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '5' seconds
When click on Proceed To Sign button
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
And implicit wait '40' seconds
When log out from PE portal
And implicit wait '5' seconds
Then rewrite stage of credentials to 'Submitted' for 'ProviderEnrollmentManager1'
Examples:testdata/regressiondata/PEMEnrollment.table


Scenario:Request Additional Information
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Submitted' and use in session
And get random npi from file 'WyNPI'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request from document review status to - 'Requested Additional Information'
When implicit wait '5' seconds
And select provider reason 'Enrollment Missing Information' and 'requesting information' Provider under screening
When implicit wait '5' seconds
When click on apply button in under screening page
When implicit wait '5' seconds
When log out from IU portal
When implicit wait '5' seconds
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on continue button from the provider
When implicit wait '10' seconds
When move to 'Address Details' section
When implicit wait '2' seconds
And To fill the Address Details:
|mailingAddressLine1             |
|240 MINNESOTA ST RAPID CITY, SD |
And implicit wait '10' seconds
When move to new 'Provider Agreement' section
And implicit wait '25' seconds
When click on sign button in the provider agreement section
And implicit wait '50' seconds
And sign1 provider application for user '${firstName} ${lastName}'
And implicit wait '60' seconds
When move to new 'Summary' section
And implicit wait '5' seconds
And To fill the Concact Person Details:
|firstName   |lastName   |
|${firstName}|${lastName}|
When submit enrollment application
And implicit wait '30' seconds
When click on navigate to dashboard for Proceed To Sign
And implicit wait '10' seconds
When click on Proceed To Sign button
And implicit wait '2' seconds
When wait for screening process execution during '10' seconds
And sign provider application for user '${firstName} ${lastName}'
When implicit wait '60' seconds
When log out from PE portal
When implicit wait '5' seconds
And refresh page
When implicit wait '5' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request New status to - 'Document Review'
When implicit wait '5' seconds
When log out from IU portal
When implicit wait '5' seconds
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
When implicit wait '5' seconds
When set enrollment request document status to - 'Document Review Approved'
When implicit wait '5' seconds
When log out from IU portal
Then rewrite stage of credentials to 'Created' for 'ProviderEnrollmentManager1'

Scenario:Verify Enrollment approvals based on System Options Configuration:1 approver,2 reviewers to Deny PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Created' and use in session
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+frank.walker@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+lewis.wood@gmail.com and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Deny' button on decision panel
When select deny reason 'Enrollment Rules Violation' in Approval popup
When click on Deny button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - wy.internalusers+leonard.peterson@gmail.com and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When click on Enrollment tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '3' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'
And implicit wait '5' seconds
Then rewrite stage of credentials to 'Denied' for 'ProviderEnrollmentManager1'

Scenario:Verify Appeal approvals based on System Options Configuration:1 approver,2 reviewers to approve Appeal PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Denied' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click Reconsideration button on enrollment section
And implicit wait '5' seconds
When fill Reconsideration application with:
|reason          |firstName|lastName|
|Documents update|Nvvpxgzl |Vsonftas|
And implicit wait '5' seconds
And wait for screening process execution during '5' seconds
And upload new Appeal document text_file.txt
And implicit wait '10' seconds
When sign Appeal application
And implicit wait '5' seconds
And submit Appeal application
And implicit wait '5' seconds
Then success message with text - Success!Your request was submitted. should be displayed
When implicit wait '5' seconds
Then rewrite stage of credentials to 'CreatedAppeal' for 'ProviderEnrollmentManager1'


Scenario:Verify Appeal approvals based on System Options Configuration:1 approver,2 reviewers to approve Appeal PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'CreatedAppeal' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And save current date to variable 'date'
And click on Reconsideration tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - provider.dyp+ed@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on Reconsideration tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Approve' button on decision panel
When select approve reason 'Positive Enrollment History' in Approval popup
When click on Approve button in Approval popup
And implicit wait '5' seconds
And refresh page
And implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on Reconsideration tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
When click on 'Change status' button from the enrollment details page
When set to the original status for appeal request status - 'Approved' and reason - 'Approved Based Documents' with status - 'Approved'
And wait for screening process execution during '5' seconds
Then rewrite stage of credentials to 'Approved' for 'ProviderEnrollmentManager1'



Scenario:Suspened and Reactivate the PEM Provider
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
And save current date to variable 'date'
And save current date 'dateformat'
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Suspended' from the provider details page
And set the provider suspended date '${date}' from the Provider suspended popup
And select provider reactivation reason 'Medicare Certification Expired' and 'suspended note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Suspend' button reactivate or terminate the provider
And implicit wait '10' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And close informational pop-up
When skip help tour if exists
Then provider status as 'SUSPENDED' is displaying
When implicit wait '5' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Reactivate' from the provider details page
And set the provider reactivate date '${date}' from the Provider Reactivate popup
And select provider reactivation reason 'Positive Enrollment History' and 'reactivation note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Reactivate' button reactivate or terminate the provider
And implicit wait '10' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
When log out from IU portal


Scenario:Terminate and Reactivate the PEM Provider
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save current date 'dateformat'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Enrollment Rules Violation' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
When log out from IU portal
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
And close informational pop-up
Then provider status as 'TERMINATED' is displaying
When implicit wait '5' seconds
When log out from IU portal
When implicit wait '5' seconds
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Reactivate' from the provider details page
And set the provider reactivate date '${date}' from the Provider Reactivate popup
And select provider reactivation reason 'Positive Enrollment History' and 'reactivation note' Provider Reactivation/Termination popup
And implicit wait '5' seconds
And click 'Reactivate' button reactivate or terminate the provider
And implicit wait '10' seconds
When log out from IU portal78
When user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
When skip help tour if exists
Then provider status as 'ACTIVE' is displaying
When implicit wait '5' seconds
When log out from IU portal

Scenario:Verify COC approvals based on System Options Configuration:1 approver to approve COC PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email}  and password - Aa123321!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
And close informational pop-up
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for pem next categories:
|categories      |
|Address Details |
And implicit wait '10' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1|
|2321 DUNN AV       |
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Upload supporting documents if needed (Optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When move to new 'Summary' section
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ApprovedReviewCOC' for 'ProviderEnrollmentManager1'


Scenario: Approve Coc by 1 approver to approve COC PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Approved' with reason - 'Approved Based On Documents'



Scenario:Verify COC approvals based on System Options Configuration:1 approver to Deny COC PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
And save current date to variable 'date'
When skip help tour if exists
And implicit wait '3' seconds
And click on CoC tab on header
When click on Change request button on Coc page
When select enrollment data type in coc pop-up
When click next button in select coc type pop-up
And create Change of Circumstance request for pem next categories:
|categories      |
|Address Details |
And implicit wait '10' seconds
When move to 'Address Details' section
And implicit wait '5' seconds
And To fill the Address Details:
|mailingAddressLine1          |
|PO BOX 86370 SIOUX FALLS, SD |
And implicit wait '10' seconds
When move to 'Upload Documents' section
When implicit wait '10' seconds
When upload new 'Upload supporting documents if needed (Optional)' document text_file.txt
And implicit wait '10' seconds
When move to new 'Summary' section
When wait for screening process execution during '5' seconds
When submit application
Then page with url 'runtime/submitted/coc' should be opened
And pop-up with title 'Success!Your request was submitted.' should be displayed after submission
When click on Go to Change of Circumstance button
When wait for screening process execution during '10' seconds
Then rewrite stage of credentials to 'ReviewDeniedCoc' for 'ProviderEnrollmentManager1'


Scenario:Deny Coc by 1 approver to approve COC PEM Enrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
And click on CoC tab on header
And search for enrollment data on IU portal by next parameters:
|providerIDorName        |
|${firstName} ${lastName}|
When click to provider data with text '${firstName}' on IU portal
And implicit wait '5' seconds
And refresh page
And implicit wait '15' seconds
When click on 'Change status' button from the enrollment details page
And set enrollment request status - 'Denied' with reason - 'Missing Document'



Scenario:Terminate the PEM Provider for reenrollment
Meta:
Given take firstname, lastname and email credentials for type 'ProviderEnrollmentManager1' and 'Approved' and use in session
Given user navigated to landing page
And save current date to variable 'date'
And save current date 'dateformat'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '5' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '15' seconds
When click on Providers tab on header
When search for provider data on IU portal by next parameters:
|providerNameAndId|
|${firstName}     |
When implicit wait '10' seconds
When click to provider data with text '${firstName}' on IU portal
When implicit wait '10' seconds
When select 'Terminate' from the provider details page
And set the provider terminate date '${date}' from the Provider Terminate popup
And select provider reactivation reason 'Enrollment Rules Violation' and 'termination note' Provider Reactivation/Termination popup
When implicit wait '5' seconds
And click 'Terminate' button reactivate or terminate the provider
When implicit wait '10' seconds
When log out from IU portal
Then rewrite stage of credentials to 'Terminated' for 'ProviderEnrollmentManager1'






