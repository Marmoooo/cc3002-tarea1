/**
 *
 * SiegeUnit.java
 *
 * Class that extends the Unit abstract class's methods. A SiegeUnit object behaves like a Unit.
 * Recieves damage from any attack, except from Villagers. Villagers repair the SiegeUnit
 * increasing it's hit points.
 * Resistant to Castles and ArcherUnits.
 *
 * @author German Martinez
 */
public class SiegeUnit extends  Unit {

    public SiegeUnit(double hp, double ap){
        super(hp,ap);
    }

    public void damage(Attackable entity){
        if(this.isAlive()) {
            entity.dmgSiegeUnit(this);
        }
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(castle.getAttackPoints()*-0.5);
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(iunit.getAttackPoints()*-1.2);
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(aunit.getAttackPoints()*-0.8);
    }

    public void dmgCavalryUnit(CavalryUnit cunit){
        this.addHitPoints(cunit.getAttackPoints()*-1.2);
    }

    public void dmgSiegeUnit(SiegeUnit sunit){
        this.addHitPoints(sunit.getAttackPoints()*-1.5);
    }

    public void dmgVillager(Villager vunit){
        this.addHitPoints(vunit.getAttackPoints()*0.5);
    }

    public void dmgMonk(Monk munit){
    }
}
