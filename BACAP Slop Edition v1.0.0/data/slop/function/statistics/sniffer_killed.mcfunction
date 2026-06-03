scoreboard players add @s slop_sniffer_killed 1
advancement revoke @s only slop:technical/sniffer_killed

execute as @a if score @s slop_sniffer_killed matches 100.. run advancement grant @s only slop:adventure/rounduction_legend