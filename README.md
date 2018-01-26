# MediaLibs Core

This project contains the **core** of the project MediaLibs.
With this core, we can use simple models for your medialibs application.
If you would add attribute on a specific class, you can extends the current
classes and add your own attribute to complexified the models.

## Description of the libs

### Media
This library define the core of all medialibs : the Media object.
This object represent the media can get on a Medialib.

### Loan
This library define the model of loan system.

### Stock
This library define the model of the stock management.

### User
This library define the model of the user of the final app.
You can attribute 3 role for the user to manage properly
the privileges of each people who use the MediaLibs :
* GUEST_ROLE : A guest in the system.
* ADMIN_ROLE : The administrators of the MediaLibs.
* SUPERVISOR_ROLE : The supervisor to manage the app specifically.

## Deploy Libs

To deploy automatically all librairies of the project,
we just use the following command `$ mvn deploy`.

You can use this command on all package to deploy all libraries
or use it on a specific library to deploy the current library.