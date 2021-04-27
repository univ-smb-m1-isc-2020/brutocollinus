package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


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

    private ArmedBruto createArmedBruto(String playerName, String brutoName) {
        Player me = this.playerService.create(playerName, playerName + "@gmail.com", "root");
        BrutoClass assassin = this.brutoClassService.findByName("assassin");
        Bruto bruto = this.brutoService.create(brutoName, assassin, me);
        ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new HashSet<>());
        return armedBruto;
    }

    @PostMapping(value="/api/debug/tournament/create")
    @ResponseBody
    public TournamentResponse createTournament() {
        Set<ArmedBruto> participants = new HashSet<>();

        for (int i = 0; i < 2; ++i) {
            ArmedBruto armedBruto = this.createArmedBruto("toto" + i, "billy" + i);
            participants.add(armedBruto);
        }

        Tournament tournament = this.tournamentService.create("la finale", participants);

        return new TournamentResponse(tournament);
    }
}
