package com.example.controllerTest.controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = UserController.class)
public class ProductControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_getProductById() throws Exception {
        User expected = new User(1, "jane");
        Mockito.when(userService.getUserById(1)).thenReturn(expected);

        // 1st way - using andExpect
        mockMvc.perform(MockMvcRequestBuilders.get("/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // status code 200
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\n" +
                                "    \"id\": 1,\n" +
                                "    \"username\": \"jane\" \n" +
                                "}"));

        // 2nd way - using assertEquals
//        MvcResult result = mockMvc
//                .perform(MockMvcRequestBuilders.get("/product/{id}", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//        // use Gson to convert the JSON response to a Product object
//        Gson gson = new Gson();
//        Product actual = gson.fromJson(result.getResponse().getContentAsString(), Product.class);
//        assertEquals(expected.toString(), actual.toString());
    }



}
