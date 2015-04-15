# What is FIL Project Management App v2?

FIL Project Management App v2 was the final product for the [Spring 2014 COEN275/COEN160 in-class design competition](http://scu.edu/engineering/frugal/gallery/2012/Student-Projects.cfm) held by the Frugal Innovation Lab at Santa Clara University. The application was custom built to assist the Frugal Innovation Lab in scaling the data management for its electic mix of projects/participants data. The application allows coordinators and volunteers from the lab to search, store, and retrieve FIL project information to/from a SQL database in an easy to use and accessible GUI platform. FIL Project Management App v2 is a desktop application written in Java using the Swing API which utilizes the following libraries: JDK 1.8 is used as the default Java library. EclipseLink JPA2.1 is used to import the JPA library used for managing the calls to the SQL database. MySQL-Connector 5.1.31 is utilized to access the SQL database within the Java application. JCalendar 1.4 present an easy-to-use GUI interface for the user to select start and end dates for a project.

![Intro1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img1_appIntro.png)
![Intro2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img2_appIntro.png)
![Intro3](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img3_appIntro.png)

## Purpose

* **Add** New FIL Projects to database!
* **Edit** Existing FIL Projects in database!
* **Search** database for FIL Projects using a diverse set of parameters!
* **View** FIL Project information and attachments!
* **Create** and **Manage** Admin/Guest Access to FIL database!

# Application Functions

## Accounts 

### Login
The user can gain access to the application through an administrative or a viewer account using the login screen.

### Forget Password
If a user forgets his/her password, the password for the user’s account can be reset by supplying the email address that is associated with the username.!

### Manage Account
The account for the current user can be managed from this page. The user’s first name, last name, email-address, phone number, and password can be changed. The username may not be edited.

### Sign Out
The current user can sign out and return to the login screen through this option.

## Project
The Project tab expands and contain links to the application pages which allow the user to create, edit, and view projects in the FIL database. It is the recommended starting point for the user to interact with the FIL database. The Project tab itself is currently a blank page.

### Project -> New Project
The New Project tab allows the user to create a new FIL project in the database. It contains 4 main tabs which includes: General Information, Participants, Multimedia, and Create Project. The General Information tab is the page where users may fill out information such as project name, description, status, category, location, start/end dates, scope, outcome, and tags. The Participants tab allow the user to select existing participants or create new ones for the new project. A list of participants that will be added to the new project can be viewed here. The Multimedia tab keeps track of media file attachments related to the new project. A list of attachments that will be added to the new project can be viewed here. The new project can be finalized and added to the database by visiting the Create Project tab and selecting the “Create Project” button.

### Project -> Edit Participant
The Edit Participant tab gives the user an opportunity to modify the personal details of an existing project participant. These details include title, first name, middle name, last name, designation, email, phone, and organization.

### Project -> Edit Projects
The Edit Projects tab contains a list of projects that are currently stored in the FIL database. The table used to display the projects can be sorted by name, description, long description, start date, end date, status, outcome, scope, and archived. Projects can be set to an active or archived state on this page. Project which are archived will not be visible in the View Project pages. It will still be available in the Edit Projects tab and Explore tab.

### Project -> Edit Projects -> General Info
The General Info tab in Edit Projects allow information for an existing project to be modified. These fields include project name, short description, general description, status, category, location, start/end date, scope, and outcome.

### Project -> Edit Projects -> Participants
The Participant tab in Edit Projects gives users an opportunity to add new or remove existing participants from a project. New participants who do not exist in the database may also be created here. The table on the page displays a list of project participants that exist in the selected project.

### Project -> Edit Projects -> Multimedia
The Multimedia tab in Edit Projects allow users to manage media file attachments related to the selected project. Media files can be added to or removed from a project. A list of project attachments will be displayed in the table for the selected project. Media files may also be viewed using its native application by selecting the “View Media” button. Currently, media files stored in the database are simply symbolic links with absolute file paths.

### Project -> View Projects
The View Projects tab display the full list of active projects in the FIL database. By clicking on a project in the display table, the user will be automatically taken to a page that displays the General Info for the selected project. Projects in the display table show the project name, description, ing description, start/end date, status, outcome, scope, and archived status of the project. These columns can be sorted by clicking on the column headers.

### Project -> View Projects -> General Info
The General Info tab displays information such as project name, short description general description, status, categories, location, start/end date, scope, and outcome for a selected project. There is a “View Printable Information” button which formats the contents of the current page into a printable form. If a user selects a project from the drop-down list on this page, the same project will also be selected in the Participants tab.

### Project -> View Projects -> Participants
The Participants tab displays the list of participants for a selected project in a table. The table contains the participant id, name, role, email address, and phone number. Each column may be sorted by clicking on the column header. If a user selects a project from the drop-down list on this page, the same project will also be selected in the General Info tab. 

By clicking on a participant in the table, the user will be taken to the View Participant Details page which contains a table that lists all of the projects that the selected participant has been involved with. This table contains the project name and a short description for each project. It can be sorted by clicking on the column headers. By clicking on a project from this list, the participant will be automatically taken to the General Info page for the selected project.

### Multimedia
The Multimedia tab displays the media attachment files for the selected project. The table on the page displays the file name, location, and type. These columns can be sorted by clicking on the column header. By selecting a file and clicking on the “View Media” button, these files may also be opened using its native application.

## Users
The Users tab expands and contain links to the application pages which allow the administrative user to add, delete, and view all users in the FIL database. The Users tab itself is currently a blank page.

### Add New User
The Add New User tab allows an administrative user to create a new administrative or viewer user. An administrative user has access to the following pages which a viewer user does not have: Project->New Project, Project->Edit Participant, Project->Edit Projects, Project->Edit Projects->General Info, Project->Edit Projects->Participants, Project->Edit Projects->Multimedia, Users, Users->Add New User, Users->View All Users. These pages allow an administrative user to create and edit project information. It also contains access for the administrative user to create and delete user accounts.

### View All Users
The View All Users tab allows an administrative user to view all the registered users in the FIL database. A user including the current user may be deleted by selecting the “Delete” button.

## Explore
The Explore tab expands and contain links to the application pages which allow the user to search for projects in the FIL database using various project related parameters. The Explore tab itself is currently a blank page.

### Search
The Search tab allows the user to search for a project using keywords that exist in the project name and/or description. Results will be returned and displayed in a table which can be sorted by clicking on the column headers. The table contains the project name, description, long description, start/end date, status, outcome, scope, and archived status. By clicking on a project in the results list, the user will be automatically taken to the General Info page for the selected project.

### Advanced Search
The Advanced Search tab allows the user to search for a project using multiple search parameters. These parameters include keywords which exist in the project name, short description, and scope. The status, categories, and dates may also be selected to further filter the search results. The returned list of projects is displayed in a table which can be sorted by clicking on the column headers. By clicking on a project in the results list, the user will be automatically taken to the General Info page for the selected project.

## Edit (Select All/Cut/Copy/Paste)
The Edit menu item in the menu bar of the application allows users to select, cut, copy, and paste text to and from the application.
	
# Detailed Walk-through

## Accounts

### Login
Start by filling out your username and password. Click the “Submit” button when you’re ready to login.

![Login](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img6_account.png)

### Forget Password
If you forget your password, click the “Forget My Password” button to access the Password Reset page. Reset the password by providing the email address which is associated with the username you provide. Supply a new password and click the “Submit” button to reset the password. Click the “Sign In” button to return back to the login page.

![ForgetPass1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img7_forgetPass.png)
![ForgetPass2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img8_forgetPass.png)

### Manage Account
Select the “Manage Account” button to change information for the current user. Click the “Update” button to update the account. The password strength indicator has not been fully implemented yet. 

![ManageAccount](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img9_manageAccount.png)

### Sign Out
Click the “Sign Out” button to logout.

![SignOut](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img10_signOut.png)

## Project
The Project tab itself shows a blank page in the current version of the application.

![Project](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img11_proj.png)

### Project -> New Project
Click the New Project tab to begin the process of creating a new project in the database. You may click “Next Step” after filling out each page or click on the General Details, Participants, Multimedia, and Create Project tabs directly.

Click the General Details tab on the page to fill out the information for the new project. The Project Name, Short Description, General Description, Status of Project, Category, and Start/End Date is required for a new project to be created successfully. Use the drop-down list to select a status for the project. The Start/End Dates can be selected by clicking on a date in the pop-up calendar. Multiple tags can be selected by holding CTRL(Windows) or COMMAND(MAC) and selecting a tag. New tags can be created by clicking on the “Add New Tags...” button and typing the name of the new tag. Click “Add” to confirm the new tag. If a new tag was mistakenly added, the “Delete Tags” button can be used to remove it. 

![NewProjectDetails1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img12_newProj.png)
![NewProjectDetails2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img13_newProj.png)
![NewProjectDetails3](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img14_newProj.png)

Click the Participants tab on the page to add participants to the new project. Add the new participant by selecting a role and then choosing a name from the drop down list. Click “Add Participant” to confirm the participant for the new project. If a participant doesn’t exist in the drop down list, click “New Participant...” to create a new participant for the database. This participant can be selected in the drop-down list for future projects. Only the first and last names and role are required for a participant. If the participant has a title, select PHD or MD from the drop-down list. Phone number may be in the following format: 555-5555, 555-555-5555, 555-555-5555 x5555. Participants that are added to the project will appear in the table. Click “Hide” after creating the new participant. If you made a mistake, a participant can be deleted by selecting a name from the table and clicking on “Delete Participant”.

![NewProjectParticipant1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img15_newProj.png)
![NewProjectParticipant2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img16_newProj.png)
![NewProjectParticipant3](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img17_newProj.png)

Click the Multimedia tab on the page to add new media to the new project. Type in the path of the file or click “Choose a file” to select the file that you would like to add. Select a file type from the drop down list. Provide a file name. Click “Add Media” to add the file to the list for the new project. Click “Remove Media” to remove the file from the list. Files that are added here are shortcuts with absolute paths to the file. In the current version of the application, files are not copied to the application folder. It also will not be accessible on a separate system from where the file is stored.

![NewProjectMult1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img18_newProj.png)
![NewProjectMult2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img19_newProj.png)
![NewProjectMult3](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img20_newProj.png)

Click the Create Project tab on the page to confirm the creation of the new project. Click the “Create Project” button to finalize the process. Participants and Multimedia are not required for a new project. If there is any information missing from the General Details page, a pop-up message will inform you which field is missing.

![CreateProject](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img21_newProj.png)

### Project -> Edit Participant
Click on the Edit Participant tab to modify the personal details of an existing project participant. Select a participant from the drop-down list to edit. First and Last name are the only fields which are required. Click “Submit Modified Details” to confirm the update.

![EditParticipant](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img22_editParticipant.png)

### Project -> Edit Projects
Click on the Edit Projects tab to active or archive existing projects from the FIL database. Projects may never be deleted from the database. If you no longer what a project available for viewing, select a project from the list and click “Archive Project”. If you want the project to be available for viewing again in the future, click “Activate Project”.

![EditProjects](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img23_editProjects.png)

### Project -> Edit Projects -> General Info
Click on the General Info tab to edit the information for an existing project. Select a project from the drop-down list. The Project Name, Short Description, General Description, Status of Project, and Start/End Date are required fields. Select a status from the drop-down list. Select a date from the pop- up calendar. Click “Edit Project Information” to confirm the update.

![EditProjGenInfo](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img24_editProjGenInfo.png)

### Project -> Edit Projects -> Participants
Click on the Participant tab in Edit Projects to modify the list of participants for an existing project. Select a project from the list to view the list of participants. Select a role and a participant from the drop-down lists and click “Add Participant” to add a new participant to the project. An existing participant may also be removed by selecting a person from the list and clicking “Delete Participant”. A new participant may also be added by clicking on “New Participant...”. First and Last Name are the only required fields. Click “Add” to add the new participate to the list. Click “Update Project” to confirm all of the changes.

![EditProjParticipant1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img25_editProjParticipant.png)
![EditProjParticipant2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img26_editProjParticipant.png)

### Project -> Edit Projects -> Multimedia
Click Multimedia tab to edit the media files for an existing project. Select a project from the drop-down list to view the existing media files. Type in the path of the file or click “Choose a file” to select the file that you would like to add. Select a file type from the drop down list. Provide a file name. Click “Add Media” to add the file to the list for the new project. Click “Remove Media” to remove the file from the list. Files that are added here are shortcuts with absolute paths to the file. In the current version of the application, files are not copied to the application folder. It also will not be accessible on a separate system from where the file is stored. Select a file and click “View Media” to open the file using its native application.

![EditProjMult1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img27_editProjMult.png)
![EditProjMult2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img28_editProjMult.png)

### Project -> View Projects
Click the View Projects tab display the full list of active projects in the FIL database. Sort the table by clicking on a column header. Click on a project in the table to view its general information. Selecting a project from this list will also automatically set the project selected for the General Info, Participants, and Multimedia in the sub-View Project tabs.

![ViewProject](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img29_viewProj.png)

### Project -> View Projects -> General Info
Click on the General Info tab to view information such as project name, short description general description, status, categories, location, start/end date, scope, and outcome for a selected project. Projects may be selected from the drop-down list. Click the “View Printable Information” button to print the information for the selected project. Changing a selected project on this page also changes the selected project on the Participants and Multimedia
pages.

![ViewProjectGenInfo](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img30_viewProjGenInfo.png)

### Project -> View Projects -> Participants
Click on the Participants tab to view the list of participants for a selected project. Select a project using the drop-down list. Filter the list by role using the drop-down list. Sort the table by clicking on the column header. Click “View Printable Information” to print the list of participants for the selected project. Changing a selected project on this page also changes the selected project on the General Info and Multimedia pages.

Click on a participant in the table to view the View Participant Details page. Sort the table by clicking on a column header. Click “Return to Project Participants” to return to the previous page. Click on a project in the table to view its general information.

![ViewProjectParticipant1](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img31_viewProjParticipant.png)
![ViewProjectParticipant2](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img32_viewProjParticipant.png)

### Multimedia
Click on the Multimedia tab to view the media attachment files for an existing project. Select a project from the drop-down list to view the existing media files. Select a file and click “View Media” to open the file using its native application. Changing a selected project on this page also changes the selected project on the Participants and General Info pages.

![Multimedia](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img33_mult.png)

## Users
The Users tab is a blank page for the current version of the application.

![Users](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img34_users.png)

### Add New User
Click the Add New User tab to create a new administrative or viewer user. All fields must be filled out for the user to be created successfully. Phone number must be entered in the following format: 5555555. Click the “Add” button to confirm the creation of the new user.

![NewUser](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img35_newUser.png)

### View All Users
Click the View All Users tab to view all the registered users in the FIL database. Select a user from the table and click “Delete” to remove the user from the database permanently.

![ViewAllUser](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img36_mult.png)

## Explore
The Explore tab itself is a blank page for the current version of the application.

![Explore](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img37_explore.png)

### Search
Fill in the text field and click on the Search tab to query for an existing project using keywords from the project name and/or description. Sort results by clicking on the column headers. Click on a project in the results list to view the General Info page for the selected project. 

![Search](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img38_search.png)

### Advanced Search	
Click the Advanced Search tab to query for a project using multiple search parameters. Each parameter entered will be used concurrently to filter the search results. Sort the search results by clicking on the column headers. Click on a project in the search result to view the General Info page for the selected project. 

![AdvSearch](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img39_advSearch.png)

## Edit (Select All/Cut/Copy/Paste)
Select text from the a textfield on a page and click the Edit menu item in the menu bar of the application allows users to select, cut, copy, and paste text to and from the application. On a PC, use CTRL-A, CTRL-X, CTRL-C, CTRL-V to select all, cut, copy, and paste text. On a MAC, use COMMAND-A, COMMAND-X, COMMAND-C, COMMAND-V to select all, cut, copy, and paste text outside the application. Always use the CTRL shortcuts inside the application.

![Edit](https://github.com/hinsenchan/fil_project_management_app_v2/blob/master/readme/img40_edit.png)

# Database Tables

## 1. filetypes
The filetypes TABLE contain 2 columns: id and type. id is the primary key. type holds the file type that is used in the Multimedia tab of a project page. The default file types in the database are PDF, XML, Doc/Docx, Image, Video, and Flash.

## 2. participant_designation
The participant_designation TABLE contains 2 columns: id and name. id is the primary key. name is the role that a participant may be classified as. It is used in the Participant tab of project pages. The default roles in the database are Student, Faculty, and Partners.

## 3. participants
The participants TABLE contains 9 columns: id, name_title, firstname, middlename, lastname, position, email, phone, and organization. id is the primary key. name_title is the title of a participant which can be classified as [blank], MD, or PHD. Position is the role that a participant may be classified as. The data from the participants TABLE is used in the Participant tab of project pages.

## 4. project
The project TABLE contains 11 columns: id, name, shortdesc, description, start_date, end_date, scope, display, outcome, location, and archive. id is the primary key. shortdesc is the short description of the project. description is the general description of the project. The data from the project TABLE is used in the Project tab of project pages.

## 5. project_category
The project_category TABLE contains 1 column: name. name is the primary key and it contains the categories that a project may be classified as. It is used in the Project tab of project pages. The default categories in the database are Bio Engineering, Civil Engineering, Computer Engineering, Electrical Engineering, and Mechanical Engineering.

## 6. project_category_map
￼￼The project_category_map TABLE contains 2 columns: project_id and category_name. project_id contains a project id from the project TABLE, and category_name contains a category from the project_category TABLE. This table is used to map a project with the categories that it has been classified with.

## 7. project_files_map
The project_files_map TABLE contains 4 columns: projectid, filetypeid, filename, and file path. projectid contains a project id from the project TABLE, and filetypeid contains a file type from the filetypes TABLE. This table is used to map a project with the media files that it contains.

## 8. project_participants
The project_participants TABLE contains 3 columns: project_id, participant_id, and designation. project_id contains a project id from the project TABLE, and participant_id contains a participant id from the participants TABLE. designation contains a role id from the participant_designation TABLE. This table is used to map a project with the participants that it contains and the roles those participants belong to.

## 9. project_status
The project_status TABLE contains 2 columns: status and status_description. status is the primary key. It contains the status that a project may be classified as. status_description is not currently used. project_status TABLE is used in the Project tab of project pages. The default categories in the database are Completed, Dormant, and In Progress.

## 10. project_status_map
The project_status_map TABLE contains 2 columns: project_id and status_name. project_id contains a project id from the project TABLE, and status_name contains a status from the project_status TABLE. This table is used to map a project with the status that it has been classified with.

## 11. project_tag_map
The project_tag_map TABLE contains 2 columns: projectid and tagname. projectid contains a project id from the project TABLE, and tagname contains a tag from the tags TABLE. This table is used to map a project with the tag that it has been classified with.

## 12. tags
￼The tags TABLE contains 1 column: tagname. tagname is the primary key and it contains the tags that a project may be classified as. It is used in the Project tab of project pages. The default tags in the database are Algorithms, Computer, Electrical, Humanity, Mechanical, and Rocket.

## 13. user_roles
The user_roles TABLE contains 1 column: name. name is the primary key and it contains the account types that a user may be classified as. It is used in the User tab of user management pages. There are two default roles: administrator and viewer. Administrators have access to view and create user accounts. Administrators may also create or edit project information. Viewer accounts may only search and view project information.

## 14. users
The users TABLE contains 7 columns: firstname, last name, emailaddress, username, password, contactnumber, and active. users is used to maintain the list of users in the User tab for the user management pages. active column is not currently used at the moment and is set to ‘1’ by default.

## 15. user_roles_map
The user_roles_map TABLE contain 2 columns: username and role_name. username contains a user from the users TABLE, and role_name contains a user role from the user_roles TABLE. This table is used to map users with their roles as administrators or viewers.

# Recommended Future Additions

## Manage Account
* Add validation for email address and phone number
* Fix password strength indicator

## Frugal Lab (Menu Tree)
* Add a page or transition to the Welcome page when Frugal Lab is clicked in the menu tree. Project (Menu Tree)
* Add a page or transition directly to Frugal Lab->Project->New Project when Project is clicked in the menu tree.

## Users (Menu Tree)
* Add a page or transition directly to Frugal Lab->Users->View All Users when Users is clicked in the menu tree.

## Explore (Menu Tree)
* Add a page or transition directly to Frugal Lab->Explore->Search when Explore is clicked in the menu tree.

## Project -> New Project (General Details Tab)
* Add ability for administrator to create or remove categories.
* Modify validation so that a new project can be added without an End Date

## Project -> New Project (Participants Tab)
* Add ability for administrator to create or remove titles.
Project -> New Project (Multimedia Tab)
* Add function so that a file added to the project will be copied to the application folder and stored in a sub-project folder.
* Add function so that file attachments can be accessed using FTP protocol from a remote machine.
* Add ability for administrator to add or remove file types

## Project -> Edit Participant (Menu Tree)
* Add ability for administrator to create or remove titles.

## Edit Projects -> General Info (Menu Tree)
* Add ability for administrator to create or remove categories.
* Modify validation so that a new project can be updated without an End Date
* Filter existing project drop-down list so that archived projects are not displayed

## Edit Projects -> Participants (Menu Tree)
* Add ability for administrator to create or remove titles.
* Fix “New Participant...” button so that it says “Hide” when it is activated
* Filter existing project drop-down list so that archived projects are not displayed

## Edit Projects -> Multimedia (Menu Tree)
* Add function so that a file added to the project will be copied to the application folder and stored in a sub-project folder.
* Add function so that file attachments can be accessed using FTP protocol from a remote machine.
* Add ability for administrator to add or remove file types
* Filter existing project drop-down list so that archived projects are not displayed

## View Projects -> General Info (Menu Tree)
* Modify print function so that it will format the project information into a searchable text format before it is printed

## View Projects -> Participants (Menu Tree)
* Modify print function so that it will format a list of project participants into a searchable text format before it is printed

## View Projects -> Multimedia (Menu Tree)
* Add function so that a file can be accessed through a project folder in the application folder
* Add function so that file attachments can be accessed using FTP protocol from a remote
machine.

## Users -> Add New User (Menu Tree)
* Add validation for email address and phone number 

## project_category TABLE
* Modify the table so that it uses a unique integer as its primary key

## project_category_map TABLE
* Modify the table so that it uses a unique integer as its primary key

## project_files_map TABLE
* Modify the table so that it uses a unique integer as its primary key

## project_participants TABLE
* Modify the table so that it uses a unique integer as its primary key

## project_status TABLE
* Modify the table so that it uses a unique integer as its primary key
* Remove status_description column which is not being used

## project_status_map TABLE
* Modify the table so that it uses a unique integer as its primary key

## project_tag_map TABLE
* Modify the table so that it uses a unique integer as its primary key

## tags TABLE
* Modify the table so that it uses a unique integer as its primary key

## user_roles TABLE
* Modify the table so that it uses a unique integer as its primary key

## users TABLE
* Modify the table so that it uses a unique integer as its primary key

## users_roles_map TABLE
* Modify the table so that it uses a unique integer as its primary key

# References

* [JavaTM Platform, Standard Edition 8 API Specification](http://docs.oracle.com/javase/8/docs/api/)
* [Java Package javax.swing](http://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
* [EclipseLink Java Persistence API (JPA)](https://eclipse.org/eclipselink/jpa.php)
* [Java MySQL Connector](http://dev.mysql.com/downloads/connector/j/)
* [toedter JCalendar 1.4](http://toedter.com/jcalendar/)

# Credits

This software was developed by Hinsen Chan and Sarvesh Sharma at Santa Clara University in Summer 2014.

* [Competition/Project Highlight on Santa Clara University's website](http://scu.edu/engineering/frugal/gallery/2012/Student-Projects.cfm)
* [Frugal Innovation Lab](http://www.scu.edu/engineering/frugal/)
