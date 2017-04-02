package TPEvalueJ2EE.repositories;

import TPEvalueJ2EE.domain.Activite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Julien on 02/04/2017.
 */
public interface ActiviteRepository extends PagingAndSortingRepository<Activite, Long> {

    @Query("select activite from Activite activite join fetch activite.responsable order by activite.titre asc")
    public Iterable<Activite> findAll();
}
