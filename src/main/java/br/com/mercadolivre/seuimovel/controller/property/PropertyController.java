package br.com.mercadolivre.seuimovel.controller.property;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.seuimovel.dto.property.PropertyDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomM2DTO;
import br.com.mercadolivre.seuimovel.service.property.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService service;
    
    @Autowired
    public PropertyController(PropertyService service){
        this.service = service;
    }

    @PostMapping("/m2")
    public ResponseEntity<Double> calculateM2 (@Valid @RequestBody PropertyDTO dto){
        return new ResponseEntity<>(service.calculateM2(dto), HttpStatus.OK);
    }

    @PostMapping("/value")
    public ResponseEntity<String> calculateValue(@Valid @RequestBody PropertyDTO dto){
        return new ResponseEntity<>(service.calculateValue(dto), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<RoomDTO> biggestRoom(@Valid @RequestBody PropertyDTO dto){
        return new ResponseEntity<>(service.findBiggestRoom(dto), HttpStatus.OK);
    }

    @PostMapping("/rooms/m2")
    public ResponseEntity<List<RoomM2DTO>> roomsM2 (@Valid @RequestBody PropertyDTO dto){
        return new ResponseEntity<>(service.getEachM2PropertyRoom(dto), HttpStatus.OK);
    }

}
