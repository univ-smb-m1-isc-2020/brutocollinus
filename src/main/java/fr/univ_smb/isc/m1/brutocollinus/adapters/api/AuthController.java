package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.RegisterForm;
import fr.univ_smb.isc.m1.brutocollinus.application.ChuckFactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class AuthController {

    private final ChuckFactsService chuckFactsService;

    public AuthController(ChuckFactsService chuckFactsService) {
        this.chuckFactsService = chuckFactsService;
    }

    @PostMapping(value="/api/player/register")
    public void register(@RequestBody @Valid RegisterForm form) {
        System.out.println(form.getLogin());
        System.out.println(form.getPassword());
    }

}
