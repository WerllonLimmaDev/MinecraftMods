Shear Upgraded
==============

Shear Upgraded is a Forge mod for Minecraft 1.20.1 that expands vanilla shears into a full tiered tool line with higher durability, vein mining for shear-friendly blocks, and chained shearing for compatible entities.

Version
-------

- Minecraft: 1.20.1
- Forge: 47.4.10
- Java: 17
- Mod ID: `shearupgraded`

Features
--------

- Five custom shears:
  - Iron Shears
  - Golden Shears
  - Emerald Shears
  - Diamond Shears
  - Netherite Shears
- Vein mining for valid blocks when holding Shift
- Preview outline that shows affected connected blocks before breaking
- Chained shearing for compatible nearby mobs when holding Shift
- English and Brazilian Portuguese localization

Tier Limits
-----------

- Iron: 8 targets, durability 297
- Gold: 16 targets, durability 357
- Emerald: 32 targets, durability 714
- Diamond: 64 targets, durability 1561
- Netherite: 128 targets, durability 2031

Supported Block Targets
-----------------------

- Leaves
- Wool
- Cobweb
- Vine
- Glow Lichen
- Grass
- Tall Grass
- Fern
- Large Fern
- Dead Bush
- Hanging Roots
- Tripwire

Supported Entity Targets
------------------------

The chained shearing behavior currently supports nearby entities that implement Forge shearing behavior, with safe matching rules:

- Sheep: chains only to sheep of the same color
- Mooshrooms: chains only to the same mushroom variant

How To Use
----------

1. Equip one of the custom shears.
2. Hold Shift while aiming at a valid block to preview the vein mining area.
3. Break the block while still holding Shift to trigger chained block breaking.
4. Hold Shift while shearing a supported mob to chain the action to nearby matching mobs.

Recipes
-------

- Iron, Gold, Emerald and Diamond Shears use shaped crafting recipes.
- Netherite Shears use the netherite smithing upgrade path from Diamond Shears.

Development
-----------

Useful commands:

- `./gradlew.bat build`
- `./gradlew.bat runClient`
- `./gradlew.bat runServer`

The generated release jar is written to:

- `build/libs/shearupgraded-1.0.0.jar`

Notes
-----

- The `run/` directory is for local development only and is ignored by Git.
- Additional technical project notes are available in `docs/`.
