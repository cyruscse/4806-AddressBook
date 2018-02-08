package lab;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoTest {
    @Autowired
    private MockMvc mockMvc;

    private String buddyCreate = "{ \"name\": \"Cyrus\", \"phoneNumber\": \"555222\" }";
    private String buddyPatch = "{ \"phoneNumber\": \"9919\" }";

    @Test
    public void createDeleteBuddy() throws Exception {
        this.mockMvc.perform(post("/buddies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(buddyCreate)).andExpect(status().isCreated());
        this.mockMvc.perform(get("/buddies/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        this.mockMvc.perform(delete("/buddies/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
        this.mockMvc.perform(get("/buddies/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void patchBuddy() throws Exception {
        this.mockMvc.perform(post("/buddies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(buddyCreate)).andExpect(status().isCreated());
        this.mockMvc.perform(get("/buddies/2").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        this.mockMvc.perform(patch("/buddies/2").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(buddyPatch)).andExpect(status().isOk());
    }
}
