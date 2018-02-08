package lab;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.HttpHeaders.ACCEPT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBuddy() throws Exception {
        /*this.mockMvc.perform(post("/buddies").param("name", "Cyrus").param("phoneNumber", "5556666")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Cyrus")));
        this.mockMvc.perform(get("/buddies")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Cyrus")));*/
    }
}
