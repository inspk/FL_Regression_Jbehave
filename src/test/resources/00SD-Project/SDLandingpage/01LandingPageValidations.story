Meta:
@sdsanity
Narrative:
1.Verifying SD logo in the landing page
2.Verifying State Home page in Landing page
3.Validating the fields in State Home page after clicking on the State Home page link
4.Verifying Disclaimer in Landing page
5.Validating the fields in Disclaimer after clicking on the Disclaimer link
6.Verifying Accessibility in Landing page
7.Validating the fields in Accessibility after clicking on the Accessibility link
8.Verifying Privacy page in Landing page
9.Validating the fields in Privacy after clicking on the Privacy link
10.Verifying HIPAA in Landing page
11.Validating the fields in HIPAA after clicking on the HIPAA link
12.Verifying Contact Us in Landing page
13.Verifying FAQ question and Answer

Scenario: Verifying SD logo and Verifying and Validating fields in State Home page , Disclaimer , Accessibility , Privacy , HIPAA  and Contact Us for un-registered user

Given user navigated to landing page
Then validate logo 'SD-Logo' is displayed
Then validate first privacy link in landing page for 'State Home page' field
Then page with url 'sd.gov/cs' should be opened
When user navigated to landing page
Then validate second privacy link in landing page for 'Disclaimer' field
Then page with url 'sd.gov/disclaim.aspx' should be opened
When user navigated to landing page
Then validate third privacy link in landing page for 'Accessibility' field
Then page with url 'sd.gov/accpolicy.aspx' should be opened
When user navigated to landing page
Then validate fourth privacy link in landing page for 'Privacy' field
Then page with url 'sd.gov/privacy.aspx' should be opened
When user navigated to landing page
Then validate fifth privacy link in landing page for 'HIPAA' field
Then page with url 'sd.gov/keyresources/hipaa/' should be opened
When user navigated to landing page
Then validate sixth privacy link in landing page for 'Contact Us' field

Scenario: Verifying SD logo and Verifying and Validating fields in State Home page , Disclaimer , Accessibility , Privacy , HIPAA  and Contact Us for registered user

Given generate firstname, lastname and email credentials for '<index>'
And save value '<phoneno>' to variable 'phoneno'
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
And fill Phone with value '${phoneno}' on registration page
When click on create account link in the registartion page
When login to user gmail
Then go to gmail to inbox page
When implicit wait '2' seconds
When search for message by email - ${email}
When open new 'Registration in ProviderPortal' email
When implicit wait '2' seconds
Then click on new user link from the gmail
When implicit wait '2' seconds
Then navigate Back to Login page
When implicit wait '2' seconds
And refresh page
When implicit wait '2' seconds
When new user logs to Provider Enrollment portal with username - ${email} and password - Aa123321!
When click on new 'Agree' button in the Portal page
Then validate first privacy link in landing page for 'State Home page' field
Then page with url 'sd.gov/cs' should be opened
When user navigated to landing page
Then validate second privacy link in landing page for 'Disclaimer' field
Then page with url 'sd.gov/disclaim.aspx' should be opened
When user navigated to landing page
Then validate third privacy link in landing page for 'Accessibility' field
Then page with url 'sd.gov/accpolicy.aspx' should be opened
When user navigated to landing page
Then validate fourth privacy link in landing page for 'Privacy' field
Then page with url 'sd.gov/privacy.aspx' should be opened
When user navigated to landing page
Then validate fifth privacy link in landing page for 'HIPAA' field
Then page with url 'sd.gov/keyresources/hipaa/' should be opened
When user navigated to landing page
Then validate sixth privacy link in landing page for 'Contact Us' field
Examples:testdata/Individual.table

Scenario: Verifying Key Resources and Validating fields in Key Resources links

When user navigated to landing page
Then validate 'South Dakota Medicaid Home' link1 is displayed
When click on SD medicaid home page
Then page with url 'dss.sd.gov/medicaid/default.aspx' should be opened
Then validating fields in SD medicaid home page
When user navigated to landing page
Then validate 'SD Medicaid Provider Enrollment Home' link2 is displayed
When click on SD medicaid Provider Enrollment & Maintenance home page
Then page with url 'dss.sd.gov/medicaid/providers/enrollment/enrollment.aspx' should be opened
Then validating fields in SD medicaid Provider Enrollment & Maintenance home page
When user navigated to landing page
Then validate 'Provider Fee Schedules' link3 is displayed
When click on Provider Fee Schedules page
Then page with url 'dss.sd.gov/medicaid/default.aspx' should be opened
Then validating fields in Provider Fee Schedules page
When user navigated to landing page
Then validate 'Provider Billing Manuals' link4 is displayed
When click on Provider Billing Manuals page
Then page with url 'dss.sd.gov/medicaid/providers/billingmanuals/' should be opened
Then validating fields in Provider Billing Manuals page
!-- When user navigated to landing page
!-- Then validate 'Medicaid Online Portal (Look-up for remits, recipient eligibility, and claim entry)' link5 is displayed
!-- When click on Medicaid Online Portal page
!-- Then page with url 'dssapps.appssd.sd.gov/ocp/Account/Login?ReturnUrl=%2focp' should be opened
!-- Then validating fields in Medicaid Online Portal page
When user navigated to landing page
Then validate 'ListServ sign-up' link6 is displayed
When click on ListServ SignUp page
Then page with url 'dss.sd.gov/medicaid/contact/ListServ.aspx' should be opened
Then validating fields in ListServ SignUp page
When user navigated to landing page
Then validate 'SD Provider Communication' link7 is displayed
When click on SD Provider Communication page
Then page with url 'dss.sd.gov/medicaid/providers/communication.aspx' should be opened
Then validating fields in SD Provider Communication page
When user navigated to landing page
Then validate 'SD Administrative Rules' link8 is displayed
When click on SD Administrative Rule page
Then page with url 'sdlegislature.gov/Rules/Administrative/67:16' should be opened
When implicit wait '5' seconds
Then validating fields in SD Administrative Rule page
When implicit wait '5' seconds
When user navigated to landing page
Then validate 'SD Codified Laws' link9 is displayed
When click on SD Codified Laws page
Then page with url 'sdlegislature.gov/Statutes' should be opened
Then validating fields in SD Codified Laws page

Scenario: Verifying FAQ Questions and Validating FAQ Answers

When user navigated to landing page
When implicit wait '2' seconds
When in FAQ 'What is the Provider Enrollment & Credentialing System (PECS)?' Question1 is displayed
Then validating Answer1 'The Provider Enrollment & Credentialing System (PECS)' should be Present
When in FAQ 'Who should enroll?' Question2 is displayed
Then validating Answer2 'Any eligible entity or individual with an NPI' should be Present
When in FAQ 'How do I know if a provider is eligible to enroll?' Question3 is displayed
Then validating Answer3 'Refer to the Provider Enrollment Eligibility Chart' should be Present
When in FAQ 'Do I need to enroll attending, ordering, referring, or prescribing providers?' Question4 is displayed
Then validating Answer4 'No, NPIs for individuals who will only be listed on a claim for services' should be Present
When in FAQ 'How do I start using the Provider Enrollment & Credentialing System (PECS)?' Question5 is displayed
Then validating Answer5 'To start using PECS, you must be registered.' should be Present




