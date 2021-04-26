package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BrutoClassResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BrutoClassController {

    private final BrutoClassService brutoClassService;

    public BrutoClassController(BrutoClassService brutoClassService) {
        this.brutoClassService = brutoClassService;
    }

    @GetMapping(value="/api/brutoclass/all")
    @ResponseBody
    public List<BrutoClassResponse> allBrutoClass() {
        return this.brutoClassService.all().stream()
                .map(BrutoClassResponse::new)
                .collect(Collectors.toList());
    }
}
