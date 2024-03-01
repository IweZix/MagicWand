# MyMod

## Assets
mymod/models/block/my_block.json <br>
get textures block from mymod/textures/block/my_block.png <br>
get textures item from mymod/textures/item/my_block.png <br>

## Créer un Block
Un block est créer dans mymod/block/MyBlock.java <br>
Un item est créer dans mymod/item/MyItem.java <br>

## Créer un Block Custom
- Un block custom est créer dans mymod/block/custom/ + nomDuBlock + Block <br>
- Ensuite, il faut créer le block dans mymod/block/MyBlocks.java <br>
  En utilisant la classe nomDuBlock + Block créer au par avant
- 
## Lang
Anglais : mymod/lang/en_us.lang <br>
Français : mymod/lang/fr_fr.lang <br>

## Advanced Block
Un block avancé est créer dans mymod/block/custom/ + nomDuBlock + Block <br>

## Miner un block
resources/data/mymod/loot_tables/blocks/my_block.json <br>
```json
{
  "type": "minecraft:block",
  "pools": [
    {
      "bonus_rolls": 0.0,
      "conditions": [
        {
          // doit être en mode survie
          "condition": "minecraft:survives_explosion"
        }
      ],
      "entries": [
        {
        // à la casse, le block drop un item
          "type": "minecraft:item",
          // l(item dropper
          "name": "mymod:my_block
        }
      ],
        // nombre de fois que le block peut être cassé
      "rolls": 1.0
    }
  ]
}
```

resources/data/minecraft/tags/blocks/mineable/pickaxe.json <br>
si vous voulez que le block soit minable avec une pioche, ajouter le nom du block dans le fichier <br>
```json
{
  "values": [
    // modid:nomDuBlock
    "mymod:my_block"
  ]
}
```
