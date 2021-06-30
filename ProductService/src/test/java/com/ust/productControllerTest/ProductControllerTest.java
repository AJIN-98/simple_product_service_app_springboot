package com.ust.productControllerTest;

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
import com.ust.Service.ProductService;
import com.ust.account.Converter.DtoConvert;
import com.ust.controller.productController;
import com.ust.dto.ProductDto;



@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	DtoConvert convert;
	@Mock
	ProductService Service;
	@InjectMocks
	productController Controller;

	private ProductDto Dto =new ProductDto(1, "netflix", "video","100$","yearly");

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(Controller).build();
		Dto =new ProductDto(1, "netflix", "video","100$","yearly");

	}

	@Test
	void addproduct() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			when(Service.addProduct(Dto)).thenReturn(true);
			mockMvc.perform(post("product/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});

	}

	@Test
	void updateTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			Dto.setProductName("amazon");
			when(Service.updateProduct(Dto)).thenReturn(true);
			mockMvc.perform(put("product/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(Dto)))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void getproductByIdUserTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			when(Service.getProduct(1)).thenReturn(Dto);
			mockMvc.perform(get("product/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
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
