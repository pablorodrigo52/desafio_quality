package br.com.mercadolivre.seuimovel.property.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.mercadolivre.seuimovel.property.entities.Property;
import br.com.mercadolivre.seuimovel.property.entities.Room;


public class PropertyDTO {

    @NotNull(message = "É obrigatório informar o nome da propriedade.")
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(max=30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "([A-Z])\\\\w+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    @NotNull(message = "É obrigatório informar o bairro da propriedade.")
    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max=45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @NotNull(message = "É obrigatório informar o valor do m2 no bairro.")
    @NotBlank(message = "O valor do m2 no bairro não pode estar vazio.")
    @Size(max=13, message = "O comprimento máximo do valor do m2 não pode exceder 13 dígitos.")
    private BigDecimal value_district_m2;
    
    private List<RoomDTO> rooms;

    public PropertyDTO() {
    }

    public PropertyDTO(String prop_name, String prop_district, BigDecimal value_district_m2, List<RoomDTO> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.value_district_m2 = value_district_m2;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return this.prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return this.prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public BigDecimal getValue_district_m2() {
        return this.value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
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
            dto.getProp_district(), 
            dto.getValue_district_m2(), 
            dto.getRooms().stream().map(roomDTO -> new Room(roomDTO.getRoom_name(), roomDTO.getRoom_width(), roomDTO.getRoom_length())).collect(Collectors.toList())
        );
    }

    public static PropertyDTO convert(Property property){
        return new PropertyDTO(
            property.getProp_name(), 
            property.getProp_district(), 
            property.getValue_district_m2(), 
            property.getRooms().stream().map(roomDTO -> new RoomDTO(roomDTO.getRoom_name(), roomDTO.getRoom_width(), roomDTO.getRoom_length())).collect(Collectors.toList())
        );
    }
    
}
