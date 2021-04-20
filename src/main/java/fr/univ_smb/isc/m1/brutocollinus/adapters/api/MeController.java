package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.MeCreateBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.MeAllBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.CreateBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
public class MeController {

    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final BrutoClassService brutoClassService;

    public MeController(BrutoService brutoService, PlayerService playerService, BrutoClassService brutoClassService) {
        this.brutoService = brutoService;
        this.playerService = playerService;
        this.brutoClassService = brutoClassService;
    }

    private BrutoResponse brutoReponseWithLinks(Bruto bruto) {
        BrutoResponse response = new BrutoResponse(bruto);
        return response;
    }

    @GetMapping(value="/api/me/{uuid}/bruto/all")
    @ResponseBody
    public MeAllBrutoResponse allBruto(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);

        List<BrutoResponse> brutoResponses = me.brutos().stream()
                .map((bruto) -> this.brutoReponseWithLinks(bruto))
                .collect(Collectors.toList());

        MeAllBrutoResponse response = new MeAllBrutoResponse(brutoResponses);
        return response;
    }

    @PostMapping(value="/api/player/{uuid}/bruto/create")
    @ResponseBody
    public MeCreateBrutoResponse createBruto(@PathVariable String uuid, @RequestBody @Valid CreateBrutoForm form) {
        Player me = this.playerService.get(uuid);
        BrutoClass brutoClass = this.brutoClassService.findByName(form.className);
        Bruto bruto = this.brutoService.create(form.name, brutoClass, me);

        MeCreateBrutoResponse response = new MeCreateBrutoResponse(this.brutoReponseWithLinks(bruto));
        return response;
    }
}
