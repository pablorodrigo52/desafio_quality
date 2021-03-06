package br.com.mercadolivre.seuimovel.entities.room;

public class Room {

    private String room_name;
    private double room_width;
    private double room_length;

    public Room() {
    }
    
    public Room(String room_name, double room_width, double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public String getRoom_name() {
        return this.room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_width() {
        return this.room_width;
    }

    public void setRoom_width(double room_width) {
        this.room_width = room_width;
    }

    public double getRoom_length() {
        return this.room_length;
    }

    public void setRoom_length(double room_length) {
        this.room_length = room_length;
    }

}

