import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArcherUnitTest {
    private Monk monk;
    private ArcherUnit aunit;
    private ArcherUnit aunit2;
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
        aunit2=new ArcherUnit(70,25);
        iunit=new InfantryUnit(100,20);
        castle=new Castle(200,6);
        cunit=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void damage() {
        //tests if an archer unit can damage a CavalryUnit.
        double cavInitialhp = cunit.getHitPoints();
        aunit.damage(cunit);
        assertTrue(cunit.getHitPoints() < cavInitialhp);

        //tests if an archen unit can damage a Barrack.
        double barrInitialhp = barrack.getHitPoints();
        aunit.damage(barrack);
        assertTrue(barrack.getHitPoints() < barrInitialhp);
    }

    @Test
    public void dmgCastle() {
        //tests if an archer unit takes damage from a Castle.
        double initialhp=aunit.getHitPoints();
        aunit.dmgCastle(castle);
        assertTrue(aunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests if an archer unit takes damage from an InfantryUnit.
        double initialhp=aunit.getHitPoints();
        aunit.dmgInfantryUnit(iunit);
        assertTrue(aunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests if an archer unit takes damage from an ArcherUnit.
        double initialhp=aunit2.getHitPoints();
        aunit2.dmgArcherUnit(aunit);
        assertTrue(aunit2.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests if an archer unit takes damage from a CavalryUnit.
        double initialhp=aunit.getHitPoints();
        aunit.dmgCavalryUnit(cunit);
        assertTrue(aunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests if an archer unit takes damage from a SiegeUnit.
        double initialhp=aunit.getHitPoints();
        aunit.dmgSiegeUnit(sunit);
        assertTrue(aunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests if an archer unit takes damage from a Villager.
        double initialhp=aunit.getHitPoints();
        aunit.dmgVillager(vunit);
        assertTrue(aunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgMonk() {
        //tests an archer unit recieves heals from a Monk.
        double initialHP=aunit.getHitPoints();
        aunit.dmgMonk(monk);
        assertTrue(aunit.getHitPoints()>initialHP);
    }
}