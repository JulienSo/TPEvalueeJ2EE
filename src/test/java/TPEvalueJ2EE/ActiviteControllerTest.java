package TPEvalueJ2EE;

import TPEvalueJ2EE.controllers.ActiviteController;
import TPEvalueJ2EE.controllers.IndexController;
import TPEvalueJ2EE.service.InitialisationService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Julien on 02/04/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ActiviteController.class)
public class ActiviteControllerTest {

    @MockBean
    private Bootstrap bootstrap;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testIndex() throws Exception{
        when(bootstrap.getInitialisationService()).thenReturn(new InitialisationService());
        mockMvc.perform(get("/activites"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("activites"))
                .andExpect(content().string(Matchers.containsString("<h2>Liste des Activités</h2>")))
                .andDo(print());
    }
}
