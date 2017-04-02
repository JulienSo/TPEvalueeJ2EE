package TPEvalueJ2EE.repositories;

import TPEvalueJ2EE.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Julien on 02/04/2017.
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
}
