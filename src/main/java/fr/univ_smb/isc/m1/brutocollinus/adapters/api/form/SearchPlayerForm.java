package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;

public class SearchPlayerForm {
    @NotBlank
    public String term;
}
