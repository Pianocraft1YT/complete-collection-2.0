items = ["obsidian"]

             #   { "slot": 0, "item": { "id": "minecraft:obsidian", "count": 64 } },
for item in items:
    for i in range(27):
        print({
        "slot": str(i),
        "item": {
            "id": "minecraft:" + item,
            "count": 64
        }
    })
