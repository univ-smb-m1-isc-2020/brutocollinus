package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.SearchPlayerForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.PlayerResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value="/api/player/search")
    @ResponseBody
    public CollectionModel<PlayerResponse> search(@RequestBody @Valid SearchPlayerForm form) {
        List<Player> players = this.playerService.findByTermInName(form.term);

        return CollectionModel.of(players.stream()
                .map(PlayerResponse::new)
                .collect(Collectors.toList()));
    }

}
