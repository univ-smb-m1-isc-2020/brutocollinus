package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.StuffResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.StuffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StuffController {

    private final StuffService stuffService;

    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @GetMapping(value="/api/stuff/all")
    @ResponseBody
    public List<StuffResponse> allStuff() {
        List<StuffResponse> responses = this.stuffService.all().stream()
                .map(StuffResponse::new)
                .collect(Collectors.toList());

        return responses;
    }
}
