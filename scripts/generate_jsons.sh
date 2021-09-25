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

# blockstates
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/blockstates
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

gen_blockstate_jsons.py --type=slab bronze_brick_slab 
gen_blockstate_jsons.py --type=slab steel_brick_slab 
gen_blockstate_jsons.py --type=slab sinisite_brick_slab 
gen_blockstate_jsons.py --type=slab thyrium_brick_slab 

# models
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/models
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# block models
gen_model_jsons.py --type=slab bronze_brick_slab
gen_model_jsons.py --type=slab steel_brick_slab
gen_model_jsons.py --type=slab sinisite_brick_slab
gen_model_jsons.py --type=slab thyrium_brick_slab

