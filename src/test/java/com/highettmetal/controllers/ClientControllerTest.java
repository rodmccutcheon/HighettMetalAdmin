package com.highettmetal.controllers;

import com.highettmetal.configuration.SecurityConfiguration;
import com.highettmetal.services.ClientService;
import com.highettmetal.services.ClientTypeService;
import com.highettmetal.services.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
@Import(SecurityConfiguration.class)
public class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientService clientServiceMock;

    @MockBean
    ClientTypeService clientTypeServiceMock;

    @MockBean
    ProductCategoryService productCategoryServiceMock;

    @Test
    public void deleteClient_validClient_shouldDeleteAndRedirect() throws Exception {
        mockMvc.perform(get("/clients/delete/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/clients/"));
        verify(clientServiceMock, times(1)).deleteClient(1L);
        verifyNoMoreInteractions(clientServiceMock);
    }
}
