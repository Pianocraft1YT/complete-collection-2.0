# Go through every advancement, and adds 1 to score if you have obtained that advancement

execute if score complete_collection_2:collect/collect_stack_64 bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_stack_64
execute if score complete_collection_2:collect/collect_stack_16 bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_stack_16
execute if score complete_collection_2:collect/collect_stack_1 bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/collect_stack_1
execute if score complete_collection_2:collect/complete_collection_2 bac_obtained matches 1.. run advancement grant @a only complete_collection_2:collect/complete_collection_2
