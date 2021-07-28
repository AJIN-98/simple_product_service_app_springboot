package com.ust.account.ControllerTest;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

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

	private accountDto Dto ;
	
	 @Autowired
	    private ObjectMapper objectMapper;

	 
	 
	    private List<accountDto> userList;

	    @BeforeEach
	    void setUp() {
//	    	Dto = mock(accountDto.class);
	        this.userList = new ArrayList<>();
	        this.userList.add(new accountDto(1, "ajin", "xyz", "abc", 20));
	        this.userList.add(new accountDto(2, "ajin", "xyz", "abc", 20));
	        this.userList.add(new accountDto(3, "ajin", "xyz", "abc", 20));

	        objectMapper.registerModule(new ProblemModule());
	        objectMapper.registerModule(new ConstraintViolationProblemModule());
	    }

//	@Test
//	void createTest() throws Exception {
//		Assertions.assertThrows(Exception.class, () -> {
//			when(Service.addUser(Dto)).thenReturn(true);
//			mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
//					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//		});
//
//	}
	    
	@Test
    void shouldFetchOneUserById() throws Exception {
        final accountDto user = new accountDto(1, "ajin", "xyz", "abc", 20);

        when(Service.getUser(1)).thenReturn(user);
        System.out.println(Service.getUser(1)); 
        this.mockMvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk());
    }

//	@Test
//	void updateTest() throws Exception {
//		Assertions.assertThrows(Exception.class, () -> {
//			Dto.setFirstName("don");
//			when(Service.updateUser(Dto)).thenReturn(true);
//			mockMvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
//					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//		});
//	}
//
//	@Test
//	void getUserByIdUserTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(Service.getUser(1)).thenReturn(Dto);
//			mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//					.andDo(MockMvcResultHandlers.print());
//		});
//	}
//
//	@Test
//	void sortbyFirstNameTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(Service.sortByFirstName()).thenReturn(Dtolist);
//			mockMvc.perform(get("/user/fnamesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//	}
//
//	@Test
//	void sortbyLastNameTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(Service.sortByLastName()).thenReturn(Dtolist);
//			mockMvc.perform(get("/user/lnamesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//	}
//
//	@Test
//	void sortbyAge() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(Service.sortByAge()).thenReturn(Dtolist);
//			mockMvc.perform(get("/user/agesort")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//	}
//
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
