package br.com.mercadolivre.seuimovel.entities.property;

import java.util.List;

import br.com.mercadolivre.seuimovel.entities.district.District;
import br.com.mercadolivre.seuimovel.entities.room.Room;

public class Property {

    private String prop_name;
    private District district;
    
    private List<Room> rooms;

    public Property() {
    }

    public Property(String prop_name, District district, List<Room> rooms) {
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

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
}
