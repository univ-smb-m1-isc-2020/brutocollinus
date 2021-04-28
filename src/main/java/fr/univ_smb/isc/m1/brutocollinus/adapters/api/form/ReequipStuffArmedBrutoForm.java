package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class ReequipStuffArmedBrutoForm {
    @Size(min = 1, max = 3)
    public Set<String> equipedStuffs;
}
