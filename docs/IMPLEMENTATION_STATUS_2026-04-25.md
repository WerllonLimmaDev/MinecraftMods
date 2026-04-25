# Shear Upgraded Status

Date: 2026-04-25

This file complements `Shear_Upgraded_Technical_Documentation.txt` with the current repository state after the structure cleanup and tier completion work.

## Current scope

- Minecraft `1.20.1`
- Forge `47.4.10`
- Java `17`
- Mod ID: `shearupgraded`
- Base package: `dev.werllon.shearupgraded`

## Repository status

- The old MDK template bootstrap and example registrations were removed.
- Item registration is centralized in `ModItems`.
- The codebase now contains the following implemented shears:
  - `iron_shears`
  - `golden_shears`
  - `emerald_shears`
  - `diamond_shears`
  - `netherite_shears`
- Vein-mining block eligibility is now data-driven through the block tag:
  - `data/shearupgraded/tags/blocks/vein_mineable_with_shears.json`
- Preview rendering remains client-only.
- Entity vein mining is still not implemented.

## Tier matrix

| Tier | Durability | Vein limit | Registration | Recipe | Lang | Model | Texture | Tooltip | Preview |
| --- | ---: | ---: | --- | --- | --- | --- | --- | --- | --- |
| Iron | 297 | 8 | Yes | Yes | Yes | Yes | Yes | Yes | Yes |
| Gold | 357 | 16 | Yes | Yes | Yes | Yes | Yes | Yes | Yes |
| Emerald | 714 | 32 | Yes | Yes | Yes | Yes | Yes | Yes | Yes |
| Diamond | 1561 | 64 | Yes | Yes | Yes | Yes | Yes | Yes | Yes |
| Netherite | 2031 | 128 | Yes | Yes | Yes | Yes | Yes | Yes | Yes |

## Validation performed

- `./gradlew.bat build`
  - Result: success
- `./gradlew.bat runServer`
  - Result: mod loads successfully until normal server stop condition on missing `eula.txt`
  - No registration or metadata errors were observed during startup

## Notes

- Netherite shears use a smithing recipe from diamond shears plus `netherite_ingot`, matching the modern Minecraft progression pattern.
- The original PDF and TXT documentation remain useful as project history, but this file should be treated as the source of truth for the current repository state.
