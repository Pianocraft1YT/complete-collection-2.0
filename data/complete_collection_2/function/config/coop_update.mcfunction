# Go through every advancement, and adds 1 to score if you have obtained that advancement

execute if score complete_collection_2:collect/collect_overworld bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_overworld
execute if score complete_collection_2:collect/collect_nether bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_nether
execute if score complete_collection_2:collect/collect_end bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_end
execute if score complete_collection_2:collect/complete_collection_2 bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/complete_collection_2
