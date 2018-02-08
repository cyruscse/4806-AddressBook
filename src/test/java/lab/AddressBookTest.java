package lab;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookTest {
    @Autowired
    private MockMvc mockMvc;

    //private String buddyCreate = "{ \"name\": \"Cyrus\", \"phoneNumber\": \"555222\" }";

    @Test
    public void createDeleteBook() throws Exception {
        this.mockMvc.perform(post("/addressBook").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isCreated());
        this.mockMvc.perform(get("/addressBook/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        this.mockMvc.perform(delete("/addressBook/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
        this.mockMvc.perform(get("/addressBook/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
        //this.mockMvc.perform(get("/buddies")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Cyrus")));
    }
}
