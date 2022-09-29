# Cruise Directory Project
------------------------------
A cruise directory project that I created for an object-oriented programming class I took in my Junior year of college. This project utilizes Java alongside the JavaFX library to create a user interface for creation, removal, storing, and updating of a cruise line's potential fleet and passenger listings. To create the GUI I utilized SceneBuilder's drag-and-drop interface to  implement elements, images, and pass information to the user when requested.

## Project Outline / Sepcifications
To view the project outline I was given please follow this link: [Project Outline](https://github.com/petersurlina/College-Projects-Updated-/blob/7d8065d21421f97f28251d43e7cab2adace04930/Cruise%20Directory/Final%20Assignment.pdf)

## UML Diagram
![Final UML](https://user-images.githubusercontent.com/54562962/193146207-99474bc6-42fc-4413-afa8-89f99378f3c6.jpg)

### UML Overview
- In this project we have 3 object classes: ship, cruise, and passenger
- We have controllers for each of the scenes that accept, validate, return, or modify the data (*9 Total Scenes)
- Each scene directly communicates with the MenuController (Essentially our main menu) passing data back and forth as the user switches between scenes
- -> As one scene collects the newly inputted / modified data it copies its own version of ArrayLists, storing each of the items, to complementary ArrayLists in the MenuController. This ensures data is up to date the second we leave the scene and head back to the main menu.

## Test Run
-----------------


*ADD PICTURE OF HOW SCENES COMMUNICATE
*ADD VIDEO LINK HERE: ()

## Running the project yourself
--------------------------------
### Prerequisites







## What I learned



## License

This project is licensed under the [GNU GENERAL PUBLIC LICENSE V3.0](https://github.com/petersurlina/College-Projects-Updated-/blob/460072414feff305900a4cc8caae881e1a55a802/LICENSE)

