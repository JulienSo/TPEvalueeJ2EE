package TPEvalueJ2EE;

import TPEvalueJ2EE.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Julien on 02/04/2017.
 */
@Component
public class Bootstrap {

    @Autowired
    InitialisationService initialisationService;

    @PostConstruct
    public void init(){
        initialisationService.initDonnees();
    }

    public InitialisationService getInitialisationService() {
        return initialisationService;
    }

    public void setInitialisationService(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }
}
