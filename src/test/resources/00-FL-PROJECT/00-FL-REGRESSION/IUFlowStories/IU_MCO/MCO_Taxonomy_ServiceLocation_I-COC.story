Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given user navigated to landing page
And save current date to variable 'date'
When save current date plus 1 years to variable 'expDate'
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
Then validation message 'This system contains U.S. Government and State of Florida information. By accessing and using this computer system you are consenting to system monitoring for law enforcement, auditing, and other purposes. Unauthorized use of, or access to, this computer system may subject your to state and federal. criminal prosecution and penalties, as well as civil penalties. Unauthorized use of the system is prohibited.' should be displayed in agree page
When implicit wait '2' seconds
When click on 'Agree' button in the Portal page
When implicit wait '5' seconds
And click on CoC tab on header
And implicit wait '5' seconds
When click on 'Add I Coc'
When set enrollment type 'MCO' in i-Coc popup
When click search in I-Coc popup
And implicit wait '5' seconds
When select provider in i-Coc popup
When click next in i-Coc popup
And implicit wait '5' seconds
When select taxonomy data type in coc pop-up
And implicit wait '2' seconds
When click Create CoC  for group button  on categories modal window
And implicit wait '15' seconds
When move to 'Taxonomy / Specialty / Provider Type / License Certification Information' section
And implicit wait '10' seconds
When click on Add Taxonomy in Taxonomy Info section
And implicit wait '10' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|taxonomyDescription  |
|322D00000X           |
And implicit wait '10' seconds
And To fill the Taxonomy/Speciality/License Certification section info:
|effectiveStartDate|effectiveEndDate|
|${date}           |${expDate}      |
And implicit wait '10' seconds
Then save the details of Taxonomy/Speciality/License Certification section info
When implicit wait '10' seconds
When move to 'Service Location' section
When implicit wait '10' seconds
When click on Add Location in Service Location section
When implicit wait '10' seconds
And To fill the Service Location info:
|effectiveDate|locationName  |addressLine1|attentionLine|email         |phoneNumber|mailingAddress|mailingAddressContactInfo|
|${date}      |Primary clinic|100         |John         |test@gmail.com|8765487654 |Yes           |Yes                      |
When implicit wait '10' seconds
When click on Add Taxonomy/Speciality in Service Location section
When implicit wait '5' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|specialty                                           |
|FREESTANDING PSYCHIATRIC HOSPITAL FOR CHILDREN - 300|
When implicit wait '10' seconds
Then select Taxonomy in Program Participation
When implicit wait '10' seconds
Then to fill the Taxonomy/Speciality/License Certification section info in Service Location:
|locationTaxonomyEffectiveStartDate|locationTaxonomyEffectiveEndDate|
|${date}                           |${expDate}                      |
When implicit wait '20' seconds
Then save Taxonomy in Taxonomy/Speciality
When implicit wait '30' seconds
When click on 'Add Region' in Service Location Section
And To fill the Service Location info:
|region  |startDate |
|Region F|${date}   |
Then click on Save Button
When implicit wait '20' seconds
When move to new 'Summary' section
When submit application
When implicit wait '20' seconds
When click on Go to Change of Circumstance button
When implicit wait '20' seconds
When log out from portal