package TPEvalueJ2EE.service;

import TPEvalueJ2EE.domain.Activite;
import TPEvalueJ2EE.domain.Utilisateur;
import TPEvalueJ2EE.repositories.ActiviteRepository;
import TPEvalueJ2EE.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Julien on 02/04/2017.
 */
@Service
public class ActiviteService {

    @Autowired
    ActiviteRepository activiteRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public Activite saveActivite(Activite activite){
        if (activite == null) {
            throw new IllegalArgumentException("Activite must not be null");
        }
        Utilisateur utilisateur = activite.getResponsable();
        if(utilisateur != null){
            utilisateurRepository.save(utilisateur);
        }
        return activiteRepository.save(activite);
    }

    public Activite findOneActivite(Long id){
        return activiteRepository.findOne(id);
    }

    public long countActivite(){
        return activiteRepository.count();
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public ArrayList<Activite> findAllActivites() {
        //Iterable<Activite> activites = activiteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "titre")));
        Iterable<Activite> activites = activiteRepository.findAll();
        ArrayList<Activite> activitesList = new ArrayList<>();
        activites.forEach(activitesList::add);
        return activitesList;    }
}
