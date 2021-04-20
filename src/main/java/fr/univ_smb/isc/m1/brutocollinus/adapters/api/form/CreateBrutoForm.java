package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;

public class CreateBrutoForm {
    @NotBlank
    public String name;
    @NotBlank
    public String className;
}
