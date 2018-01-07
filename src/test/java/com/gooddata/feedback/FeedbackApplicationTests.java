package com.gooddata.feedback;

import com.gooddata.feedback.model.Feedback;

import java.nio.charset.Charset;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackApplicationTests {

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createFeedback() throws Exception {

        String feedbackJson = json(new Feedback("frodo", "Baggins"));

        mockMvc.perform(post("/feedback")
                .contentType(contentType)
                .content(feedbackJson))
                .andDo(print()).andExpect(status().isOk());

        mockMvc.perform(get("/feedback/{name}", "frodo"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("frodo"))
                .andExpect(jsonPath("$[0].summary").value("Baggins"));
    }

    @Test
    public void listAllFeedbacks() throws Exception {

        mockMvc.perform(get("/feedback"))
                .andDo(print()).andExpect(status().isOk())
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

    @Test
    public void listParticularFeedbacks() throws Exception {

        mockMvc.perform(get("/feedback/{name}", "name1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("name1"))
                .andExpect(jsonPath("$[0].summary").value("Message1"))
                .andExpect(jsonPath("$[1].name").value("name1"))
                .andExpect(jsonPath("$[1].summary").value("Message3"));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
