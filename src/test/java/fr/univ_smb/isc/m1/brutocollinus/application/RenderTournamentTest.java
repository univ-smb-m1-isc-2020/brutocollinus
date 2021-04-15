package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.RenderedTournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
class RenderTournamentTest {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private BrutoClassService brutoClassService;
    @Autowired
    private ArmedBrutoService armedBrutoService;
    private BrutoClass assassinClass;

    @BeforeEach
    void setup() {
        this.assassinClass = this.brutoClassService.findByName("assassin");
    }

    @Test
    void render5PlayersTournament() {
        List<ArmedBruto> participants = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            Bruto bruto = new Bruto("Energy_" + i, this.assassinClass, null);
            ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new ArrayList<>(), new ArrayList<>());
            participants.add(armedBruto);
        }

        Tournament tournament = this.tournamentService.create("tournoi", participants);

        RenderedTournament renderedTournament = new RenderedTournament(tournament);

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.setPrettyPrinting().create();

        final String render = gson.toJson(renderedTournament);
        System.out.println(render);
    }
}
