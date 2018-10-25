/**
 *
 * Villager.java
 *
 * Class that extends the Unit abstract class's methods. A Villager object behaves like a Unit.
 * Can be healed by a Monk and takes damage from any attacks.
 *
 * @author German Martinez
 */
public class Villager extends Unit {

    public Villager(double hp, double ap){
        super(hp,ap);
    }

    public void damage(Attackable entity){
        if(this.isAlive()) {
            entity.dmgVillager(this);
        }
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(castle.getAttackPoints()*-1.2);
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(iunit.getAttackPoints()*-1.5);
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(aunit.getAttackPoints()*-1.5);
    }

    public void dmgCavalryUnit(CavalryUnit cunit){
        this.addHitPoints(cunit.getAttackPoints()*-1.5);
    }

    public void dmgSiegeUnit(SiegeUnit sunit){
        this.addHitPoints(sunit.getAttackPoints()*-1.5);
    }

    public void dmgVillager(Villager vunit){
        this.addHitPoints(vunit.getAttackPoints()*-1);
    }

    public void dmgMonk(Monk munit){
        this.addHitPoints(munit.getAttackPoints()*0.5);
    }
}
