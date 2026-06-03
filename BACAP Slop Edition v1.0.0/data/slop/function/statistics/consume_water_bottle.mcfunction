# Increases scoreboard upon consuming this item
scoreboard players add @s slop_consume_water_bottle 1
advancement revoke @s only slop:technical/consume_water_bottle

execute as @a if score @s slop_consume_water_bottle matches 100.. run advancement grant @s only slop:building/stay_hydrated