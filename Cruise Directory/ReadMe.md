# Cruise Directory Project
------------------------------
A cruise directory project that I created for an object-oriented programming class I took in my Junior year of college. This project utilizes Java alongside the JavaFX library to create a user interface for creation, removal, storing, and updating of a cruise line's potential fleet and passenger listings. To create the GUI I utilized SceneBuilder's drag-and-drop interface to  implement elements, images, and pass information to the user when requested.

![Main Screen](https://user-images.githubusercontent.com/54562962/193212958-8ae15b19-4b2c-402f-a267-5ca2a079fbbc.jpg)

## Project Outline / Sepcifications
To view the project outline I was given please follow this link: [Project Outline](https://github.com/petersurlina/College-Projects-Updated-/blob/7d8065d21421f97f28251d43e7cab2adace04930/Cruise%20Directory/Final%20Assignment.pdf)

## UML Diagram
![Final UML](https://user-images.githubusercontent.com/54562962/193146207-99474bc6-42fc-4413-afa8-89f99378f3c6.jpg)

### UML Overview
- In this project we have 3 object classes: ship, cruise, and passenger
- We have controllers for each of the scenes that accept, validate, return, or modify the data (*10 Total Scenes)
- Each scene's controller directly communicates with the MenuController (Essentially our main menu) passing data back and forth as the user switches between scenes
- -> As one scene's controller collects the newly inputted / modified data it copies its own version of ArrayLists, storing each of the objects indepedently, to complementary ArrayLists in the MenuController. This ensures data is up to date the second we leave the scene and head back to the main menu.

### Scene Communication
- The code I wrote to communicate from the menu controller to the addShip controller. The same logic is used to all other scenes and controllers.

![Snip1](https://user-images.githubusercontent.com/54562962/193164659-cc10c5a2-51ad-4210-8ac6-93e407c0af4c.jpg)

- Code snippet from inside the addShipController showing our initialization of ArrayLists for each object type. 

![Snip2](https://user-images.githubusercontent.com/54562962/193164670-b3f7323f-9bd3-4623-9529-c5953f893a2b.jpg)
- Finally, the code to return to the starting menu while passing information back.

![Snip3](https://user-images.githubusercontent.com/54562962/193164690-78a7d221-8971-4d5d-9642-65dc79c23bb9.jpg)

## Test Run
-----------------
Quick test run of the program. I did not dive into the cruise and passenger portions of this project because I did not want to drag out the video. I believe there are still small bugs in there that can get in the way of the program as well. This video is meant to educate on the basic concepts and structure of the project and not every little detail.

[Video Link](https://drive.google.com/file/d/19CPI_FBPzKOQFLkbEZDvfWZlHYQrBDGs/view?usp=sharing)

## Running the project yourself
--------------------------------
### Prerequisite: Please have an installation of Java Version 17.0.1+ on your current machine
*The .jar file for this project will not run with a simple double click of the icon (Must be done utilizing the command line)

**Please change into the directory you have the project stored in. In my example it is on my desktop.**
```
cd Desktop
java --module-path "C:\JavaFx\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar "Cruise Directory.jar"
```
![Run Commands](https://user-images.githubusercontent.com/54562962/193210067-6b83f6c8-5919-495c-aff8-c8c3e075b7bd.jpg)


## What I learned
------------------------
- Deeper level of understanding of the JavaFX framework and SceneBuilder Program
- How to communication between scene objects with tha JavaFX framework
- GUI design concepts and how to link Front-End elements with Back-End logic
- Much greater knowledge on the utilization of ArrayLists as a whole

## Potential Changes / Fixes to the current code
- [ ] Improve graphical userface
- [ ] Fix bug when changing a person's name
- [ ] Fix bug when attempting to change the name of a cruise
- [ ] Scale project to full Screen / mobile

## License

This project is licensed under the [GNU GENERAL PUBLIC LICENSE V3.0](https://github.com/petersurlina/College-Projects-Updated-/blob/460072414feff305900a4cc8caae881e1a55a802/LICENSE)
