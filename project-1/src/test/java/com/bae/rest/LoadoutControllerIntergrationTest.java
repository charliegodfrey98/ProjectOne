package com.bae.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.domain.Loadout;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:loadout-schema.sql",
		" classpath:loadout-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LoadoutControllerIntergrationTest {

	@Autowired
	private MockMvc MockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Loadout newLoadout = new Loadout("test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");

		String newLoadoutAsJSON = this.mapper.writeValueAsString(newLoadout);

		RequestBuilder mockRequest = post("/createLoadout").contentType(MediaType.APPLICATION_JSON)
				.content(newLoadoutAsJSON);

		Loadout savedLoadout = new Loadout(2L, "test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");

		String savedLoadoutAsJson = this.mapper.writeValueAsString(savedLoadout);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedLoadoutAsJson);

		this.MockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void readTest() throws Exception {
		Loadout testLoadout = new Loadout(1L, "test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");

		List<Loadout> allLoadout = List.of(testLoadout);
		String testLoadoutAsJSON = this.mapper.writeValueAsString(allLoadout);

		RequestBuilder mockRequest = get("/getLoadout");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testLoadoutAsJSON);

		this.MockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void updateTest() throws Exception {
		Loadout newLoadout = new Loadout("test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");
		String newLoadoutAsJSON = this.mapper.writeValueAsString(newLoadout);

		RequestBuilder mockRequest = put("/updateLoadout/1").contentType(MediaType.APPLICATION_JSON)
				.content(newLoadoutAsJSON);

		Loadout savedLoadout = new Loadout(1L, "test", "test primary weapon", "test secondary weapon", "test lethal",
				"test tactical", "test perk1", "test perk2", "test perk3");
		String savedLoadoutAsJSON = this.mapper.writeValueAsString(savedLoadout);

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedLoadoutAsJSON);

		this.MockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void deleteTest() throws Exception {
		RequestBuilder mockRequest = delete("/removeLoadout/1");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("true");
		this.MockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

}
