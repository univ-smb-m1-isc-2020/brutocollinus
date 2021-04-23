package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.ArmedBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmedBrutoController {

    private final ArmedBrutoService armedBrutoService;

    public ArmedBrutoController(ArmedBrutoService armedBrutoService) {
        this.armedBrutoService = armedBrutoService;
    }

    @GetMapping(value="/api/armedbruto/{uuid}")
    @ResponseBody
    public ArmedBrutoResponse get(@PathVariable String uuid) {
        ArmedBruto armedBruto = this.armedBrutoService.get(uuid);
        return new ArmedBrutoResponse(armedBruto);
    }
}
