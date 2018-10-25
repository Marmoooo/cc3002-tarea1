import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTest {
    private Barrack barrack1;
    private Barrack barrack2;
    private Barrack barrack3;
    private SiegeUnit sunit;

    @Before
    public void setUp() throws Exception {
        barrack1=new Barrack(150);
        barrack2=new Barrack(0);
        barrack3=new Barrack(10);
        sunit=new SiegeUnit(150,25);
    }

    @Test
    public void getHitPoints() {
        //tests if the returned hit points are congruent with the initial value.
        double initialValue=150;
        assertTrue(barrack1.getHitPoints()==initialValue);
    }

    @Test
    public void addHitPoints() {
        //tests if the difference between the initial hit points and the actual hitpoints is the added hit points.
        sunit.damage(barrack3);
        double initialValue=barrack3.getHitPoints();
        barrack3.addHitPoints(10);
        assertTrue(barrack3.getHitPoints()==initialValue+10);
    }

    @Test
    public void isAlive() {
        //tests if the unit is dead, by checking if the hit points are above 0.
        assertFalse(barrack2.isAlive());
    }
}