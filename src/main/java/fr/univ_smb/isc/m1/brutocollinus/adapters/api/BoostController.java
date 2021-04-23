package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BoostResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.BoostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BoostController {

    private final BoostService boostService;

    public BoostController(BoostService boostService) {
        this.boostService = boostService;
    }

    @GetMapping(value="/api/boost/all")
    @ResponseBody
    public List<BoostResponse> allBoost() {
        return this.boostService.all().stream()
                .map(BoostResponse::new)
                .collect(Collectors.toList());
    }
}
