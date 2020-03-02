# SurvAIval
Created for CSCI-1082 FINAL

Features:
  - A.I-based critters which evolve over time
  - Multiple settings(or procedurally generated settings)
  - Introduce food/water supply and predators
  - Set the weather conditions
  - Expansive map option(to test migration patterns?)
  - Comprehensive list of potential mutations
  - Control the speed of simulation
  - Introduce disease to the population

  TODO:
  - TBD
  
  DONE:
  - N/A


UPDATED 3/2/2020

Main Menu
 - Run Simulation
 - Settings for simulation
 - Presets for simulation
 - Run Simulation Button

Simulation Settings
 - Presets
 - Load Preset Settings
 - Save Current settings as presets
 - Simulation
    - Simulation run count
    - Simulation Speed
 - Critter Settings
    - Critter Count
    - Base Critter Stats/Mutations
 - Map Settings
    - Vegetation/food count
    - Water count

Mutations
 - List of mutations
    - Changing basic stats
    - Movespeed
    - Height?
    - Cautious
       - Determines whether or not to actually go after a piece of food or not. Possibly roll to look for predators around the food
 - How they are passed on:
     - Copied from parent
 - How they occur
     - Random chance on birth/creation


Critter Decision Making
 - Turn, move

Map Layout
 - Tile Based (Hex or Square)
 - What is on a tile is displayed by uniquely colored dots
 - Dots lined from top left to bottom right (for multiple dots)
 - Top down view

Critter Abilities
 - Move
 - Has movespeed stat
 - Turn
 - Take Action
 - Eat food

Creature Stats
 - Movespeed
 - Health (only if there are carnivores)
 - Height?

Results
 - Bar graphs
 - Line graphs
