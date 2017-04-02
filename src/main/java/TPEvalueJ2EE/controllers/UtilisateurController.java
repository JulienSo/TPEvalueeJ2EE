package TPEvalueJ2EE.controllers;

import TPEvalueJ2EE.Bootstrap;
import TPEvalueJ2EE.domain.Utilisateur;
import TPEvalueJ2EE.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Julien on 02/04/2017.
 */
@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(value = "/utilisateurs")
    public String list(Model model){
        model.addAttribute("utilisateurs", utilisateurService.findAllUtilisateurs());
        return "utilisateurs";
    }

    @GetMapping(value = "/utilisateur/{id}")
    public String showUtilisateur(@PathVariable Long id, Model model){
        Utilisateur util = utilisateurService.findOneUtilisateur(id);
        if (util == null) {
            model.addAttribute("customMessage", "Impossible. Id non valide");
            return "error";
        }
        model.addAttribute("utilisateur", util);
        return "utilisateurShow";
    }

    @GetMapping(value = "/utilisateur/new")
    public String newUtilisateur(Model model){
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurForm";
    }

    @PostMapping(value = "/utilisateur")
    public String createOrUpdateUtilisateur(@Valid Utilisateur util,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "utilisateurForm";
        }
        utilisateurService.saveUtilisateur(util);
        return "redirect:/utilisateur/" + util.getId();
    }

    @GetMapping(value = "/utilisateur/edit/{id}")
    public String editUtilisateur(@PathVariable Long id, Model model){
        Utilisateur util = utilisateurService.findOneUtilisateur(id);
        if (util == null) {
            model.addAttribute("customMessage", "Impossible. Id non valide");
            return "error";
        }
        model.addAttribute("utilisateur", util);
        return "utilisateurForm";
    }

    @DeleteMapping("utilisateur/delete/{id}")
    public String deleteUtilisateur(@PathVariable Long id, Model model){
        Utilisateur util = utilisateurService.findOneUtilisateur(id);
        if (util == null) {
            model.addAttribute("customMessage", "Impossible. Id non valide");
            return "error";
        }
        if (util.getActivites().size() != 0) {
            model.addAttribute("customMessage", "Impossible. L'utilisateur est responsable d'activités. \n " +
                    "Un nouveau responsable doit être désigné avant de supprimer " +
                    util.getPrenom() + " " + util.getNom() + ".");
            return "error";
        }
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs";
    }


}
