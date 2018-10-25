import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfantryUnitTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private InfantryUnit iunit2;
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
        iunit2=new InfantryUnit(100,20);
        castle=new Castle(200,6);
        cunit=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void damage() {
        //tests if an infantry unit can damage a CavalryUnit.
        double cavInitialhp = cunit.getHitPoints();
        iunit.damage(cunit);
        assertTrue(cunit.getHitPoints() < cavInitialhp);

        //tests if an infantry unit can damage a Barrack.
        double barrInitialhp = barrack.getHitPoints();
        iunit.damage(barrack);
        assertTrue(barrack.getHitPoints() < barrInitialhp);
    }

    @Test
    public void dmgCastle() {
        //tests if an infantry unit takes damage from a Castle.
        double initialhp=iunit.getHitPoints();
        iunit.dmgCastle(castle);
        assertTrue(iunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests if an infantry unit takes damage from an InfantryUnit.
        double initialhp=iunit2.getHitPoints();
        iunit2.dmgInfantryUnit(iunit);
        assertTrue(iunit2.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests if an infantry unit takes damage from an ArcherUnit.
        double initialhp=iunit.getHitPoints();
        iunit.dmgArcherUnit(aunit);
        assertTrue(iunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests if an infantry unit takes damage from a CavalryUnit.
        double initialhp=iunit.getHitPoints();
        iunit.dmgCavalryUnit(cunit);
        assertTrue(iunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests if an infantry unit takes damage from a SiegeUnit.
        double initialhp=iunit.getHitPoints();
        iunit.dmgSiegeUnit(sunit);
        assertTrue(iunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests if an infantry unit takes damage from a Villager.
        double initialhp=iunit.getHitPoints();
        iunit.dmgVillager(vunit);
        assertTrue(iunit.getHitPoints()<initialhp);
    }

    @Test
    public void dmgMonk() {
        //tests an infantry unit recieves heals from a Monk.
        double initialHP=iunit.getHitPoints();
        iunit.dmgMonk(monk);
        assertTrue(iunit.getHitPoints()>initialHP);
    }
}