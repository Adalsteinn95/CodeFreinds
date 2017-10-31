package quiz.start.awesomeTests;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import quiz.start.controller.QuestionControl;
import quiz.start.controller.UserControl;
import quiz.start.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControl.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Mockbean, prufueintak af userservice
     */
    @MockBean
    UserService userService;

    @Test
    public void testLife() throws Exception {
        when(userService.isAlive()).thenReturn(true);
        this.mockMvc.perform(get("/API/alive"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .string(containsString("alive")));
    }

    @Test
    public void testDeath() throws Exception {
        when(userService.isAlive()).thenReturn(false);
        this.mockMvc.perform(get("/API/alive"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .string(containsString("dead")));
    }
}
