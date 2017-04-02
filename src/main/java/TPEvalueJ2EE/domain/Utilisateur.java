package TPEvalueJ2EE.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Julien on 02/04/2017.
 */
public class Utilisateur {

    @NotNull
    @Size(min = 1, max = 256)
    private String nom;

    @NotNull
    @Size(min = 1, max = 256)
    private String prenom;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^[MF]{1}$")
    private String sexe;

    private Date dateNaissance;

    public Utilisateur(String nom, String prenom, String email, String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
    }

    public Utilisateur(String nom, String prenom, String email, String sexe, Date dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
