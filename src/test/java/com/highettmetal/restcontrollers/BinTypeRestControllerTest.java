package com.highettmetal.restcontrollers;

import com.highettmetal.domain.BinType;
import com.highettmetal.services.BinTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BinTypeRestController.class, secure = false)
public class BinTypeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinTypeService binTypeService;

    @Test
    public void givenBinTypes_whenGetBins_thenReturnJsonArray() throws Exception {
        BinType type211 = new BinType("Type 211");
        BinType type35m3Dino = new BinType("Type 35m3 Dino");
        List<BinType> allBinTypes = Arrays.asList(type211, type35m3Dino);

        given(binTypeService.listAllBinTypes()).willReturn(allBinTypes);

        mockMvc.perform(get("/api/getBins")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bins", hasSize(2)))
                .andExpect(jsonPath("$.bins.[0].bin_name", is(type211.getName())))
                .andExpect(jsonPath("$.bins.[1].bin_name", is(type35m3Dino.getName())));

    }
}
