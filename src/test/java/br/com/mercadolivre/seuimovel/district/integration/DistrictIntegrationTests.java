package br.com.mercadolivre.seuimovel.district.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.repository.district.DistrictRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;    

    @Mock
    private DistrictRepository repository = mock(DistrictRepository.class);

    @Test
    public void shouldBeRequestIndexDistricts() throws Exception{
        TypeReference<List<DistrictDTO>> typeReference = new TypeReference<List<DistrictDTO>>() {};
        MvcResult result = mockMvc.perform(
            get("/district/")
            .contentType("application/json")
        )
        .andExpect(status().isOk())
        .andReturn();

        List<DistrictDTO> actual = mapper.readValue(result.getResponse().getContentAsString(), typeReference);

        assertTrue(actual.size() > 0);
    }


    @Test
    public void shouldBeRequestCreateADistrict() throws Exception{
        DistrictDTO expected = new DistrictDTO("Distrito teste", new BigDecimal(119.0));
        MvcResult result = mockMvc.perform(
            post("/district/")
            .contentType("application/json")
            .content(mapper.writeValueAsString(expected))
        )
        .andExpect(status().isOk())
        .andReturn();

        when(repository.create(expected)).thenReturn(expected);

        TypeReference<DistrictDTO> typeReference = new TypeReference<DistrictDTO>() {};
        DistrictDTO actual = mapper.readValue(result.getResponse().getContentAsString(), typeReference);

        assertEquals(expected.getProp_district(), actual.getProp_district());
        assertEquals(expected.getValue_district_m2(), actual.getValue_district_m2());
    }
}
