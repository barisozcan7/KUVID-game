# Kuvid - AGFC

COMP302 Term Project made by Attila Fan Club.

## Our Team

Atahan Aksoy

Barış Özcan

Onur Şahin

Onat Yapıcı

Yiğit Can Kuş

Alp Karagöz

## Usage

Database Connection:

Our game works fine without connecting to the database; however, if you want to play the game with a database, since we don't have an online server, you have to run MongoDB on your local. 

1- Install MongoDB for 
[Windows](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)
, or for [MacOS](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/
).

2- Find the installed path, for Windows its  <code>C:\Program Files\MongoDB\Server\3.2</code>

3- Start the mongodb daemon by running <code>C:\mongodb\bin\mongod.exe</code>

4- Connect to MongoDB using the Mongo shell <code>C:\mongodb\bin\mongo.exe</code>

5- Run the game.

Latest Changes:
For the latest changes, please pull the dev branch. You can find the latest working version for the Phase demo's in the master branch.

## What we have done so far?
- Building mode is completed.
- Statistics panel is completed.
- Blending mode is completed.
- Moving and rotating atom shooter.
- Atom shooter does not go out of boundaries.
- Picking atoms randomly.
- Shooting atoms and powerups.
- Selecting powerups with click events.
- Falling powerups and molecules.
- Hitting molecules with corresponding atoms.
- Removing atoms, molecules and powerups when they go out of screen.
- Atoms are powerups are reflected after they hit the walls.
- Increasing score after hitting a molecule.
- Timer based animations.
- Pause / Return game features.
- Pause game UI.
- End game logic.
- End game UI.
- Restart game feature.
- Reaction blockers are falling and they can give damage.
- Reaction blocker prevents the collision of atom and molecule if the collision is in the range of it.
- Default distance unit L is implemented.
- New atom behavior is implemented.
- Shields are implemented.
- We can have multiple save files and load from them.
- We can have multiple saves in the database and load from them.
- We have music and sound effects.
- We have Junit tests for Controllers.

## Which design patterns do we use?

- Polymorphism:
    We have a base Drawable class. It has fields such as icon, xCoordinate, yCoordinate,
   rotationDegree and Type. All of our drawable objects extend this class. We have
   a base Atom class that extends Drawable class, and all AlphaAtom, BetaAtom, GammaAtom,
   and SigmaAtom classes extend Atom. Similarly, we have base Molecule and Powerup classes,
   and classes such as AlphaMolecule or AlphaPowerup extend them.
   
- Model-View-Controller:
     We completely seperated domain classes from controller classes and UI classes. We are
    extremely careful about the fact that our UI classes does not contain any logic, and our
    Views communicates with models through controller classes. 
     We have an AtomShooterView class. In that class, we are only drawing Atom shooter and listen
    key events. When a key is pressed, we call one of the AtomShooterController's methods according
    to the pressed key. Inside AtomShooterController's methods, we manipulate AtomShooter's model.
    Then, UI is updated. We have a similar approach for all drawable classes.
    
- Factory Design Pattern:
    We have AtomFactory, MoleculeFactory, PowerupFactory and ViewFactory classes. For example, 
 we use MoleculeFactory's generateMoleculeRandomly() method to generate molecules. By sampling and
 basic probability calculations, this method creates random molecules. In ViewFactory class, we have
 a getView() method which takes the game mode as an input, and builds and returns a View accordingly.
 
- Singleton Design Pattern:
    We have used Singleton design pattern for many classes. We have used it for classes like Game. Game is one of our domain model
  classes and we need to reach it and manipulate it from lots of places. By making it singleton, we
  are sure that there is only one Game object during the whole game and we can reach it and modify it
  easily with getInstance() method.
    
- Low Coupling & High Cohesion:
    With the design patterns we have used so far, we believe we achieved both low coupling and high 
  cohesion. Our classes do not need to be concerned with the others internal implementation.
  For example, our atom shooter picks an atom randomly, but it does not know many information
  about the current situation of atoms. AtomFactory knows all the details about the atoms and does the job
  with createAtom() method. Also, we achieved low coupling and high cohesion by using MVC pattern
  since our models do not know anything about the views and views can only communicate with models
  by controllers.
  
- Strategy Design Pattern:
    We used Strategy Design Pattern for the movement of the Molecules. We have a MoleculeMoveStrategy
  interface which has a move method.We have classes such as MoveStraight and MoveZigzag 
  that implements that strategy interface and overrides move method. We have a moleculeMoveStrategy
  field in our base molecule class.
  
- Decorator Design Pattern:
    We used Decorator Design Pattern for the addition of Shields to the atoms. We have an
  abstract base class ShieldDecorator. It has an Atom field and an abstract method addShield(). 
  We have classes such as EtaShieldDecorator and ThetaShieldDecorator that extends this class,
  and overrides addShield() method. addShield() method modifies the efficiency and speed of the
  atom object and return it. In our Shield Controller class, when a shield is added, we replace
  the current selected atom with the one generated from Decorator classes.
  
- Adapter Design Pattern:
    We used Adapter Design Pattern for the save/load architecture. We have two interfaces named as SaveLoad and AdvancedSaveLoad. While the former contains the generic method definitions such as save, load, and fetch; the latter contains more detailed method definitions such as saveToFile, saveToDatabase, etc. DatabaseSave and FileSave classes are implementing the AdvancedSaveLoad interface and the corresponding methods. Our adapter class implements SaveLoad and has a field named advancedSaveLoad; which is reinitialized to a specified implementation (FileSave or DatabaseSave) according to the parameter passed in the constructor. Likewise, the methods implemented by the adapter class contains a check for the parameter type and calls the specified function for the specified type. Our SaveLoadController class implements the SaveLoad interface and has a SaveLoadAdapter field so that we have another layer between UI and logic. This way, we have a flexible save/load functionality where we can utilize the desired operation, and also a decoupled system.

