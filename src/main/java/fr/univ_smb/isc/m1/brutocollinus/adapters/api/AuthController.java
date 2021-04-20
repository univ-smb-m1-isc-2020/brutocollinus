package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.LoginForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.RegisterForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.PlayerResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class AuthController {

    private final PlayerService playerService;

    public AuthController(PlayerService playerService) {
        this.playerService = playerService;
    }

    private PlayerResponse meResponseWithLinks(Player player) {
        PlayerResponse response = new PlayerResponse(player);

        String uuid = player.uuid();
        Link allBruto = linkTo(methodOn(MeController.class).allBruto(uuid)).withRel("all_bruto");
        Link createBruto = linkTo(methodOn(MeController.class).createBruto(uuid, null)).withRel("create_bruto");
        response.add(allBruto, createBruto);

        return response;
    }

    @PostMapping(value="/api/player/register")
    @ResponseBody
    public PlayerResponse register(@RequestBody @Valid RegisterForm form) {
        Player player = this.playerService.create(form.name, form.email, form.password);
        return this.meResponseWithLinks(player);
    }

    @PostMapping(value="/api/player/login")
    @ResponseBody
    public PlayerResponse register(@RequestBody @Valid LoginForm form) {
        Optional<Player> player = this.playerService.findByEmailAndPassword(form.email, form.password);
        if (player.isPresent()) {
            return this.meResponseWithLinks(player.get());
        }

        return null;
    }

}
