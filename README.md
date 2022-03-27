# Chefs' Choice

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description

Chefs’ Choice makes mealtime simple through recipe recommendations for users from everyday ingredients found at home.

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

* Splash Screen 
   * A brief introduction of the app (logo & app name)

* Login Screen 
   * Allows user to sign in via email or proceed without login 

* Home Screen 
   * Allows user to browse recipes categorized by type (ex. popularity) and learn fun facts about food

* Recipes Screen 
   * Allows user to search specified ingredients that will be used to generate recipes displayed in a scrollable list
   * Allows user to use camera to scan UPC barcodes in real-time and generate information displayed in an alert dialog box
   
*  Detail Screen 
   * Allows user to click a recipe option and view more information about it in detail
 
*  Favorites Screen 
   * Allows user to see an overview of their favorite recipes

*  Information Screen 
   * Allows user to see a description of how to use the app
   

### 3. Navigation

**Tab Navigation** (Tab to Screen)

*  Bottom Bar Navigation
  *  Home Screen 
  *  Recipes Screen 
  *  Favorites Screen 
  *  Info Screen

**Flow Navigation** (Screen to Screen)

* Splash Screen
   * [list screen navigation here]
   * ...
* Login Screen 
   * [list screen navigation here]
   * ...
* Home Screen
   * [list screen navigation here]
   * ...
* Recipes Screen 
   * [list screen navigation here]
   * ...
* Favorite Screen 
   * [list screen navigation here]
   * ...
* Info Screen 
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

Spoonacular API Documentation: https://spoonacular.com/food-api/docs

 * Base URL - https://api.spoonacular.com/
 
| HTTP Verb     | Endpoint      | Description |  
| ------------- | ------------- | --------    |
| `GET`        | recipes/findByIngredients         | `get recipes by ingredients`   |
| `GET`        | food/trivia/random         | `get random food trivia`   |
| `GET`        | recipes/{id}/card        | `get a recipe card for a recipe`   |
| `GET`        | recipes/complexSearch      | `get recipes by using advanced filtering and ranking`   |
| `GET`        | food/products/upc/{upc}/      | `get information about a packaged food using its UPC`   |

