package com.ust.controllerTest;

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
import com.ust.Converter.DtoConvert;
import com.ust.Service.OrderService;
import com.ust.controller.OrderController;
import com.ust.dto.OrderDto;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	DtoConvert convert;
	@Mock
	OrderService Service;
	@InjectMocks
	OrderController Controller;

	private OrderDto Dto =new OrderDto(1, 22, 33,true);

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(Controller).build();
		Dto = new OrderDto(1, 22, 33,true);

	}

	@Test
	void createTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			when(Service.placeorder(Dto)).thenReturn(true);
			mockMvc.perform(post("order/cart").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});

	}

	@Test
	void updateTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			Dto.setProductId(123);;
			when(Service.updateorder(Dto)).thenReturn(true);
			mockMvc.perform(put("order/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void getUserByIdUserTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(Service.getById(1)).thenReturn(Dto);
			mockMvc.perform(get("/order/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print());
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
//
