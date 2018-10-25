/**
 *
 * Building.java
 *
 * Abstract class that implements the Attackable interface class's methods to fit a Building
 * type object that can be attacked.
 *
 * @author German Martinez
 */
public abstract class Building  implements Attackable{

    private double hitPoints;
    private double hp_cap;


    public Building(double hp){
        hitPoints=hp;
        hp_cap=hp;
    }

    public double getHitPoints(){
        return hitPoints;
    }

    public void addHitPoints(double ap){
        hitPoints+= ap;
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
