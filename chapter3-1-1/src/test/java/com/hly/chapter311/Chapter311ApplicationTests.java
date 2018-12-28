package com.hly.chapter311;

import com.hly.chapter311.controller.HelloController;
import com.hly.chapter311.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter311ApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new UserController(), new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        /*mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello")));*/
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello")));
    }

    @Test
    public void contextLoads() throws Exception {

        RequestBuilder request = null;

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request = post("/users/")
                .param("id", "1")
                .param("name", "hhh")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("[{\"id\":\"1\",\"name\":\"hhh\",\"age\":20}]")));

        request = get("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"1\",\"name\":\"hhh\",\"age\":20}")));

        request = put("/users/1")
                .param("name", "bbb")
                .param("age", "12");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"1\",\"name\":\"bbb\",\"age\":12}")));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":\"1\",\"name\":\"bbb\",\"age\":12}]")));


        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request = post("/users/")
                .param("id","2")
                .param("name", "ccc")
                .param("age", "10");
        mvc.perform(request);

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":\"2\",\"name\":\"ccc\",\"age\":10}]")));

        request = get("/users/getName")
                .param("id", "2");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("ccc")));

    }



}
