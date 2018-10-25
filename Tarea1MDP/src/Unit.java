/**
 *
 * Unit.java
 *
 * Abstract class that implements the methods from the Attacker interface class to fit a
 * Unit type object that can attack and be attacked.
 *
 * @author German Martinez
 */
public abstract class Unit implements Attacker{

    private double hitPoints;
    private double attackPoints;
    private double hp_cap;

    public Unit(double hp, double ap){
        hitPoints=hp;
        attackPoints=ap;
        hp_cap=hp*1.5;
    }

    public double getHitPoints(){
        return hitPoints;
    }

    public double getAttackPoints(){
        return attackPoints;
    }

    public void addHitPoints(double ap){
        if(hitPoints>0) {
            hitPoints += ap;
        }
        if(hitPoints<0){
            hitPoints=0;
        }else if(hitPoints>hp_cap){
            hitPoints=hp_cap;
        }
    }

    public boolean isAlive(){
        return hitPoints>0;
    }

}
