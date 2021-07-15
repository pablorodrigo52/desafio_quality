package br.com.mercadolivre.seuimovel.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mercadolivre.seuimovel.dto.property.PropertyDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomM2DTO;

@Service
public class PropertyService {
    
    public double calculateM2(PropertyDTO propertyDTO){
        return propertyDTO.getRooms()
            .stream()
            .mapToDouble(room -> room.getM2())
            .sum();
    }

    public String calculateValue(PropertyDTO propertyDTO) {
        return NumberFormat
        .getCurrencyInstance()
        .format(
            propertyDTO.getRooms()
            .stream()
            .mapToDouble(
                room -> room.getM2()*propertyDTO.getValue_district_m2().doubleValue())
            .sum()
        );
    }

    public RoomDTO findBiggestRoom(PropertyDTO propertyDTO) {
        return propertyDTO.getRooms().stream().max(Comparator.comparingDouble(RoomDTO::getM2)).orElse(null);
    }

    public List<RoomM2DTO> getEachM2PropertyRoom(PropertyDTO propertyDTO) {
       return propertyDTO.getRooms().stream().map(room -> new RoomM2DTO(room.getRoom_name(), room.getM2())).collect(Collectors.toList());
    }
}
