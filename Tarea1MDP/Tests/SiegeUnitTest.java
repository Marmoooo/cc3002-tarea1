import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SiegeUnitTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private CavalryUnit cunit;
    private SiegeUnit sunit;
    private SiegeUnit sunit2;
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
        sunit2=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }
    @Test
    public void damage() {
        //tests a siege unit can damage a CavalryUnit.
        double cavInitialhp=cunit.getHitPoints();
        sunit.damage(cunit);
        assertTrue(cunit.getHitPoints()<cavInitialhp);

        //tests a villager can damage a Barrack.
        double barrInitialhp=barrack.getHitPoints();
        sunit.damage(barrack);
        assertTrue(barrack.getHitPoints()<barrInitialhp);
    }

    @Test
    public void dmgCastle() {
        //tests a siege unit takes damage from a Castle.
        double initialhp=sunit.getHitPoints();
        sunit.dmgCastle(castle);
        assertTrue(sunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests a siege unit takes damage from an InfantryUnit.
        double initialhp=sunit.getHitPoints();
        sunit.dmgInfantryUnit(iunit);
        assertTrue(sunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests a siege unit takes damage from an ArcherUnit.
        double initialhp=sunit.getHitPoints();
        sunit.dmgArcherUnit(aunit);
        assertTrue(sunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests a siege unit takes damage from a CavalryUnit.
        double initialhp=sunit.getHitPoints();
        sunit.dmgCavalryUnit(cunit);
        assertTrue(sunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests a siege unit takes damage from a SiegeUnit.
        double initialhp=sunit.getHitPoints();
        sunit.dmgSiegeUnit(sunit2);
        assertTrue(sunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests a siege unit can be healed by a Villager.
        double initialhp=sunit.getHitPoints();
        sunit.dmgVillager(vunit);
        assertTrue(sunit.getHitPoints()>initialhp);
    }

    @Test
    public void dmgMonk() {
        //tests a siege unit doesn't take damage from a Monk.
        double initialHP=sunit.getHitPoints();
        sunit.dmgMonk(monk);
        assertTrue(sunit.getHitPoints()==initialHP);
    }
}