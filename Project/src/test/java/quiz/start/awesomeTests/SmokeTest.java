package quiz.start.awesomeTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quiz.start.controller.UserControl;

/**
 * @author Geir Gardarsson
 * @date october 2017
 *
 * Test class for initialization of a controller class
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    
    @Autowired
    private UserControl controller;

    /**
     * Aðferð sem athugar hvort controller klasi hafi orðið til
     * @throws Exception
     */
    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
