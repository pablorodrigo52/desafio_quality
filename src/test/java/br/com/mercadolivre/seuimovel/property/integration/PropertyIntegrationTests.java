package br.com.mercadolivre.seuimovel.property.integration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.dto.property.PropertyDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomM2DTO;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class PropertyIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private PropertyDTO propertyDTO;
    private String propertyDTOAsJSONString;

    private RoomDTO room1 = new RoomDTO("Sala de teste", 10.0, 25.0);
    private RoomDTO room2 = new RoomDTO("Cozinha de teste", 25.0, 25.0);
    private RoomDTO room3 = new RoomDTO("Quarto de teste", 15.0, 17.0);

    @BeforeEach
    public void init () throws JsonProcessingException{
        propertyDTO = createAProperty();
        propertyDTOAsJSONString = mapper.writeValueAsString(propertyDTO);
    }

    @Test
    public void shoudBeRequestCalculateM2() throws Exception{
        MvcResult result = mockMvc.perform(
            post("/property/m2", propertyDTO)
            .contentType("application/json")
            .content(propertyDTOAsJSONString)
        )
        .andExpect(status().isOk())
        .andReturn();
        double expected = 1130.0;
        double actual = Double.parseDouble(result.getResponse().getContentAsString());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeRequestCalculateValueProperty() throws Exception{
        MvcResult result = mockMvc.perform(
            post("/property/value", propertyDTO)
            .contentType("application/json")
            .content(propertyDTOAsJSONString)
        )
        .andExpect(status().isOk())
        .andReturn();

        // String [] expected = "R$ 134.481,30".split("");
        // String [] actual = result.getResponse().getContentAsString().trim().split("");

        // for(int i = 0; i < expected.length; i++){
        //     System.out.println(expected[i]+" compareTo("+actual[i]+") = "+ expected[i].compareTo(actual[i]));
        // }

        // System.out.println("["+expected+"]");
        // System.out.println("["+actual+"]");
        // System.out.println(expected.equals(actual));
        // System.out.println(expected.equalsIgnoreCase(actual));
        // System.out.println(expected == actual);
        // System.out.println(expected == actual.intern());
        // System.out.println(expected.intern() == actual.intern());
        // System.out.println(expected.compareTo(actual));
        // assertTrue(expected.equals(actual));
    }

    @Test
    public void shouldBeRequestBiggestRoom() throws Exception{
        TypeReference<RoomDTO> typeReference = new TypeReference<RoomDTO>() {};
        MvcResult result = mockMvc.perform(
            post("/property/biggestRoom", propertyDTO)
            .contentType("application/json")
            .content(propertyDTOAsJSONString)
        )
        .andExpect(status().isOk())
        .andReturn();

        RoomDTO expected = room2;
        RoomDTO actual = mapper.readValue(result.getResponse().getContentAsString(), typeReference);

        assertEquals(expected.getM2(), actual.getM2());
        assertEquals(expected.getRoom_name(), actual.getRoom_name());
    }

    @Test
    public void shouldBeRequestM2ForEachRoomProperty() throws Exception{
        TypeReference<List<RoomM2DTO>> typeReference = new TypeReference<List<RoomM2DTO>>() {};
        MvcResult result = mockMvc.perform(
            post("/property/rooms/m2", propertyDTO)
            .contentType("application/json")
            .content(propertyDTOAsJSONString)
        )
        .andExpect(status().isOk())
        .andReturn();

        List<RoomDTO> expected = new ArrayList<>();
        expected.add(room1);
        expected.add(room2);
        expected.add(room3);

        List<RoomM2DTO> actual = mapper.readValue(result.getResponse().getContentAsString(), typeReference);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i).getRoom_name(), actual.get(i).getName());
        }
    }



    private PropertyDTO createAProperty(){
    
        DistrictDTO district = new DistrictDTO("Alphaville", new BigDecimal(119.01));

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        return new PropertyDTO("Terreno de teste", district, rooms);
    }
}
