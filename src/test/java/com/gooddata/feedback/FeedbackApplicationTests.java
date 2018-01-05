package com.gooddata.feedback;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listAllFeedbacks() throws Exception {

        mockMvc.perform(get("/feedback")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("name1"))
                .andExpect(jsonPath("$[0].summary").value("Message1"));
    }

    @Test
    public void listParticularFeedback() throws Exception {

        mockMvc.perform(get("/feedback/{name}", "name2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("name2"))
                .andExpect(jsonPath("$[0].summary").value("Message2"));
    }
}
