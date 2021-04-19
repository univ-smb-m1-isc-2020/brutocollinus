package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.LoginForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.RegisterForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.PlayerResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AuthController {

    private final PlayerService playerService;

    public AuthController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value="/api/player/register")
    @ResponseBody
    public PlayerResponse register(@RequestBody @Valid RegisterForm form) {
        Player player = this.playerService.create(form.name, form.email, form.password);
        return new PlayerResponse(player);
    }

    @PostMapping(value="/api/player/login")
    @ResponseBody
    public PlayerResponse register(@RequestBody @Valid LoginForm form) {
        Optional<Player> player = this.playerService.findByEmailAndPassword(form.email, form.password);
        if (player.isPresent()) {
            return new PlayerResponse(player.get());
        }

        return null;
    }

}
