import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    private CavalryUnit cunit;
    private InfantryUnit iunit;

    @Before
    public void setUp() throws Exception {
        cunit=new CavalryUnit(80,25);
        iunit=new InfantryUnit(0,20);
    }

    @Test
    public void getHitPoints() {
        //tests if the returned hit points are congruent with the initial value.
        double initialValue=80;
        assertTrue(cunit.getHitPoints()==initialValue);
    }

    @Test
    public void getAttackPoints() {
        //tests if the returned attack points are congruent with the initial value.
        double initialValue=25;
        assertTrue(cunit.getAttackPoints()==initialValue);
    }

    @Test
    public void addHitPoints() {
        //tests if the difference between the initial hit points and the actual hitpoints is the added hit points.
        double initialValue=cunit.getHitPoints();
        cunit.addHitPoints(10);
        assertTrue(cunit.getHitPoints()==initialValue+10);
    }

    @Test
    public void isAlive() {
        //tests if the unit is dead, by checking if the hit points are above 0.
        assertFalse(iunit.isAlive());
    }
}