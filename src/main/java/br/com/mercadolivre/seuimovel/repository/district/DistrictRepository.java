package br.com.mercadolivre.seuimovel.repository.district;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.entities.district.District;
import br.com.mercadolivre.seuimovel.exception.DistrictNotFoundException;

@Repository
public class DistrictRepository {

    private List<District> districts = new ArrayList<>();


    public DistrictRepository(){
        districts.add(new District("Alphaville", new BigDecimal(119.01)));
        districts.add(new District("Leblon", new BigDecimal(200.01)));
    }

    public boolean isValid(District district){
        for(District d:districts){
            if (d.getProp_district().equals(district.getProp_district())){
                return true;
            }
        }
        throw new DistrictNotFoundException();
    }

    public List<DistrictDTO> index() {
        return districts.stream().map(DistrictDTO::convert).collect(Collectors.toList());
    }

    public DistrictDTO create(DistrictDTO dto){
        District district = DistrictDTO.convert(dto);
        try{
            isValid(district);
        } catch (DistrictNotFoundException e){
            districts.add(district);
        }
        return dto;
    }
    
}
