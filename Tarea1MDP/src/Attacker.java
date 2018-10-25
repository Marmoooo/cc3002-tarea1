/**
 *
 * Attacker.java
 *
 * Interface class that extends the Attackable interface class adding specific methods to replicate
 * an oject that can be attacked and also has the ability to attack other object.
 *
 * @author German Martinez
 */
public interface Attacker extends Attackable {

    /**
     * Returns the number of attack points the Attacker object has. This determines
     * the amount of damage the Attacker object can inflict on another object.
     *
     * @return attackPoints the damage an Attacker object can deal to another Attackable object's hit points.
     */
    double getAttackPoints();

    /**
     * Relays the information of who is attacking to the entity being attacked. Then the entity knows what
     * operations to apply to the Attacker's attack points to then add them onto the entity's own hit points.
     * The attack only goes through succesfully if the Attacking object that used the method is alive, determined
     * by the isAlive method in the Attackable interface. Also, the entity attacked has their hit point capacity
     * increased by the improveHPCap method in the Attackable interface if it remains alive and the attack is harmful.
     *
     * @param entity  the Attackable object being attacked.
     */
    void damage(Attackable entity);

}
