import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CastleTest {
    private Monk monk;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private Castle castle2;
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
        castle2=new Castle(200,6);
        cunit=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        barrack=new Barrack(150);
    }

    @Test
    public void getAttackPoints() {
        //tests if the attack points returned are the same as initial ones
        double initialap=6;
        double castleap=castle.getAttackPoints();
        assertTrue(initialap==castleap);
    }

    @Test
    public void damage() {
        //tests a castle can damage a CavalryUnit.
        double cavInitialhp=cunit.getHitPoints();
        castle.damage(cunit);
        assertTrue(cunit.getHitPoints()<cavInitialhp);

        //tests a castle can damage a Barrack.
        double barrInitialhp=barrack.getHitPoints();
        castle.damage(barrack);
        assertTrue(barrack.getHitPoints()<barrInitialhp);
    }

    @Test
    public void dmgCastle() {
        //tests if a castle takes damage from a Castle.
        double initialhp=castle2.getHitPoints();
        castle2.dmgCastle(castle);
        assertTrue(castle2.getHitPoints()<initialhp);
    }

    @Test
    public void dmgInfantryUnit() {
        //tests if a castle takes damage from an InfantryUnit.
        double initialhp=castle.getHitPoints();
        castle.dmgInfantryUnit(iunit);
        assertTrue(castle.getHitPoints()<initialhp);
    }

    @Test
    public void dmgArcherUnit() {
        //tests if a castle takes damage from an ArcherUnit.
        double initialhp=castle.getHitPoints();
        castle.dmgArcherUnit(aunit);
        assertTrue(castle.getHitPoints()<initialhp);
    }

    @Test
    public void dmgCavalryUnit() {
        //tests if a castle takes damage from a CavalryUnit.
        double initialhp=castle.getHitPoints();
        castle.dmgCavalryUnit(cunit);
        assertTrue(castle.getHitPoints()<initialhp);
    }

    @Test
    public void dmgSiegeUnit() {
        //tests if a castle takes damage from a SiegeUnit.
        double initialhp=castle.getHitPoints();
        castle.dmgSiegeUnit(sunit);
        assertTrue(castle.getHitPoints()<initialhp);
    }

    @Test
    public void dmgVillager() {
        //tests if a castle can be healed by a Villager past the hp cap.
        double initialhp=castle.getHitPoints();
        castle.dmgVillager(vunit);
        assertFalse(castle.getHitPoints()>initialhp);

        //tests if a castle can be healed by a Villager.
        sunit.damage(castle);
        double initialhp2=castle.getHitPoints();
        castle.dmgVillager(vunit);
        assertTrue(castle.getHitPoints()>initialhp2);
    }

    @Test
    public void dmgMonk() {
        //tests if a castle doesn't take damage from a Monk.
        double initialHP=castle.getHitPoints();
        castle.dmgMonk(monk);
        assertTrue(castle.getHitPoints()==initialHP);
    }
}