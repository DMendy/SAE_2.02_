<div align="center">
<h1> SAE_2.02</h1>
</div>

Ce project a pour but de vous presentez l'exploration algorithmique d'un problème en Java. 
Où  développer un algorithme d'exploration pour évaluer la durée de vie d'un jeu vidéo de type jeu de rôle en monde ouvert, en utilisant un modèle simplifié du jeu.

<h3> L'Analyse: </h3>

Objectif principal :

-  Développer un programme qui génère des solutions pour 
    un jeu vidéo de type jeu de rôle (RPG) en monde ouvert.

1) Gestion des quêtes :

- Les quêtes sont définies dans des fichiers texte, chaque quête étant décrite par plusieurs attributs, tels que son numéro, sa position, ses préconditions, sa durée, son expérience rapportée et son intitulé.
- Les préconditions des quêtes sont représentées par des combinaisons de conditions conjonctives et disjonctives.
- La quête finale a une interprétation légèrement différente, car l'expérience indiquée est l'expérience nécessaire pour pouvoir la réaliser.

2) Génération de solutions :

- Une solution du jeu est une séquence de quêtes qui respecte certaines règles, comme commencer par une quête sans précondition et terminer par la quête finale.
- Génération d'une solution efficace gloutonne qui choisit toujours les quêtes disponibles les plus proches.
- Génération d'une solution exhaustive qui réalise toutes les quêtes avant de faire la quête finale.
- Possibilité d'afficher les solutions de manière textuelle ou graphique.

<h3> Specification: </h3>

- Type de methode: Nous utiliserons la methode Agile





