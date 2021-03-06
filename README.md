# SimpleSkyblock [![Build Status](https://travis-ci.com/garet90/simple-skyblock.svg?branch=master)](https://travis-ci.com/garet90/simple-skyblock)
## Description
A simple Skyblock. Includes all the essentials, such as land protection, island generation, co-op, and more, along with some optional extras such as Economy, Trading, Island Chat Channels and more, all of which can be disabled for maximum customization.

## Commands
- /island: Main command. Includes sub-commands such as /is help, /is visit [player], /is reset, /is home, /is sethome, /is settings (you can disable island visiting here)
- /balance: Shows how much money a player has
- /pay <player> <amount>: Pay a player some money
- /fly: Enable / disable flying
- /trade <player>: Trade with a player
- /shout <message>: Shout to the whole server.
## Permissions:
- skyblock.island: includes all /island commands and subcommands
- skyblock.economy: includes /balance and /pay commands
- skyblock.fly: includes /fly command
- skyblock.shout: includes /shout commands
- skyblock.trade: includes /trade commands
- skyblock.admin: allows admin control of skyblock plugin (such as /is allowreset)
## Installation:
Plop it into your plugins folder, then after first run you will be able to edit the config.yml to your liking. If you would like the Skyblock world to be your default world (the "level-name" declared in server.properties) you will need to add the following to "bukkit.yml"
```
worlds:
  world:
    generator: SimpleSkyblock
  world_nether:
    generator: SimpleSkyblock
```
If you want it to be a separate world, there is no need to add this to the bukkit.yml, and this will be handled for you automagically. You do not need a plugin like Multiverse, the world will be generated and players can travel to it without it. Plugins like Multiverse can still be used, just make sure to set the generator to SimpleSkyblock.
Pay special attention when editing config.yml, because some of the settings require specific values or they wont work, like "BIOME". A list of all the settings and their descriptions are listed below.

