package com.hly.chapter327;

import com.hly.chapter327.controller.TeacherController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MVCTests {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new TeacherController()).build();
	}

	@Test
	public void testhi() throws Exception {
		mvc.perform(get("/teacher/hi"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hi")));
	}

	@Test
	public void add() throws Exception {
		mvc.perform(get("/teacher/add"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello")));
	}

}
