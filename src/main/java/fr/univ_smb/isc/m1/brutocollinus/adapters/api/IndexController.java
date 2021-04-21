package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.MeCreateBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.IndexResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.MeCreateBrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class IndexController {
    @GetMapping(value="/api")
    @ResponseBody
    public IndexResponse index() {
        return new IndexResponse();
    }
}
