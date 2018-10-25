/**
 *
 * ArcherUnit.java
 *
 * Class that extends the Unit abstract class's methods. An ArcherUnit object behaves like a Unit.
 * Recieves damage from any attack and can be healed by a Monk
 *
 * @author German Martinez
 */
public class ArcherUnit extends Unit {

    public ArcherUnit(double hp, double ap){
        super(hp,ap);
    }
    public void damage(Attackable entity){
        if(this.isAlive()) {
            entity.dmgArcherUnit(this);
        }
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(castle.getAttackPoints()*-1.2);
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(iunit.getAttackPoints()*-1.2);
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(aunit.getAttackPoints()*-1.2);
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
