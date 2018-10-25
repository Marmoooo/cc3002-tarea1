/**
 *
 * Castle.java
 *
 * Class that extends the Building abstract class and implements the Attacker interface class's
 * methods. A Castle object behaves like a Building that can attack.
 * Recieves damage from any attack and can be repaired by a Villager.
 * Resistant to InfantryUnits, ArcherUnits, CavalryUnits and other Castles.
 *
 * @author German Martinez
 */
public class Castle extends Building implements Attacker{
    private double attackPoints;

    public Castle(double hp, double ap){
        super(hp);
        attackPoints=ap;
    }

    public double getAttackPoints() {
        return attackPoints;
    }


    public void damage(Attackable entity){
        if(this.isAlive()) {
            entity.dmgCastle(this);
        }
    }

    public void dmgCastle(Castle castle){
        this.addHitPoints(castle.getAttackPoints()*-0.1);
    }

    public void dmgInfantryUnit(InfantryUnit iunit){
        this.addHitPoints(iunit.getAttackPoints()*-0.3);
    }

    public void dmgArcherUnit(ArcherUnit aunit){
        this.addHitPoints(aunit.getAttackPoints()*-0.1);
    }

    public void dmgCavalryUnit(CavalryUnit cunit){
        this.addHitPoints(cunit.getAttackPoints()*-0.3);
    }

    public void dmgSiegeUnit(SiegeUnit sunit){
        this.addHitPoints(sunit.getAttackPoints()*-2);
    }

    public void dmgVillager(Villager vunit){
        this.addHitPoints(vunit.getAttackPoints()*0.3);
    }

    public void dmgMonk(Monk munit){
    }
}
