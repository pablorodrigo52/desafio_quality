package br.com.mercadolivre.seuimovel.controller.district;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.service.district.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictController {
    

    @Autowired
    private DistrictService service;

    @GetMapping("/")
    public ResponseEntity<List<DistrictDTO>> index(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DistrictDTO> create(@RequestBody DistrictDTO dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }
}
