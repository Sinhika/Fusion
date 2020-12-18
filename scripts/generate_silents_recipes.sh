#!/bin/bash

# scripts are from mod_utils project on my GitHub.

TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != 'Fusion' ]; then
    echo "Running in wrong directory!"
    exit 1
fi


# recipes
TARGETDIR=${TOPDIR}/src/main/resources/data/fusion/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# Silent's Mechanisms recipes

# crusher
make_silents_recipes.py --type=crusher --ingredient='fusion:bronze_ingot' \
    --result='fusion:bronze_dust' bronze_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient='fusion:steel_ingot' \
    --result='fusion:steel_dust' steel_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient='fusion:sinisite_ingot' \
    --result='fusion:sinisite_dust' sinisite_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient='fusion:thyrium_ingot' \
    --result='fusion:thyrium_dust' thyrium_dust_from_ingot

# alloy smelter
make_silents_recipes.py --type=alloy_smelter --ingredient '#forge:dusts/copper' \
    '#forge:dusts/tin' 'minecraft:bone_meal' --result 'fusion:bronze_nugget' \
    -- bronze_nugget_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient '#forge:dusts/copper' \
   '#forge:dusts/tin' 'minecraft:bone_meal' --result 'fusion:medium_bronze_chunk' \
   -- medium_bronze_chunk_from_dust
make_silents_recipes.py --type=alloy_smelter --ingredient '#forge:dusts/copper' \
   '#forge:dusts/tin' 'minecraft:redstone' --result 'fusion:large_bronze_chunk' \
   -- large_bronze_chunk_from_dust

