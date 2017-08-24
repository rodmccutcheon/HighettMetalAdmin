package com.highettmetal.controllers;

import com.highettmetal.configuration.SecurityConfiguration;
import com.highettmetal.domain.ClientType;
import com.highettmetal.services.ClientTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientTypeController.class)
@Import(SecurityConfiguration.class)
public class ClientTypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientTypeService clientTypeServiceMock;

    @Test
    public void listAllClientTypes_shouldReturnListOfClientTypes() throws Exception {
        ClientType clientType1 = new ClientType();
        ClientType clientType2 = new ClientType();

        when(clientTypeServiceMock.listAllClientTypes()).thenReturn(Arrays.asList(clientType1, clientType2));

        mockMvc.perform(get("/clientTypes"))
                .andExpect(status().isOk())
                .andExpect(view().name("clientTypes/clientTypes"))
                .andExpect(model().attribute("clientTypes", hasSize(2)));
        verify(clientTypeServiceMock, times(1)).listAllClientTypes();
        verifyNoMoreInteractions(clientTypeServiceMock);
    }

    @Test
    public void deleteClientType_validClientType_shouldDeleteAndRedirect() throws Exception {
        mockMvc.perform(get("/clientTypes/delete/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/clientTypes"));
        verify(clientTypeServiceMock, times(1)).deleteClientType(1L);
        verifyNoMoreInteractions(clientTypeServiceMock);
    }
}
