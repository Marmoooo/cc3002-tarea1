/**
 *
 * Barrack.java
 *
 * Class that extends the Building abstract class's methods. A Barrack object behaves like a Building.
 * Recieves damage from any attack and can be repaired by a Villager.
 * Resistant to Castles, InfantryUnits, ArcherUnits and CavalryUnits.
 *
 * @author German Martinez
 */
public class Barrack extends Building {

    public Barrack(double hp){
        super(hp);
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(castle.getAttackPoints()*-0.7);
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(iunit.getAttackPoints()*-0.7);
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(aunit.getAttackPoints()*-0.7);
    }

    public void dmgCavalryUnit(CavalryUnit cunit){
        this.addHitPoints(cunit.getAttackPoints()*-0.7);
    }

    public void dmgSiegeUnit(SiegeUnit sunit){
        this.addHitPoints(sunit.getAttackPoints()*-2);
    }

    public void dmgVillager(Villager vunit){
        this.addHitPoints(vunit.getAttackPoints()*0.7);
    }

    public void dmgMonk(Monk munit){
    }
}
