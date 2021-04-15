package fr.univ_smb.isc.m1.brutocollinus.application.tdd;

import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.StuffService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.application.BoostService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
class CreateArmedBrutoTest {
    @Autowired
    private ArmedBrutoService armedBrutoService;
    @Autowired
    private BrutoClassService brutoClassService;
    @Autowired
    private StuffService stuffService;
    @Autowired
    private BoostService boostService;

    private BrutoClass assassinClass;
    private Bruto bruto;
    private Stuff bow;
    private Stuff sword;
    private Stuff shield;
    private Boost benediction;

    @BeforeEach
    public void setup() {
        this.assassinClass = this.brutoClassService.findByName("assassin");
        this.bruto = new Bruto("energy", this.assassinClass, null);

        this.bow = this.stuffService.findByName("bow");
        this.sword = this.stuffService.findByName("sword");
        this.shield = this.stuffService.findByName("shield");

        this.benediction = this.boostService.findByName("benediction");
    }

    @Test
    void createNoEquipementArmedBruto() {
        ArmedBruto armedBruto = this.armedBrutoService.create(this.bruto, new ArrayList<>(), new ArrayList<>());

        assertEquals(0, armedBruto.stuffs().size());
        assertEquals(0, armedBruto.boosts().size());

        FightStatisticsVector statistics = this.armedBrutoService.totalStatistics(armedBruto);
        assertEquals(this.assassinClass.fightStatistics().atk(), statistics.atk());
        assertEquals(this.assassinClass.fightStatistics().hp(), statistics.hp());
        assertEquals(this.assassinClass.fightStatistics().ini(), statistics.ini());
    }

    @Test
    void createArmedBrutoWithBowAndShield() {
        List<Stuff> stuffs = Arrays.asList(this.bow, this.shield);
        ArmedBruto armedBruto = this.armedBrutoService.create(this.bruto, stuffs, new ArrayList<Boost>());

        assertEquals(2, armedBruto.stuffs().size());
        assertEquals(0, armedBruto.boosts().size());

        FightStatisticsVector statistics = this.armedBrutoService.totalStatistics(armedBruto);
        assertEquals(this.assassinClass.fightStatistics().atk() +
                    this.bow.fightStatistics().atk() +
                    this.shield.fightStatistics().atk(), statistics.atk());

        assertEquals(this.assassinClass.fightStatistics().atk() +
                this.bow.fightStatistics().atk() +
                this.shield.fightStatistics().atk(), statistics.atk());

        assertEquals(this.assassinClass.fightStatistics().atk() +
                this.bow.fightStatistics().atk() +
                this.shield.fightStatistics().atk(), statistics.atk());
    }

    @Test
    void createArmedBrutoWithBowAndBenediction() {
        List<Stuff> stuffs = Arrays.asList(this.bow);
        List<Boost> boosts = Arrays.asList(this.benediction);
        ArmedBruto armedBruto = this.armedBrutoService.create(this.bruto, stuffs, boosts);

        assertEquals(1, armedBruto.stuffs().size());
        assertEquals(1, armedBruto.boosts().size());

        FightStatisticsVector statistics = this.armedBrutoService.totalStatistics(armedBruto);
        assertEquals(this.assassinClass.fightStatistics().atk() +
                this.bow.fightStatistics().atk() +
                this.benediction.fightStatistics().atk(), statistics.atk());

        assertEquals(this.assassinClass.fightStatistics().atk() +
                this.bow.fightStatistics().atk() +
                this.benediction.fightStatistics().atk(), statistics.atk());

        assertEquals(this.assassinClass.fightStatistics().atk() +
                this.bow.fightStatistics().atk() +
                this.benediction.fightStatistics().atk(), statistics.atk());
    }
}
