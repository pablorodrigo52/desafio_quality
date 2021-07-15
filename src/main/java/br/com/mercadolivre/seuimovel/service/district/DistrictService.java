package br.com.mercadolivre.seuimovel.service.district;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.dto.property.PropertyDTO;
import br.com.mercadolivre.seuimovel.repository.district.DistrictRepository;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository repository;

    public boolean checkIfDistrictExists(PropertyDTO propertyDTO) {
        return repository.isValid(DistrictDTO.convert(propertyDTO.getDistrict()));
    }

    public List<DistrictDTO> index() {
        return repository.index();
    }

    public DistrictDTO create(DistrictDTO dto) {
        return repository.create(dto);
    }


}
