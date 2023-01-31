# Dépendances explication :



### WEB :

Module consacré au développement d’applications web et développement  d’API.

### JPA :

Spring Data JPA fournit une implémentation de la couche d'accès aux données pour une application Spring. C'est une brique très pratique car elle permet de ne pas réinventer la roue de l'accès aux données à chaque nouvelle application et donc de se concentrer sur la partie métier.

### THYMELEAF :

Thymeleaf est un template engine (moteur de rendu de document) écrit en Java. Principalement conçu pour produire des vues Web, il fournit un support pour la génération de documents HTML, XHTML, JavaScript et CSS (voire de n’importe quel format texte).

### H2 :

H2 est une base de données rapide et légère qui peut être persistée (dans un fichier) ou non.

### SPRING BOOT DEV TOOLS :

permet la mise à jour à distance. Le client distant surveille le chemin d'accès aux classes de l'application pour déterminer les modifications, comme pour la fonction de redémarrage à distance.

### HIBERMATE :

Hibernate est une solution open source de type ORM (Object Relational Mapping) qui permet de faciliter le développement de la couche persistance d'une application


### Questions sur “controller” :

GetMapping(“/greeting”)

return “greeting”;

model.addAttribute(“nomTemplate”, nameGET);



### Question etape 17 :
La table “address” s’affiche maintenant.

### Question etape 18 :
L’annotation @Entity sur la classe “address” lance un mapping de la classe pour en créer une classe automatiquement.


### Question etape 20 :
En faisant “select * from address;” le contenu de la base s’affiche. Il contient bien deux lignes qui sont insérées grâce à “data.sql”.


### Question etape 22 :
Cela permet à Spring de résoudre et d'injecter des beans collaboratifs dans notre bean.


# TP4 : étape 6

### Faut-il une clé API pour appeler MeteoConcept ?

Oui, cette clef est appelée token et permet de s'identifier lors de l’appel à l’API. Sans cette clef, la requête est rejetée par le serveur.

### Quelle URL appeler ?

“https://api.meteo-concept.com/api/forecast/daily/0?token=” en y ajoutant le token fourni par le site meteo concept ainsi que le “latlong=.......” qui permet de renseigner la latitude et la longitude de l’adresse recherchée.

### Quelle méthode HTTP utiliser ?

Il faut utiliser la méthode GET pour faire appel à cette API.

### Comment passer les paramètres d'appels ?

De même que décrit dans la question 2 “Quelle url faut il appeler?”, les paramètres sont séparés par “?” pour le token et puis par “&” pour “latlong=”.

### Où est l'information dont j'ai besoin dans la réponse :

Les informations se trouvent dans le corps de “forecast” de la réponse JSON de l’API.


# Lien vers projet : https://github.com/Pevan29/poo