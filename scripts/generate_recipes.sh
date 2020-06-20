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
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_golden_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:golden_helmet;minecraft:gravel' 'minecraft:gold_ore' 1
# cut & paste & edit the rest of gold recycling....
# skip leather & wood recycling, they make no sense.

# stone recycling
make_custom_recipes.py -t fusion -f 'recycle_stone_sword' -c --xp=5.0 \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:stone_sword;minecraft:gravel' 'minecraft:stone' 1
# cut & paste & edit the rest of stone recycling....

# iron recycling
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_iron_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:iron_helmet;minecraft:gravel' 'minecraft:iron_ore' 1
# cut & paste & edit the rest of iron recycling....

# diamond recycling
make_custom_recipes.py -t fusion -c --xp=20.0 -f 'recycle_diamond_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'minecraft:diamond_helmet;minecraft:gravel' 'minecraft:diamond_ore' 1
# cut & paste & edit the rest of diamond recycling....

# copper recycling
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_copper_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:copper_helmet;minecraft:gravel' 'simpleores:copper_ore' 1
# cut & paste & edit the rest

# tin recycling
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_tin_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:tin_helmet;minecraft:gravel' 'simpleores:tin_ore' 1
# cut & paste & edit the rest

# mythril recycling
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_mythril_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:mythril_helmet;minecraft:gravel' 'simpleores:mythril_ore' 1
# cut & paste & edit the rest

# recycle your adamantium
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_adamantium_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:adamantium_helmet;minecraft:gravel' 'simpleores:adamantium_ore' 1
# cut & paste & edit the rest

# recycle your onyx
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_onyx_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'simpleores:onyx_helmet;minecraft:gravel' 'simpleores:onyx_ore' 1
# cut & paste & edit the rest

# recycle your bronze
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_bronze_helmet' \
    --catalyst='minecraft:items/coals' \
    -a 'fusion:bronze_helmet;minecraft:gravel' 'fusion:large_bronze_chunk' 1
# cut & paste & edit the rest

# recycle your thyrium
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_thyrium_helmet' \
    --catalyst='minecraft:lava_bucket' \
    -a 'fusion:thyrium_helmet;minecraft:gravel' 'fusion:large_thyrium_chunk' 1
# cut & paste & edit the rest

# recycle your sinisite
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_sinisite_helmet' \
    --catalyst='minecraft:lava_bucket' \
    -a 'fusion:sinisite_helmet;minecraft:netherrack' 'fusion:large_sinisite_chunk' 1
# cut & paste & edit the rest

# recycle your malachite
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_malachite_helmet' \
    --catalyst='minecraft:quartz' \
    -a 'netherrocks:malachite_helmet;minecraft:netherrack' 'netherrocks:malachite_ore' 1
# cut & paste & edit the rest

# recycle your ashstone
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_ashstone_pickaxe' \
    --catalyst='minecraft:quartz' \
    -a 'netherrocks:ashstone_pickaxe;minecraft:netherrack' 'netherrocks:ashstone_ore' 1
# cut & paste & edit the rest

# recycle your dragonstone
make_custom_recipes.py -t fusion -c --xp=20.0 -f 'recycle_dragonstone_helmet' \
    --catalyst='minecraft:lava_bucket' \
    -a 'netherrocks:dragonstone_helmet;minecraft:netherrack' 'netherrocks:dragonstone_ore' 1
# cut & paste & edit the rest

# recycle your argonite
make_custom_recipes.py -t fusion -c --xp=15.0 -f 'recycle_argonite_pickaxe' \
    --catalyst='minecraft:quartz' \
    -a 'netherrocks:argonite_pickaxe;minecraft:netherrack' 'netherrocks:argonite_ore' 1
# cut & paste & edit the rest

# recycle your fyrite 
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_fyrite_helmet' \
    --catalyst='minecraft:quartz' \
    -a 'netherrocks:fyrite_helmet;minecraft:netherrack' 'netherrocks:fyrite_ore' 1
# cut & paste & edit the rest

# recycle your illumenite
make_custom_recipes.py -t fusion -c --xp=10.0 -f 'recycle_illumenite_helmet' \
    --catalyst='minecraft:glowstone_dust' \
    -a 'netherrocks:illumenite_helmet;minecraft:netherrack' 'netherrocks:illumenite_ore' 1
# cut & paste & edit the rest
