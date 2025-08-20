Meta:

Narrative:
As the DYP IU,
I can update the user profile information
in the order of general information, contact information and security information
and mobile and fax number are optional.

Scenario: scenario description
Given user navigated to landing page
When new user logs to Internal User portal with username - internal.user.dyp+cd@gmail.com and password - Internaluser1!
And implicit wait '2' seconds
When click on new 'Agree' button in the Portal page
And implicit wait '2' seconds
When click on GENERAL INFORMATION tab in Update Profile Popup
When To fill the update your profile:
|displayName|
|Cindy Duran|
When To fill the update your profile:
|timeZone|language|
|Alaska  |English |
And implicit wait '2' seconds
When click on CONTACT INFORMATION tab in Update Profile Popup
When To fill the update your profile:
|company|jobTitle           |department|
|hhs    |Provider Supervisor|hhs       |
And implicit wait '2' seconds
When click on SYSTEM INFORMATION tab in Update Profile Popup
And implicit wait '5' seconds
When click update in Update Profile Popup
