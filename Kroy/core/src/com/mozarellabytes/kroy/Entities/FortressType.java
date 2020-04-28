package com.mozarellabytes.kroy.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * FortressType is an enum defining the fortresses that can be present in the game.
 * Each fortress type has a unique name, delay between firing bombs, attack range,
 * maximum health points, attack points, width, height and sprite.
 * This allows there to be numerous different types of fortresses without having
 * to randomly generate values which may make the game unplayable in some instances
 * and too easy in other instances.
 */

public enum FortressType {

    /** The preset values for the different fortress types includes the type's:
     * name, delay between firing bombs, attack range, maximum health points,
     * attack points, width, height and sprite.
     */
    Revs ("Revolution", 1500, 7, 100, 5, 5, 3,
            new Texture(Gdx.files.internal("sprites/fortress/fortress_revs_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_revs_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_revs_dead.png"))),

    Walmgate ("Walmgate Bar", 1000, 8, 125, 8, 5, 5,
            new Texture(Gdx.files.internal("sprites/fortress/fortress_walmgate_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_walmgate_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_walmgate_dead.png"))),

    Clifford ("Clifford's Tower", 500, 7, 125, 8, 4, 3,
            new Texture(Gdx.files.internal("sprites/fortress/fortress_clifford_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_clifford_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_clifford_dead.png"))),

    CentralHall ("Central Hall", 500, 7, 150, 12, 4, 3,
            new Texture(Gdx.files.internal("sprites/fortress/UoY_central_hall_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/UoY_central_hall_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/UoY_central_hall_dead.png"))),

    Museum ("York Museum", 1500, 8, 150, 12, 4, 3,
            new Texture(Gdx.files.internal("sprites/fortress/fortress_yorkshire_museum_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_yorkshire_museum_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/fortress_yorkshire_museum_dead.png"))),
    
    Railway ("Railway Museum", 1000, 8, 100, 8, 5, 4,
            new Texture(Gdx.files.internal("sprites/fortress/york_railway_museum_full.png")),
            new Texture(Gdx.files.internal("sprites/fortress/york_railway_museum_half.png")),
            new Texture(Gdx.files.internal("sprites/fortress/york_railway_museum_dead.png")));

    /** The name for the fortress, visible once the fortress has been clicked on */
    private final String name;

    /** The time between firing bombs */
    private final int delay;

    /** The range that the fortress can see and attack firetrucks */
    private final float range;

    /** The maximum health points for the fortress - always 100 */
    private final float maxHP;

    /** Attack points - how much damage the fortress can inflict */
    private final float AP;

    /** The width of the sprite measured in tiles */
    private final int w;

    /** The height of the sprite measured in tiles */
    private final int h;

    /** The sprite for the fortress */
    private final Texture textureFull, textureHalf, textureDead;

    /**
     * Constructs the FortressType
     *
     * @param name The name for this type of fortress
     * @param delay The delay between firing bombs in milliseconds
     * @param range The attack range for this type of fortress in tiles
     * @param maxHP The maximum health points for this type of fortress
     * @param AP The attack points for this type of fortress
     * @param w The width of the sprite for this type of fortress in tiles
     * @param h The height of the sprite for this type of fortress in tiles
     * @param textureFull The sprite for this type of fortress at full hp
     * @param textureHalf The sprite for this type of fortress below half hp
     * @param textureDead The sprite for this type of fortress when it is dead
     */
    FortressType(String name, int delay, float range, float maxHP, float AP, int w, int h, Texture textureFull, Texture textureHalf, Texture textureDead) {
        this.name = name;
        this.delay = delay;
        this.range = range;
        this.maxHP = maxHP;
        this.AP = AP;
        this.w = w;
        this.h = h;
        this.textureFull = textureFull; // full hp
        this.textureHalf =  textureHalf; // half hp
        this.textureDead =  textureDead; // dead
    }

    public String getName() { return name; }

    public int getDelay() { return delay; }

    public float getRange() { return range; }

    public float getMaxHP() { return maxHP; }

    public float getAP() { return AP; }

    public int getW() { return w; }

    public int getH() { return h; }

    public Texture getTexture(float currentHP) {
        if (currentHP > getMaxHP()/2){
            return textureFull;
        } else if (currentHP > 0){
            return textureHalf;
        } else {
            return textureDead;
        }
        //return textureFull;
        }

}
