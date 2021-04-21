package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.MeCreateBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.MeCreateBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class DebugController {

    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final BrutoClassService brutoClassService;
    private final TournamentService tournamentService;
    private final ArmedBrutoService armedBrutoService;

    public DebugController(BrutoService brutoService, PlayerService playerService, BrutoClassService brutoClassService,
                           TournamentService tournamentService, ArmedBrutoService armedBrutoService) {
        this.brutoService = brutoService;
        this.playerService = playerService;
        this.brutoClassService = brutoClassService;
        this.tournamentService = tournamentService;
        this.armedBrutoService = armedBrutoService;
    }

    private ArmedBruto createArmedBruto(String playeName, String brutoName) {
        Player me = this.playerService.create(playeName, "toto@gmail.com", "roo");
        BrutoClass assassin = this.brutoClassService.findByName("assassin");
        Bruto bruto = this.brutoService.create(brutoName, assassin, me);
        ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new ArrayList<>());
        return armedBruto;
    }

    @PostMapping(value="/api/debug/tournament/create")
    public void createTournament() {
        ArmedBruto b1 = this.createArmedBruto("toto", "billy");
        ArmedBruto b2 = this.createArmedBruto("tata", "bouboul");

        Tournament tournament = this.tournamentService.create("la finale", Set.of(b1, b2));
    }
}
