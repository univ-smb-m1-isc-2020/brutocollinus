package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TournamentRequestAcceptForm {
    @NotNull
    public String selectedBruto;
    @NotNull
    public List<String> selectedBoosts;
}
