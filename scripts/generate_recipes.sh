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

# FUSION RECYCLING RECIPES
# gold recycling
#make_custom_recipes.py -t fusion -c --xp=15.0 \
#    --catalyst='minecraft:items/coals' \
#    -a 'minecraft:golden_helmet;minecraft:gravel' 'minecraft:gold_ore' 1
# cut & paste & edit the rest of gold recycling....
# skip leather & wood recycling, they make no sense.

# stone recycling
make_custom_recipes.py -t fusion -c --xp=5.0 \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:stone_sword;minecraft:gravel' 'minecraft:stone' 1
# cut & paste & edit the rest of stone recycling....

# iron recycling
make_custom_recipes.py -t fusion -c --xp=10.0 \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:iron_helmet;minecraft:gravel' 'minecraft:iron_ore' 1
# cut & paste & edit the rest of iron recycling....

# diamond recycling
make_custom_recipes.py -t fusion -c --xp=20.0 \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:diamond_helmet;minecraft:gravel' 'minecraft:diamond_ore' 1
# cut & paste & edit the rest of diamond recycling....

# copper recycling
make_custom_recipes.py -t fusion -c --xp=10.0 \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:copper_helmet;minecraft:gravel' 'simpleores:copper_ore' 1
# cut & paste & edit the rest

# tin recycling
make_custom_recipes.py -t fusion -c --xp=10.0 \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:tin_helmet;minecraft:gravel' 'simpleores:tin_ore' 1
# cut & paste & edit the rest


