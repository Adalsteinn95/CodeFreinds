package quiz.start.awesomeTests;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import quiz.start.controller.QuestionControl;
import quiz.start.controller.UserControl;
import quiz.start.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControl.class)
//tag::test[]
public class WebLayerTest {

    /**
     * þjónninn ekki keyrður upp
     */
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService mockService;

    /**
     * Test til að athuga hvort HttpRequest sé sent á "/"
     * @throws Exception
     */
    @Test
    public void userControlTest() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}
//end::test[]
