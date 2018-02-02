# MediaLibs Core

Ce projet contient le coeur de l'application MediaLibs.
Avec ce coeur, vous pourrez utiliser de simple modèle de données, afin de générer 
une application de type Médiathèque.
Si vous souhaitez ajouter de nouveaux attributs a vos objets, 
il vous suffira d'hérité de ces objets de base, afin d'y 
ajouter tout les attributs que vous souhaitez.

## Descriptions des bibliothèques

### Media
Cette bibliothèque représente les médias que l'on peut 
retrouver dans une médiathèque.

### Loan
Cette bibliothèque définie les services d'emprunts associés à votre médiathèque.

### Stock
Cette bibliothèque permet de gérer les stocks de média que vous posséder.

### User
Cette bibliothèque définit les *utilisateurs* présent dans l'application finale.
Il existe actuellement 3 rôles dans l'application, que vous pourrez étendre 
pour y ajouter votre système de rôle et de privilèges :
* GUEST_ROLE : Un invité sur le système.
* ADMIN_ROLE : L'administrateur de la médiathèque.
* SUPERVISOR_ROLE : L'administrateur du système informatique de l'application.

## Compilation des bibliothèque en local

Pour compiler les bibliothèques en des *jar* utilisable sur vos autres 
projet, il vous suffit de taper la commande suivante :
`mvn package -DskipTests=true`.

Faite bien attention a vous trouver dans le dossier contenant 
les sources de la bibliothèque que vous souhaitez compiler.

## Déployement des bibliothèque sur des système d'archivage de jar 

Pour déployer automatiquement ces bibliothèques, il vous suffit de lancer la commande suivante :
`$ mvn deploy`, après avoir bien entendu configurer votre système de gestionnaire de bibliothèque.
Vous pourrez alors utiliser ces bibliothèques dans n'importe quelle projet sans difficulté.