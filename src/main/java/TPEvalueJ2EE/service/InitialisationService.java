package TPEvalueJ2EE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TPEvalueJ2EE.domain.Activite;
import TPEvalueJ2EE.domain.Utilisateur;

import java.util.ArrayList;

@Service
public class InitialisationService {

    private Utilisateur  mary, thom;
    private Activite randonnee, lindyhop, taekwondo;

    @Autowired
    ActiviteService activiteService;

    public void initDonnees() {
        initMary();
        initThom();
        initRandonnee();
        initLindyHop();
        initTaekwondo();
    }

    private void initThom() {
        thom = new Utilisateur("Thom", "Thom", "thom@thom.com", "M");
    }

    private void initMary() {
        mary = new Utilisateur("Mary", "Mary", "mary@mary.com", "F");
    }

    private void initTaekwondo() {
        taekwondo = new Activite("Taekwondo", "le dimanche soir", thom);
        activiteService.saveActivite(taekwondo);
    }

    private void initLindyHop() {
        lindyhop = new Activite("Lindy Hop", "le jeudi soir", mary);
        activiteService.saveActivite(lindyhop);
    }

    private void initRandonnee() {
        randonnee = new Activite("Randonnee", "le lundi matin", thom);
        activiteService.saveActivite(randonnee);
    }

    public Utilisateur getMary() {
        return mary;
    }

    public void setMary(Utilisateur mary) {
        this.mary = mary;
    }

    public Utilisateur getThom() {
        return thom;
    }

    public void setThom(Utilisateur thom) {
        this.thom = thom;
    }

    public Activite getRandonnee() {
        return randonnee;
    }

    public void setRandonnee(Activite randonnee) {
        this.randonnee = randonnee;
    }

    public Activite getLindyhop() {
        return lindyhop;
    }

    public void setLindyhop(Activite lindyhop) {
        this.lindyhop = lindyhop;
    }

    public Activite getTaekwondo() {
        return taekwondo;
    }

    public void setTaekwondo(Activite taekwondo) {
        this.taekwondo = taekwondo;
    }
}
