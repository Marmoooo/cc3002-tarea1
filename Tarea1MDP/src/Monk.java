/**
 *
 * Monk.java
 *
 * Class that extends the Unit abstract class's methods. A Monk object behaves like a Unit.
 * Monk deals no damage to other Units of Buildings.
 * Loses all hit points if it is attacked by anything other than a Villager.
 *
 * @author German Martinez
 */
public class Monk extends Unit {

    public Monk(double hp, double ap){
        super(hp,ap);
    }

    public void damage(Attackable entity){
        if(this.isAlive()) {
            entity.dmgMonk(this);
        }
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(-this.getHitPoints());
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(-this.getHitPoints());
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(-this.getHitPoints());
    }

    public void dmgCavalryUnit(CavalryUnit cunit){
        this.addHitPoints(-this.getHitPoints());
    }

    public void dmgSiegeUnit(SiegeUnit sunit){
        this.addHitPoints(-this.getHitPoints());
    }

    public void dmgVillager(Villager vunit){
    }

    public void dmgMonk(Monk munit){
        this.addHitPoints(munit.getAttackPoints()*0.5);
    }
}
