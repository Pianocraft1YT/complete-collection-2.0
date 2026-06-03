scoreboard players add @s slop_pink_sheep_killed 1
advancement revoke @s only slop:technical/pink_sheep_killed

execute as @a if score @s slop_pink_sheep_killed matches 1000.. run advancement grant @s only slop:animal/sheep_legend