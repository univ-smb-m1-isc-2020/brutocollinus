package fr.univ_smb.isc.m1.brutocollinus.adapters.api.form;

import javax.validation.constraints.NotBlank;

public class RegisterForm {
     @NotBlank
     private String login;
     @NotBlank
     private String password;

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
}
