package com.highettmetal.controllers;

import com.highettmetal.configuration.SecurityConfiguration;
import com.highettmetal.domain.BinType;
import com.highettmetal.services.BinTypeService;
import com.highettmetal.services.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinTypeController.class)
@Import(SecurityConfiguration.class)
public class BinTypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BinTypeService binTypeServiceMock;

    @MockBean
    StorageService storageServiceMock;

    @Test
    public void listAllBinTypes_shouldReturnListOfBinTypes() throws Exception {
        BinType b1 = new BinType("Type 1");
        BinType b2 = new BinType("Type 2");

        when(binTypeServiceMock.listAllBinTypes()).thenReturn(Arrays.asList(b1, b2));

        mockMvc.perform(get("/binTypes"))
                .andExpect(status().isOk())
                .andExpect(view().name("binTypes/binTypes"))
                .andExpect(model().attribute("binTypes", hasSize(2)));
        verify(binTypeServiceMock, times(1)).listAllBinTypes();
        verifyNoMoreInteractions(binTypeServiceMock);
    }

    @Test
    public void getBinTypeById_validId_shouldReturnBinType() throws Exception {
        BinType b1 = new BinType("Type 1");
        b1.setId(1L);

        when(binTypeServiceMock.getBinTypeById(1L)).thenReturn(b1);

        mockMvc.perform(get("/binTypes/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("binTypes/binTypes-show"))
                .andExpect(model().attribute("binType", hasProperty("id", is(1L))))
                .andExpect(model().attribute("binType", hasProperty("name", is("Type 1"))));
        verify(binTypeServiceMock, times(1)).getBinTypeById(1L);
        verifyNoMoreInteractions(binTypeServiceMock);
    }

    @Test
    public void saveBinType_validBinType_shouldSaveAndRedirect() throws Exception {
        mockMvc.perform(post("/binTypes").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/binTypes"));
        verify(binTypeServiceMock, times(1)).saveBinType(isA(BinType.class));
        verifyNoMoreInteractions(binTypeServiceMock);
    }

    @Test
    public void deleteBinType_validBinType_shouldDeleteAndRedirect() throws Exception {
        mockMvc.perform(get("/binTypes/delete/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/binTypes"));
        verify(binTypeServiceMock, times(1)).deleteBinType(1L);
        verifyNoMoreInteractions(binTypeServiceMock);
    }
}
