# Chefs' Choice

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description

Chefs’ Choice makes meal planning simple through recipe recommendations for users based on ingredients they already have in their fridge or pantry.

Team Members:

Lucille Campbell,
Tyrees Carney,
Neariah Mandisa,
Tameika Scott, and
Bryan Williamson

### App Evaluation

- **Category:** Food & Drink
- **Mobile:** This app is intended for mobile devices using android operating system. 
- **Story:** Users can capture an image of their fridge or pantry to detect ingredients that can be used in various recipes. 
- **Market:** This app is open to users of all ages.
- **Habit:** This app could be used daily for each meal (breakfast, lunch, dinner) of the day. 
- **Scope:** First we would like users to use their camera to filter ingredients in generated recipes which helps eliminate food waste and decision fatigue. Large potential for business use by fitness trainers to create meal plans for their clients. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can sign up or log in to see their previous activity
* User can click a button to access their camera and capture an image 
* User can discover new recipes 
* User can save their favorite recipes


**Optional Nice-to-have Stories**

* User can share their favorite recipes (via text messaging, email, social media, etc.)
* User can rate recipes
* User can omit recipes based on dietary restrictions, food allergies or disliked items
* User can search for cocktail recipes or wine pairings
* User can review recipes
* User can learn food trivia


### 2. Screen Archetypes

* Splash/Login Screen 
   * A brief introduction of the app
 
* Camera Screen 
   * Allows user to capture image in real-time

* Ingredients Screen 
   * Allows user to see the identified items that will be used to generate recipes
   
*  Recipe Screen 
   * Allows user to scroll through and select a recipe 
   
*  Detail Screen 
   * Allows user to click a recipe option and view more information about it in detail
 
*  Favorites Screen 
   * Allows user to see an overview of their favorite recipes
   

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* App Introduction
* Camera
* Suggested Recipes 

Optional: 
* Favorites 

**Flow Navigation** (Screen to Screen)

* [list first screen here]
   * [list screen navigation here]
   * ...
* [list second screen here]
   * [list screen navigation here]
   * ...

## Wireframes
See early mockups: "https://wireframe.cc/pro/pp/a2d29070b510511" 

### [BONUS] Digital Wireframes & Mockups
![IMG_2403](https://user-images.githubusercontent.com/83090104/150610780-6ac70369-9e2a-4832-aefc-89422a03daf9.PNG)

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
| HTTP Verb     | Endpoint      | Description   
| ------------- | ------------- | --------    |
| `GET`        | recipes/findByIngredients         | `get recipes by ingredients`   |
| `GET`        | food/trivia/random         | `get random food trivia`   |
| `GET`        | recipes/{id}/card        | `get a recipe card for a recipe`   |
| `GET`        | recipes/complexSearch      | `get recipes by using advanced filtering and ranking`   |
| `GET`        | food/products/upc/{upc}/      | `get information about a packaged food using its UPC`   |

