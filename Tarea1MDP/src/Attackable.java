/**
 *
 * Attackable.java
 * Interface class that has the following methods. Thess methods replicate the nature of an object
 * that is susceptible to being attacked.
 *
 * @author German Martinez
 */
public interface Attackable {
    /**
     * Returns the number of hit points the Attackable object has, these can then be used
     * to judge whether or not the Attackable object is allowed to perform actions or allow actions
     * to be performed onto it.
     *
     * @return hitPoints  the current hit points of the Attackable object.
     */
    double getHitPoints();

    /**
     * Modifies the hit points of the Attackable object, adding the parameter ap(attack points) to
     * the current hit points of the Attackable object. The hit points will go up if the parameter ap
     * is positive, and will go down otherwise. They will remain the same if ap=0. This method can only
     * vary the Attackable object's hit points between 0 and the object's maximum hit point capacity. It
     * will not modify hit point values if they are 0.
     *
     * @param ap  the damage or healing recieved based on the attack points of another object.
     */
    void addHitPoints(double ap);

    /**
     * Returns True or False depending if the Attackable object has more than 0 hit points. The returned
     * value is then an indicator that shows if the Attackable object has been destroyed or can keep
     * interacting with other objects.
     *
     * @return hitPoints>0  a truth value to know whether the Attackable object is alive or not.
     */
    boolean isAlive();

    /**
     * Tells the attacked object the amount of damage recieved after being attacked by an InfantryUnit.
     * The damage inflicted on the attacked object is determined by the attack points of the attacking
     * InfantryUnit multiplied by a factor unique to the interaction between these two objects.
     *
     * @param iunit  the InfantryUnit that is attacking the Attackable object that used this method.
     */
    void dmgInfantryUnit(InfantryUnit iunit);

    /**
     * Tells the attacked object the amount of damage recieved after being attacked by an ArcherUnit.
     * The damage inflicted on the attacked object is determined by the attack points of the attacking
     * ArcherUnit multiplied by a factor unique to the interaction between these two objects.
     *
     * @param aunit  the ArcherUnit that is attacking the Attackable object that used this method.
     */
    void dmgArcherUnit(ArcherUnit aunit);

    /**
     * Tells the attacked object the amount of damage recieved after being attacked by a CavalryUnit.
     * The damage inflicted on the attacked object is determined by the attack points of the attacking
     * CavalryUnit multiplied by a factor unique to the interaction between these two objects.
     *
     * @param cunit  the CavalryUnit that is attacking the Attackable object that used this method.
     */
    void dmgCavalryUnit(CavalryUnit cunit);

    /**
     * Tells the attacked object the amount of damage recieved after being attacked by a SiegeUnit.
     * The damage inflicted on the attacked object is determined by the attack points of the attacking
     * SiegeUnit multiplied by a factor unique to the interaction between these two objects.
     *
     * @param sunit  the SiegeUnit that is attacking the Attackable object that used this method.
     */
    void dmgSiegeUnit(SiegeUnit sunit);

    /**
     * Tells the attacked object the amount of damage or healing recieved after being attacked by a Villager.
     * A Villager can heal Buildings if they attack them. The damage or healing inflicted on the attacked object
     * is determined by the attack points of the attacking Villager multiplied by a factor unique to the
     * interaction between these two objects.
     *
     * @param vunit  the Villager that is attacking the Attackable object that used this method.
     */
    void dmgVillager(Villager vunit);

    /**
     * Tells the attacked object the amount of healing recieved after being attacked by a Monk.
     * A Monk heals other Units and inflicts no damage on Buildings. The healing inflicted on the
     * attacked object is determined by the attack points of the attacking Monk multiplied by
     * a factor unique to the interaction between these two objects. The Monk cannot increase a
     * Unit's hit points past the Unit's maximum hit point capacity.
     *
     * @param munit  the Monk that is attacking the Attackable object that used this method.
     */
    void dmgMonk(Monk munit);

    /**
     * Tells the attacked object the amount of damage recieved after being attacked by a Castle.
     * The damage inflicted on the attacked object is determined by the attack points of the attacking
     * Castle multiplied by a factor unique to the interaction between these two objects.
     * @param castle  the Castle that is attacking the Attackable object that used this method.
     */
    void dmgCastle(Castle castle);

}
