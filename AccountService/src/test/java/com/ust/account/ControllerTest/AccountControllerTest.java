package com.ust.account.ControllerTest;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.account.Controller.AccountController;
import com.ust.account.Converter.DtoConvert;
import com.ust.account.Service.AccountService;
import com.ust.account.dto.accountDto;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	DtoConvert convert;
	@Mock
	AccountService Service;
	@InjectMocks
	AccountController Controller;

	private accountDto Dto =new accountDto(1, "ajin", "xyz", "abc", 20);


	private List<accountDto> Dtolist;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(Controller).build();
		Dto = new accountDto(1, "ajin", "xyz", "abc", 20);

	}

	@Test
	void createTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			when(Service.addUser(Dto)).thenReturn(true);
			mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});

	}

	@Test
	void updateTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			Dto.setFirstName("don");
			when(Service.updateUser(Dto)).thenReturn(true);
			mockMvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void getUserByIdUserTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(Service.getUser(1)).thenReturn(Dto);
			mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void sortbyFirstNameTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(Service.sortByFirstName()).thenReturn(Dtolist);
			mockMvc.perform(get("/user/fnamesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void sortbyLastNameTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(Service.sortByLastName()).thenReturn(Dtolist);
			mockMvc.perform(get("/user/lnamesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void sortbyAge() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(Service.sortByAge()).thenReturn(Dtolist);
			mockMvc.perform(get("/user/agesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		});
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
