package br.com.mercadolivre.seuimovel.dto.room;

public class RoomM2DTO {
    
    private String name;
    private double m2;


    public RoomM2DTO() {
    }

    public RoomM2DTO(String name, double m2) {
        this.name = name;
        this.m2 = m2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getM2() {
        return this.m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

}
