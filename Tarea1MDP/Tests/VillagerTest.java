import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VillagerTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private CavalryUnit cunit;
    private SiegeUnit sunit;
    private Villager vunit;
    private Villager vunit2;
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
        vunit2=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void damage() {
        //tests a villager can damage a CavalryUnit.
        double cavInitialhp=cunit.getHitPoints();
        vunit.damage(cunit);
        assertTrue(cunit.getHitPoints()<cavInitialhp);

        //tests a villager can repair a damaged Barrack.
        sunit.damage(barrack);
        double barrInitialhp=barrack.getHitPoints();
        vunit.damage(barrack);
        assertTrue(barrack.getHitPoints()>barrInitialhp);

        //tests a villager can't overheal a Castle.
        double castleInitialhp=castle.getHitPoints();
        vunit.damage(castle);
        assertFalse(castle.getHitPoints()>castleInitialhp);

        //tests a villager can over heal a SiegeUnit.
        double siegeInitial=sunit.getHitPoints();
        vunit.damage(sunit);
        assertTrue(sunit.getHitPoints()>siegeInitial);

    }

    @Test
    public void dmgCastle() {
        //tests a villager takes damage from a Castle.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgCastle(castle);
        assertTrue(vunit.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests a villager takes damage from an InfantryUnit.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgInfantryUnit(iunit);
        assertTrue(vunit.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests a villager takes damage from an ArcherUnit.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgArcherUnit(aunit);
        assertTrue(vunit.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests a villager takes damage from a CavalryUnit.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgCavalryUnit(cunit);
        assertTrue(vunit.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests a villager takes damage from a SiegeUnit.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgSiegeUnit(sunit);
        assertTrue(vunit.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgVillager() {
        //tests a villager takes damage from a Villager.
        double villaInitialhp=vunit2.getHitPoints();
        vunit2.dmgVillager(vunit);
        assertTrue(vunit2.getHitPoints()<villaInitialhp);
    }

    @Test
    public void dmgMonk() {
        //tests a monk can heal a villager.
        double villaInitialhp=vunit.getHitPoints();
        vunit.dmgMonk(monk);
        assertTrue(vunit.getHitPoints()>villaInitialhp);
    }
}