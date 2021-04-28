package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.ReequipStuffArmedBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.ArmedBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.StuffService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ArmedBrutoController {

    private final ArmedBrutoService armedBrutoService;
    private final StuffService stuffService;

    public ArmedBrutoController(ArmedBrutoService armedBrutoService, StuffService stuffService) {
        this.armedBrutoService = armedBrutoService;
        this.stuffService = stuffService;
    }

    @GetMapping(value="/api/armedbruto/{uuid}")
    @ResponseBody
    public ArmedBrutoResponse get(@PathVariable String uuid) {
        ArmedBruto armedBruto = this.armedBrutoService.get(uuid);
        return new ArmedBrutoResponse(armedBruto);
    }

    @PostMapping(value="/api/armedbruto/{uuid}/reequip")
    @ResponseBody
    public ArmedBrutoResponse reequip(@PathVariable String uuid, @RequestBody @Valid ReequipStuffArmedBrutoForm form) {
        ArmedBruto armedBruto = this.armedBrutoService.get(uuid);

        Set<Stuff> equipedStuffs = form.equipedStuffs.stream()
                .map(this.stuffService::findByName)
                .collect(Collectors.toSet());

        this.armedBrutoService.reequip(armedBruto, equipedStuffs);

        return new ArmedBrutoResponse(armedBruto);
    }
}
