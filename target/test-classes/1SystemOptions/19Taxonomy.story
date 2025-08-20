Meta:
@systemoptions
Narrative:
As an Admin I can modify the Screening scores
and I can set the default configaration

Scenario: Adding Taxonomy For Require Fees
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |requireType  |fingerPrintVerification|
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Requires Fees|No                     |
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/TaxonomiesWithRequiresFees.table

Scenario: Adding Taxonomy Without Require Fees
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|No                     |
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/TaxonomiesWithoutRequiresFees.table

Scenario: Adding Taxonomy For Finger Print
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|requireType  |
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Yes                    |Requires Fees|
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/TaxonomiesWithFingerPrint.table

Scenario: Adding Taxonomy For Require Fees For Facility
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |requireType  |fingerPrintVerification|
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Requires Fees|No                     |
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/FacilityTaxonomiesWithRequiresFees.table

Scenario: Adding Taxonomy Without Require Fees For Facility
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|No                     |
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/FacilityTaxonomiesWithoutRequiresFees.table

Scenario: Adding Taxonomy For Finger Print For Facility
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|requireType  |
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Yes                    |Requires Fees|
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/FacilityTaxonomiesWithFingerPrint.table

Scenario: Adding Taxonomy For Require Fees For ORP
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |requireType  |fingerPrintVerification|
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Requires Fees|No                     |
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/OrpTaxonomiesWithRequiresFees.table

Scenario: Adding Taxonomy For Finger Print For ORP
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|requireType  |
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Yes                    |Requires Fees|
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/OrpTaxonomiesWithFingerPrint.table

Scenario: Adding Taxonomy For Finger Print For Pharmacy
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|requireType  |
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Yes                    |Requires Fees|
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/PharmacyTaxonomiesWithFingerPrint.table

Scenario: Adding Taxonomy For Site Visit
Meta:
Given save value '<taxonomy>' to variable 'taxonomy'
And save value '<taxonomyDes>' to variable 'taxonomyDes'
And save value '<speciality>' to variable 'speciality'
And save value '<riskLevel>' to variable 'riskLevel'
When user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
When implicit wait '5' seconds
When navigate to 'System Options' page from user pop-up
Then click on 'Externalization' links in system options
When implicit wait '10' seconds
When click on add taxonomy button in the exteronalization
When set Taxonomy info:
|taxonomy   |taxonomyDescription|speciality   |riskLevel   |fingerPrintVerification|requireType  |
|${taxonomy}|${taxonomyDes}     |${speciality}|${riskLevel}|Yes                    |Requires Fees|
When implicit wait '10' seconds
When save taxonomy from the exteronalization
When implicit wait '20' seconds
Examples:testdata/TaxonomyForSiteVisit.table