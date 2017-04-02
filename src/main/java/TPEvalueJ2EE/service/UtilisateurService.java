package TPEvalueJ2EE.service;

import TPEvalueJ2EE.domain.Utilisateur;
import TPEvalueJ2EE.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Julien on 02/04/2017.
 */
@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        if (utilisateur == null) {
            throw new IllegalArgumentException("Activite must not be null");
        }
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findOneUtilisateur(Long id){
        return utilisateurRepository.findOne(id);
    }

    public long countUtilisateur(){
        return utilisateurRepository.count();
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public ArrayList<Utilisateur> findAllUtilisateurs() {
        Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "nom")));
        ArrayList<Utilisateur> utilisateursList = new ArrayList<>();
        utilisateurs.forEach(utilisateursList::add);
        return utilisateursList;
    }
}
