teams = ["aqua", "black", "blue", "dark_aqua", "dark_blue", "dark_gray", "dark_green", "dark_purple", "dark_red", "gold", "gray", "green", "light_purple", "red", "white", "yellow"]

for team in teams:
    print("TEAM " + team)
    print("execute if score complete_collection_2:collect/collect_stack_64 bac_obtained_" + team +  " matches 1.. run advancement grant @a[team=bac_team_" + team + "] only complete_collection_2:collect/collect_stack_64")
    print("execute if score complete_collection_2:collect/collect_stack_16 bac_obtained_" + team +  " matches 1.. run advancement grant @a[team=bac_team_" + team + "] only complete_collection_2:collect/collect_stack_16")
    print("execute if score complete_collection_2:collect/collect_stack_1 bac_obtained_" + team +  " matches 1.. run advancement grant @a[team=bac_team_" + team + "] only complete_collection_2:collect/collect_stack_1")
    print("execute if score complete_collection_2:collect/complete_collection_2 bac_obtained_" + team + " matches 1.. run advancement grant @a[team=bac_team_" + team + "] only complete_collection_2:collect/complete_collection_2")
    print("\n")
