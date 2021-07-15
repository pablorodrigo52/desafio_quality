package br.com.mercadolivre.seuimovel.repository.district;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
            if (d.getProp_district().equals(district.getProp_district()) && d.getValue_district_m2().equals(district.getValue_district_m2())){
                return true;
            }
        }
        throw new DistrictNotFoundException();
    }
    
}
