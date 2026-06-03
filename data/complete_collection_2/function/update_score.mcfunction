

scoreboard players set @a complete_collection_2_done 0

execute as @a[advancements={complete_collection_2:collect/complete_collection_2=true}] run scoreboard players add @s complete_collection_2_done 1

execute as @a run scoreboard players operation @s bac_advancements += @s complete_collection_2_done
