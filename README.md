# Rapport du Projet Académique : Application E-commerce Microservices securisée avec Keycloak

## Introduction

Ce repo contient le code de l'application e-commerce développée en utilisant une architecture microservices avec Spring Boot et securisée avec keycloak. L'application gère les produits,  commandes, et factures. La base de données H2 a été employée pour le stockage des données.

---

## Structure Backend : Spring Boot Microservices


### Répertoires principaux

- **order-service** : Gestion des commandes.
- **customer-service** : Gestion des clients.
- **inventory-service** : Gestion des stocks.

![architecture](https://github.com/user-attachments/assets/c969a7f5-877c-4e2c-932a-a179f5d50326)


### Technologies Utilisées

- Spring Boot (Cloud, Data JPA, Web).
- H2 Database.
- Eureka Discovery.
- Gateway.

### Liens

- Lien du frontend Angular : [Repo Frontend](https://github.com/othsoh/ecom-microServiceApp-Front-angular/)
- Lien du ChatBot RAG : [Repo Frontend](https://github.com/othsoh/RAG-chatBot/)

---

## Base de Données : H2 Database

La base de données H2 a été choisie pour simplifier le développement. Elle permet un stockage en mémoire rapide et est facile à intégrer avec Spring Boot.

### Classes
![class-micro-service (3)](https://github.com/user-attachments/assets/f8449953-cf74-4c93-9095-e0fd39d11cc3)

---

## Fonctionnalités Clés

1. Gestion des produits : CRUD sur les produits.
2. Gestion des clients : Enregistrement et consultation des clients.
3. Gestion des commandes : Création et suivi des commandes.
4. Facturation : Génération des factures.
5. Gateway API : Accès centralisé et routage des services.

---

## Captures d'écran

![Image](https://github.com/user-attachments/assets/b96c7aba-46b4-4f4f-abf1-b6cea7fd81d3)
![Image](https://github.com/user-attachments/assets/411b1881-bdff-46a6-b82a-d237959ac905)
![Image](https://github.com/user-attachments/assets/af5962c6-33d9-47d7-93ab-495ad1ecd843)
![Image](https://github.com/user-attachments/assets/47397c9a-f0e8-4eee-83c5-ad742bed1e88)
---

## Conclusion

Le backend offre une architecture modulaire et scalable grâce à Spring Boot. Tous les services peuvent être déployés indépendamment, offrant une grande flexibilité.  

---

© 2024 Projet Académique - Application E-commerce Microservices et keycloak
