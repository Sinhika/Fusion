#!/bin/bash

# scripts are from mod_utils project on my GitHub.

ID='fusion'
NAME='Fusion'
TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != $NAME ]; then
    echo "Running in wrong directory!"
    exit 1
fi


# recipes
TARGETDIR=${TOPDIR}/src/main/resources/data/${ID}/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# Silent's Mechanisms recipes

# crusher
make_silents_recipes.py --type=crusher --ingredient="${ID}:bronze_ingot" \
    --result="${ID}:bronze_dust" bronze_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:steel_ingot" \
    --result="${ID}:steel_dust" steel_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:sinisite_ingot" \
    --result="${ID}:sinisite_dust" sinisite_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:thyrium_ingot" \
    --result="${ID}:thyrium_dust" thyrium_dust_from_ingot

# alloy smelter
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
    "#forge:dusts/tin" "minecraft:bone_meal" --result "${ID}:bronze_nugget" \
    -- bronze_nugget_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
   "#forge:dusts/tin" "minecraft:gunpowder" --result "${ID}:medium_bronze_chunk" \
   -- medium_bronze_chunk_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
   "#forge:dusts/tin" "minecraft:redstone" --result "${ID}:large_bronze_chunk" \
   -- large_bronze_chunk_from_dust

make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/iron" \
    "#minecraft:coals" "#minecraft:coals" --result "${ID}:steel_nugget" \
    -- steel_nugget_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/iron" \
   "#minecraft:coals" "minecraft:gunpowder" --result "${ID}:medium_steel_chunk" \
   -- medium_steel_chunk_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/iron" \
   "#minecraft:coals" "minecraft:redstone" --result "${ID}:large_steel_chunk" \
   -- large_steel_chunk_from_dust

make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
    "#forge:dusts/adamantium" "minecraft:redstone" --result "${ID}:thyrium_nugget" \
    -- thyrium_nugget_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
   "#forge:dusts/adamantium" "minecraft:lapis_lazuli" --result "${ID}:medium_thyrium_chunk" \
   -- medium_thyrium_chunk_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
   "#forge:dusts/adamantium" "minecraft:glowstone_dust" --result "${ID}:large_thyrium_chunk" \
   -- large_thyrium_chunk_from_dust

make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
    "#forge:gems/onyx" "minecraft:glowstone_dust" --result "${ID}:sinisite_nugget" \
    -- sinisite_nugget_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
   "#forge:gems/onyx" "minecraft:blaze_powder" --result "${ID}:medium_sinisite_chunk" \
   -- medium_sinisite_chunk_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/mythril" \
   "#forge:gems/onyx" "minecraft:ghast_tear" --result "${ID}:large_sinisite_chunk" \
   -- large_sinisite_chunk_from_dust

