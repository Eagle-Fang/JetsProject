# Jets Project

### Description

This program simulates a airfield management system with along with a jet application interface.  The program starts by reading in at least five aircraft descriptions from a .txt file.  Users are prompted to interact with the aircraft inventory by querying for the fastest aircraft and longest range.  They can also add and remove aircraft from the initial inventory.  

### Technologies Used

Java v. 1.9; Eclipse

### Java Topics covered
This assignment allowed us to apply many of the lessons learned during the first 3 weeks of at Skills Distillery.  Some of the more difficult topics included abstract class implementation, encapsulation, and polymorphism.  Additionally, the assignment This was good practice on inheritance, for-each loops, and buffer reading from a file. 

### Application Overview
We created a fleet of jets with different capabilities. The application includes a menu to use the jets and access information about them.  

### User Stories

**User Story #1
Create a JetsApplication with a main method to launch your program.

**User Story #2
Jets are found at an AirField. Create the AirField class, which has an empty List of Jets.

**User Story #3
On program startup, populate the AirField with at least 5 Jets of different types.
These jets must be read from a text file, where each line in the file contains data for a single Jet object.
This file exists at the root of your Eclipse project. It can be comma- or tab-separated; either implementation is acceptable.  The method to parse a file into Jet objects should return a List<Jet>. Its parameter can be a String file name.  

User Story #4
There is a menu with these options:

List fleet
Fly all jets
View fastest jet
View jet with longest range
Load all Cargo Jets
Dogfight!
Add a jet to Fleet
Remove a jet from Fleet
Quit

**User Story #5
List fleet prints out the model, speed, range, and price of each jet. (There must be at least 5 jets stored when the program starts).

**User Story #6
Fly all Jets calls the fly() method on the entire fleet of jets. fly() prints out the jet details and the amount of time the jet can fly until it runs out of fuel (based on speed and range).

**User Story #7
The view fastest jet and longest range options both print out all of the information about a jet.

Note: these methods must search the collection of jets to find the appropriate jet.
**User Story #8
The user is presented with an option specific to the interfaces you created. For example, Load all Cargo Jets, above, finds all implementors of the CargoCarrier interface and calls loadCargo() on each. (Note that the menu text is italicized because your options may be different, depending on your interfaces.)

**User Story #9
A user can add custom jets to the fleet.  Stretch Goal: This leads to a sub-menu where the user chooses the type of Jet. Users then enter information for the Jet, and it is added to the AirField.

**User Story #10
A user can remove a jet from the fleet.The user is presented with a sub-menu to select a jet to delete by number. Stretch Goal: a user can remove a jet (or jets) by name.


#**User Story #11
Quit exits the program.

## Lessons Learned
When developing code to address problems as complex such as this one, it is always a good idea to create a plan before starting to code. 