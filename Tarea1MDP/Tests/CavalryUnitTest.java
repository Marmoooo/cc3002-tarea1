import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CavalryUnitTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private CavalryUnit cunit;
    private CavalryUnit cunit2;
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
        cunit2=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void damage() {
        //tests if a cavalry unit can damage an InfantryUnit.
        double infInitialhp = iunit.getHitPoints();
        cunit.damage(iunit);
        assertTrue(iunit.getHitPoints() < infInitialhp);

        //tests if a cavalry unit can damage a Barrack.
        double barrInitialhp = barrack.getHitPoints();
        cunit.damage(barrack);
        assertTrue(barrack.getHitPoints() < barrInitialhp);
    }

    @Test
    public void dmgCastle() {
        //tests a cavalry taking damage from a Castle.
        double initialhp=cunit.getHitPoints();
        cunit.dmgCastle(castle);
        assertTrue(cunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests a cavalry taking damage from an InfantryUnit.
        double initialhp=cunit.getHitPoints();
        cunit.dmgInfantryUnit(iunit);
        assertTrue(cunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests a cavalry taking damage from an ArcherUnit.
        double initialhp=cunit.getHitPoints();
        cunit.dmgArcherUnit(aunit);
        assertTrue(cunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests a cavalry taking damage from a CavalryUnit.
        double initialhp=cunit2.getHitPoints();
        cunit2.dmgCavalryUnit(cunit);
        assertTrue(cunit2.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests a cavalry taking damage from a SiegeUnit.
        double initialhp=cunit.getHitPoints();
        cunit.dmgSiegeUnit(sunit);
        assertTrue(cunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests a cavalry taking damage from a Villager.
        double initialhp=cunit.getHitPoints();
        cunit.dmgVillager(vunit);
        assertTrue(cunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgMonk() {
        //tests if a cavalry unit recieves heals from a Monk.
        double initialHP=cunit.getHitPoints();
        cunit.dmgMonk(monk);
        assertTrue(iunit.getHitPoints()>initialHP);
    }
}