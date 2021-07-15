package br.com.mercadolivre.seuimovel.property.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mercadolivre.seuimovel.property.dto.PropertyDTO;
import br.com.mercadolivre.seuimovel.property.dto.RoomDTO;
import br.com.mercadolivre.seuimovel.property.dto.RoomM2DTO;
import br.com.mercadolivre.seuimovel.property.service.PropertyService;

@SpringBootTest
public class PropertyUnitTests {

    @Autowired
    private PropertyService service;

    private RoomDTO room1 = new RoomDTO("Sala de teste", 50.0, 25.0);
    private RoomDTO room2 = new RoomDTO("Cozinha de teste", 25.0, 25.0);
    private RoomDTO room3 = new RoomDTO("Quarto de teste", 15.0, 17.0);

    @Test
    public void shouldBeCalculateM2ForAProperty(){
        PropertyDTO property = createAProperty();
        double actual = service.calculateM2(property);
        double expected = 2130.0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeCalculateValueForAPropertyBasedYourRooms(){
        PropertyDTO property = createAProperty();
        String actual = service.calculateValue(property);
        String expected = NumberFormat.getCurrencyInstance().format(253491.3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFindTheBiggestRoom(){
        PropertyDTO propertyDTO = createAProperty();
        RoomDTO actual = service.findBiggestRoom(propertyDTO);
        RoomDTO expected = room1;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeCalculateM2ForEachPropertyRoom(){
        PropertyDTO propertyDTO = createAProperty();
        List<RoomM2DTO> actual= service.getEachM2PropertyRoom(propertyDTO);
        List<RoomM2DTO> expected = propertyDTO.getRooms().stream().map(room -> new RoomM2DTO(room.getRoom_name(), room.getM2())).collect(Collectors.toList());

        assertEquals(actual.size(), expected.size());        
        for(int i =0; i < expected.size(); i++){
            assertEquals(expected.get(i).getName(), actual.get(i).getName());
            assertEquals(expected.get(i).getM2(), actual.get(i).getM2());
        }
    }


    private PropertyDTO createAProperty(){
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        return new PropertyDTO("Terreno de teste", "Bairro de teste", new BigDecimal(119.01), rooms);
    }

}
