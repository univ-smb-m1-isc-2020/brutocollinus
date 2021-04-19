package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class TournamenCreateForm {
    @NotBlank
    public String name;
    @NotEmpty
    public List<Long> participants;
}
