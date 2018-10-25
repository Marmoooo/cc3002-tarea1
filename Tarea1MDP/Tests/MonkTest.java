import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonkTest {
    private Monk monk;
    private Monk monk2;
    private ArcherUnit aunit;
    private InfantryUnit iunit;
    private Castle castle;
    private CavalryUnit cunit;
    private SiegeUnit sunit;
    private Villager vunit;
    private Villager vunit2;

    @Before
    public void setUp() throws Exception {
        monk=new Monk(100,10);
        monk2=new Monk(100,10);
        aunit=new ArcherUnit(70,25);
        iunit=new InfantryUnit(100,20);
        castle=new Castle(200,6);
        cunit=new CavalryUnit(80,25);
        sunit=new SiegeUnit(150,25);
        vunit=new Villager(50,10);
        vunit2=new Villager(5,10);
    }

    @Test
    public void damage() {
        //tests that monk doesn't damage a SiegeUnit.
        double siegeExpectedhp=sunit.getHitPoints();
        monk.damage(sunit);
        assertTrue(sunit.getHitPoints()==siegeExpectedhp);

        //tests that monk doesn't damage a Castle.
        double castExpectedhp=castle.getHitPoints();
        monk.damage(castle);
        assertTrue(castle.getHitPoints()==castExpectedhp);

        //tests that monk can overheal an InfantryUnit.
        double infInitialhp=iunit.getHitPoints();
        monk.damage(iunit);
        assertTrue(iunit.getHitPoints()>infInitialhp);

        //tests that monk heals a CavalryUnit.
        castle.damage(cunit);
        double cavExpectedhp = cunit.getHitPoints()+monk.getAttackPoints()*0.5;
        monk.damage(cunit);
        monk.damage(cunit);
        assertTrue(cunit.getHitPoints()>cavExpectedhp);

        //tests that a monk can't heal a villager with 0 hp.
        sunit.damage(vunit);
        sunit.damage(vunit);
        monk.damage(vunit);
        assertTrue(vunit.getHitPoints()==0);

        //tests that a monk cant heal past the hp cap.
        monk.damage(vunit2);
        double maxVillagerhp=vunit2.getHitPoints();
        monk.damage(vunit2);
        assertFalse(vunit2.getHitPoints()>maxVillagerhp);

        //tests a dead monk cant heal an ArcherUnit.
        castle.damage(monk);
        double archExpectedhp=aunit.getHitPoints();
        monk.damage(aunit);
        assertTrue(aunit.getHitPoints()==archExpectedhp);


    }

    @Test
    public void dmgCastle() {
        //tests monk dies after it is attacked by a Castle.
        monk.dmgCastle(castle);
        assertFalse(monk.isAlive());
    }

    @Test
    public void dmgInfantryUnit() {
        //tests monk dies after it is attacked by an InfantryUnit.
        monk.dmgInfantryUnit(iunit);
        assertFalse(monk.isAlive());
    }

    @Test
    public void dmgArcherUnit() {
        //tests monk dies after it is attacked by an ArcherUnit.
        monk.dmgArcherUnit(aunit);
        assertFalse(monk.isAlive());
    }

    @Test
    public void dmgCavalryUnit() {
        //tests monk dies after it is attacked by a CavalryUnit.
        monk.dmgCavalryUnit(cunit);
        assertFalse(monk.isAlive());
    }

    @Test
    public void dmgSiegeUnit() {
        //tests monk dies after it is attacked by a SiegeUnit.
        monk.dmgSiegeUnit(sunit);
        assertFalse(monk.isAlive());
    }

    @Test
    public void dmgVillager() {
        //tests monk doesn't take damage from a Villager's attack.
        double monkInitialhp=monk.getHitPoints();
        monk.dmgVillager(vunit);
        assertTrue(monk.getHitPoints()==monkInitialhp);
    }

    @Test
    public void dmgMonk() {
        //tests monk can heal another monk2.
        double monk2Initialhp=monk2.getHitPoints();
        monk2.dmgMonk(monk);
        assertTrue(monk2.getHitPoints()>monk2Initialhp);
    }
}