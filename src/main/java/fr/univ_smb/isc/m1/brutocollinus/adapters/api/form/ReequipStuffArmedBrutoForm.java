package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.Size;
import java.util.List;

public class ReequipStuffArmedBrutoForm {
    @Size(min = 1, max = 3)
    public List<String> equipedStuffs;
}
