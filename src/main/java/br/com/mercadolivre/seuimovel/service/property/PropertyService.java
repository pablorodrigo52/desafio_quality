package br.com.mercadolivre.seuimovel.service.property;

import java.text.NumberFormat;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.dto.property.PropertyDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomM2DTO;
import br.com.mercadolivre.seuimovel.exception.DistrictNotFoundException;
import br.com.mercadolivre.seuimovel.repository.district.DistrictRepository;

@Service
public class PropertyService {

    @Autowired
    private DistrictRepository districtRepository;
    
    public double calculateM2(PropertyDTO propertyDTO){
        if(districtRepository.isValid(DistrictDTO.convert(propertyDTO.getDistrict()))){
            return propertyDTO.getRooms()
            .stream()
            .mapToDouble(room -> room.getM2())
            .sum();
        }
        throw new DistrictNotFoundException();
    }

    public String calculateValue(PropertyDTO propertyDTO) {
        if(districtRepository.isValid(DistrictDTO.convert(propertyDTO.getDistrict()))){
            return NumberFormat
            .getCurrencyInstance()
            .format(
                propertyDTO.getRooms()
                .stream()
                .mapToDouble(
                    room -> room.getM2()*propertyDTO.getDistrict().getValue_district_m2().doubleValue())
                .sum()
            );
        }
        throw new DistrictNotFoundException();
    }

    public RoomDTO findBiggestRoom(PropertyDTO propertyDTO) {
        if(districtRepository.isValid(DistrictDTO.convert(propertyDTO.getDistrict()))){
            return propertyDTO.getRooms().stream().max(Comparator.comparingDouble(RoomDTO::getM2)).orElse(null);
        }
        throw new DistrictNotFoundException();
    }

    public List<RoomM2DTO> getEachM2PropertyRoom(PropertyDTO propertyDTO) {
        if(districtRepository.isValid(DistrictDTO.convert(propertyDTO.getDistrict()))){
            return propertyDTO.getRooms().stream().map(room -> new RoomM2DTO(room.getRoom_name(), room.getM2())).collect(Collectors.toList());
        }
        throw new DistrictNotFoundException();
    }
}
