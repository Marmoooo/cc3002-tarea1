import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarrackTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private CavalryUnit cunit;
    private SiegeUnit sunit;
    private Villager vunit;
    private Barrack barrack;

    @Before
    public void setUp() throws Exception {
        monk=new Monk(100,10);
        aunit=new ArcherUnit(70,25);
        iunit=new InfantryUnit(100,20);
        castle=new Castle(200,6);
        cunit=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void dmgCastle() {
        //tests if a barrack takes damage from a Castle.
        double initialhp=barrack.getHitPoints();
        barrack.dmgCastle(castle);
        assertTrue(barrack.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests if a barrack takes damage from an InfantryUnit.
        double initialhp=barrack.getHitPoints();
        barrack.dmgInfantryUnit(iunit);
        assertTrue(barrack.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests if a barrack takes damage from an ArcherUnit.
        double initialhp=barrack.getHitPoints();
        barrack.dmgArcherUnit(aunit);
        assertTrue(barrack.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests if a barrack takes damage from a CavalryUnit.
        double initialhp=barrack.getHitPoints();
        barrack.dmgCavalryUnit(cunit);
        assertTrue(barrack.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests if a barrack takes damage from a SiegeUnit.
        double initialhp=barrack.getHitPoints();
        barrack.dmgSiegeUnit(sunit);
        assertTrue(barrack.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests if a barrack can be healed by a Villager past the hp cap.
        double initialhp=barrack.getHitPoints();
        barrack.dmgVillager(vunit);
        assertFalse(barrack.getHitPoints()>initialhp);

        //tests if a castle can be healed by a Villager.
        sunit.damage(barrack);
        double initialhp2=barrack.getHitPoints();
        barrack.dmgVillager(vunit);
        assertTrue(barrack.getHitPoints()>initialhp2);
    }

    @Test
    public void dmgMonk() {
        //tests if a barrack doesn't take damage from a Monk.
        double initialHP=barrack.getHitPoints();
        barrack.dmgMonk(monk);
        assertTrue(barrack.getHitPoints()==initialHP);
    }
}