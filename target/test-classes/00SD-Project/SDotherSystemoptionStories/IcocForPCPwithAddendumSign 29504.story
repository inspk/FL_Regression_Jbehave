Meta:

Narrative:
As a DYP system,
the system should not allow the Internal User to add program participation/Taxonomy
that requires addendum signature while submitting an i-CoC by internal users

Scenario: I-coc - pcp adendum
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on CoC tab on header
When implicit wait '10' seconds
When click on 'Add I Coc'
!-- When set provider name '${firstName}' in i-Coc popup
When set enrollment type 'Individual' in i-Coc popup
When click search in I-Coc popup
When select provider in i-Coc popup
When click next in i-Coc popup
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation       |
|Primary Care Provider (PCP)|
And implicit wait '5' seconds
Then verify iCoC Popup Message 'Cannot select this Program Participation/Taxonomy as it requires Addendum signature. Please contact the provider to submit a CoC request from their end.'



Scenario: I-coc - mental health adendum
Meta:
Given take firstname, lastname and email credentials for type 'Individual1' and 'Approved' and use in session
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on CoC tab on header
When implicit wait '10' seconds
When click on 'Add I Coc'
When set provider name '${firstName}' in i-Coc popup
When click search in I-Coc popup
When select provider in i-Coc popup
When click next in i-Coc popup
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation |speciality   |
|Medicaid/CHIP        |Mental Health|
And implicit wait '5' seconds
Then verify iCoC Popup Message 'Cannot select this Program Participation/Taxonomy as it requires Addendum signature. Please contact the provider to submit a CoC request from their end.'




Scenario: I-coc - Transportation Attestation
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on CoC tab on header
When implicit wait '10' seconds
When click on 'Add I Coc'
When set enrollment type 'Group' in i-Coc popup
When click search in I-Coc popup
When select provider in i-Coc popup
When click next in i-Coc popup
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation|speciality    |
|Medicaid/CHIP       |Transportation|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                             |
|343900000X - Community Transportation|
And implicit wait '5' seconds
Then verify iCoC Popup Message 'Cannot select this Program Participation/Taxonomy as it requires Addendum signature. Please contact the provider to submit a CoC request from their end.'

Scenario: I-coc - Psych Attestation
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on CoC tab on header
When implicit wait '10' seconds
When click on 'Add I Coc'
When set enrollment type 'Group' in i-Coc popup
When click search in I-Coc popup
When select provider in i-Coc popup
When click next in i-Coc popup
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation |speciality                                    |
|Medicaid/CHIP        |Mental Health & Substance Treatment Facilities|
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                                               |
|323P00000X - Psychiatric Residential Treatment Facility|
And implicit wait '5' seconds
Then verify iCoC Popup Message 'Cannot select this Program Participation/Taxonomy as it requires Addendum signature. Please contact the provider to submit a CoC request from their end.'


Scenario: I-coc - School District
Meta:
Given take firstname, lastname and email credentials for type 'Group1' and 'Approved' and use in session
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
When click on new 'Agree' button in the Portal page
And implicit wait '5' seconds
When click on CoC tab on header
When implicit wait '10' seconds
When click on 'Add I Coc'
When set enrollment type 'Group' in i-Coc popup
When click search in I-Coc popup
When select provider in i-Coc popup
When click next in i-Coc popup
When select Program Participation / Taxonomy / License and Service location type in coc pop-up
And implicit wait '5' seconds
When click create button in select coc type pop-up
And implicit wait '10' seconds
When move to 'Program Participation / Taxonomy / License / Certificate Information' section
And implicit wait '5' seconds
When click on Add Program Participation in Program Participation section
And implicit wait '5' seconds
And To fill the Program Participation section info:
|programParticipation |speciality|
|Medicaid/CHIP        |School    |
And implicit wait '5' seconds
When click on 'Add Taxonomy' in Program participation section
And To fill the Program Participation section info:
|taxonomy                                             |
|251300000X - Local Education Agency (School District)|
When implicit wait '3' seconds
Then verify iCoC Popup Message 'Cannot select this Program Participation/Taxonomy as it requires Addendum signature. Please contact the provider to submit a CoC request from their end.'
