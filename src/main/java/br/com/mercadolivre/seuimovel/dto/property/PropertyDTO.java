package br.com.mercadolivre.seuimovel.dto.property;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.mercadolivre.seuimovel.dto.district.DistrictDTO;
import br.com.mercadolivre.seuimovel.dto.room.RoomDTO;
import br.com.mercadolivre.seuimovel.entities.property.Property;
import br.com.mercadolivre.seuimovel.entities.room.Room;


public class PropertyDTO {

    @NotNull(message = "É obrigatório informar o nome da propriedade.")
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(max=30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "([A-Z])\\\\w+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    private DistrictDTO district;
    
    private List<RoomDTO> rooms;

    public PropertyDTO() {
    }

    public PropertyDTO(String prop_name, DistrictDTO district, List<RoomDTO> rooms) {
        this.prop_name = prop_name;
        this.district = district;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return this.prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public DistrictDTO getDistrict() {
        return this.district;
    }

    public void setDistrict(DistrictDTO district) {
        this.district = district;
    }

    public List<RoomDTO> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public static Property convert(PropertyDTO dto){
        return new Property(
            dto.getProp_name(), 
            DistrictDTO.convert(dto.getDistrict()), 
            dto.getRooms().stream().map(roomDTO -> new Room(roomDTO.getRoom_name(), roomDTO.getRoom_width(), roomDTO.getRoom_length())).collect(Collectors.toList())
        );
    }

    public static PropertyDTO convert(Property property){
        return new PropertyDTO(
            property.getProp_name(), 
            DistrictDTO.convert(property.getDistrict()), 
            property.getRooms().stream().map(roomDTO -> new RoomDTO(roomDTO.getRoom_name(), roomDTO.getRoom_width(), roomDTO.getRoom_length())).collect(Collectors.toList())
        );
    }
    
}
