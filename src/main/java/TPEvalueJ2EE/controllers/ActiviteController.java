package TPEvalueJ2EE.controllers;

import TPEvalueJ2EE.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Julien on 02/04/2017.
 */
@Controller
public class ActiviteController {

    @Autowired
    private Bootstrap bootstrap;

    @GetMapping(value = "/activites")
    public String list(Model model){
        model.addAttribute("activites", bootstrap.getInitialisationService().getActivites());
        return "activites";
    }
}