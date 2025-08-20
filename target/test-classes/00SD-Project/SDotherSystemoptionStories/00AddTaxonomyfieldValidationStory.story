Meta:
@systemoptions
Narrative:
As the DYP IU,
I can configure for the taxonomy ID and description in single field and
description will be non-mandatory,
so that SD can add same taxonomy ID with different description

Scenario: Adding Taxonomy Without Taxonomy and Save button should be Disabled
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
|taxonomyDescription|speciality   |riskLevel   |requireType  |fingerPrintVerification|
|${taxonomyDes}     |${speciality}|${riskLevel}|Requires Fees|No                     |
When implicit wait '10' seconds
When save button should be disabled
When implicit wait '5' seconds
Examples:testdata/FacilityTaxonomiesWithRequiresFees.table

Scenario: Adding Taxonomy Without Description and Save button should be Enabled
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
|taxonomy   |speciality   |riskLevel   |requireType  |fingerPrintVerification|
|${taxonomy}|${speciality}|${riskLevel}|Requires Fees|No                     |
When implicit wait '10' seconds
When save button should be enabled
When implicit wait '5' seconds
Examples:testdata/FacilityTaxonomiesWithRequiresFees.table