## config.yml
```
# Welcome to the configuration of SimpleSkyblock!
# Below are some of the customizable parts of
# SimpleSkyblock! If you need something special, feel
# free to send me an email at themanhimself@garet.holiday



# +-------------------------------------------+
# |       WORLD GENERATION / MANAGEMENT       |
# +-------------------------------------------+

# SimpleSkyblock is equipped with a world generator which
# will generate a blank world with no blocks. To use it,
# simply add the following to bukkit.yml:
# worlds:
#   [world name]:
#     generator: SimpleSkyblock

# To change the biome of the world generated, edit the
# following line.
BIOME: PLAINS

# To change the name of the world which all skyblock islands
# will generate, edit the line below. If the world doesn't
# exist, we'll create a new one for you using SimpleSkyblock's
# empty world generator.
WORLD: world

# The height at which the islands will generate. This is the Y
# value at which the bedrock block will be.
ISLAND_HEIGHT: 70

# The width of the claimed island plot. Changing this will
# change the size of the claimed island plot in the X
# direction. The negative-most block in the X will be half an
# island width away from the island border. Islands will, by
# default, have 1 block of no-man's land between them.
ISLAND_WIDTH: 5000

# Island depth is the same as island width, but in the Z
# direction.
ISLAND_DEPTH: 5000

# The limits are how far SimpleSkyblock is allowed to generate
# islands. The islands will generate in the following pattern:
# The first island will generate at -LIMIT_X, -LIMIT_Z. Every
# time a new island is generated, it will add an ISLAND_WIDTH
# to the X value, until it hits LIMIT_X, after which it will
# go back to -LIMIT_X and increment Z by one ISLAND_DEPTH.
LIMIT_X: 29990000

# LIMIT_Z is the limit in which islands can generate in the
# SimpleSkyblock world.
LIMIT_Z: 29990000

# The settings listed above allow for 35,976,004 islands, a
# number I'd be suprised if you hit



# +------------------------------+
# |       GENERAL SETTINGS       |
# +------------------------------+

# CHAT_PREFIX is the "name tag" for SimpleSkyblock when it
# is speaking in the chat. Use '$' for color codes.
CHAT_PREFIX: '$7[$bSKYBLOCK$7] $r'

# VOID_INSTANT_DEATH toggles if players die instantly in the
# void instead of slowly losing health.
VOID_INSTANT_DEATH: true

# DISABLE_PLAYER_COLLISIONS toggles player collisions. This
# is active for the skyworld and the nether counterpart
# only. (a change from previous versions)
DISABLE_PLAYER_COLLISIONS: true

# USE_CHATROOMS defines whether to use SimpleSkyblock's
# chatrooms. They create seperate channels for each island,
# and allow only players with skyblock.shout permission to
# talk to the whole server using /shout. When this is
# disabled, the server goes back to default chatting or
# lets another plugin take over.
USE_CHATROOMS: true

# CHAT_WORLDS defines which worlds to use SimpleSkyblock's
# chatrooms in. Using * will use the chatrooms for all
# worlds.
CHAT_WORLDS:
- '*'

# INFINITE_RESETS defines whether players can reset their
# islands as much as they want. This can be exploited, so
# island resets are generally limited. An operator can
# allow an island reset by using /is allowreset <player>
INFINITE_RESETS: false

# If INFINITE_RESETS is false, RESET_COUNT is how many
# times the player will be able to reset their island.
RESET_COUNT: 3

# USE_NETHER determines whether to allow players to have a
# nether island.
USE_NETHER: true



# +-----------------------------+
# |       ISLAND SETTINGS       |
# +-----------------------------+

# GENERATE_ORES determines whether or not to generate ores
# in the cobblestone generator instead of just cobblestone.
# Enabling this will also generate ores on the bottom of
# the island as well during island generation. This is
# only active in the skyblock world.
GENERATE_ORES: true

# GENERATOR_ORES are the ores which will be generated,
# along with the percent chance of generation. These do
# not technically need to be ores. They must be formatted
# as follows:
# [BLOCK_NAME]:[PERCENT_CHANCE]
GENERATOR_ORES:
- COAL_ORE:5
- IRON_ORE:7.5
- GOLD_ORE:.2
- DIAMOND_ORE:.2
- LAPIS_ORE:.2
- REDSTONE_ORE:1.5
- EMERALD_ORE:.1
- OBSIDIAN:.05
- STONE:42.125
- COBBLESTONE:42.125

# CHEST_ITEMS are the items that appear in the chest
# that generates on the islands. They must be formatted
# as [ITEM]:[AMOUNT]
CHEST_ITEMS:
- LAVA_BUCKET:1
- ICE:2
- SUGAR_CANE:1
- RED_MUSHROOM:1
- BROWN_MUSHROOM:1
- PUMPKIN_SEEDS:1
- MELON_SLICE:1
- CACTUS:1
- COBBLESTONE:16

# LEVEL_POINTS are the points which you players get
# added towards their islands based on each block
# placed, destroyed, or generated.
# The island level is calculated using the following
# formula:
# l = sqrt(p)-9
# where p is the amount of points an island has. Each
# island starts with 100 points by default.
# All other blocks not listed are calculated using
# the value of 'Default'.
LEVEL_PTS:
- Default:1
- COBBLESTONE:0.1
- SAPLING:50
- DIAMOND_BLOCK:1000
- EMERALD_BLOCK:750
- IRON_BLOCK:100
- REDSTONE_BLOCK:50
- OBSIDIAN:75

# USE_TRUSTS determines whether islands can "trust"
# players to break blocks, use chests, kill mobs, etc
# without actually being a member of the island.
# Requires special permission "skyblock.trust"
USE_TRUSTS: false



# +------------------------------+
# |       ECONOMY SETTINGS       |
# +------------------------------+

# USE_ECONOMY determines whether to use the
# SimpleSkyblock economy to begin with. Changing
# this will disable all economy features.
USE_ECONOMY: true

# STARTING_MONEY is the amount of money the players
# receive when they start their islands.
STARTING_MONEY: 500.0

# KILL_MONEY is the amount of money that players
# get for the mobs which they kill. They must be
# formatted as follows:
# [MOB]:[DOLLARS]
# This additionally accepts values of 'Default',
# 'Monster', and 'Animals'.
KILL_MONEY:
- Default:0
- Monster:3
- Animals:1
- CREEPER:5
- ENDERMAN:10
- ZOMBIE:2
- SPIDER:4

# LOSS_ON_DEATH is the amount of money that
# players lose when they die. It can be 'half' or
# a number.
LOSS_ON_DEATH: half



# +--------------------------------+
# |       MECHANICS SETTINGS       |
# +--------------------------------+

# USE_CUSTOM_MECHANICS determines whether to use
# custom SimpleSkyblock mechanics, or whether to
# keep it to just the basics. Setting this to false
# will turn all below-listed mechanics settings
# off.
USE_CUSTOM_MECHANICS: true

# BLAST_PROCESSING toggles whether items can be
# blasted to create other materials. This includes
# blasting cobble to get gravel and gravel to sand,
# which were added to provide a way to get more
# dirt which requires players to be creative.
# These mechanics are removed when this is set to
# false.
BLAST_PROCESSING: true

# BONEMEAL_DOES_MORE toggles whether to use custom
# bonemeal mechanics or not. The custom mechanics
# allow for the obtaining of saplings and seeds
# through bonemealing grass, kelp and sea pickles
# through bonemealing underwater dirt, and
# bonemealing dirt to have it become grass. These
# were all added to make plants, as well as grass
# attainable (especially if grass is destroyed)
BONEMEAL_DOES_MORE: true

# COBBLE_HEATING toggles whether or not to use
# custom cobble heating mechanics which allow lava
# to be created by chance if coal blocks are burned
# underneath a cobblestone block. This was added to
# allow users to get more lava, but can be disabled
# by setting this to false.
COBBLE_HEATING: true

# SOUL_SAND determines whether enemies killed on
# sand in the skyblock nether will turn the sand
# into soul sand.
SOUL_SAND: true



# You survived! You made it through the entire
# config! Good job, now don't edit this line, or
# it might do some funky stuff.
config-version: 1.3.6
  ```
