package br.com.mercadolivre.seuimovel.dto.room;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class RoomDTO {

    @NotNull(message = "É obrigatório informar o nome do cômodo.")
    @NotBlank(message = "O nome do cômodo não pode estar vazio.")
    @Size(max=30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String room_name;

    @NotNull(message = "É obrigatório informar a largura do cômodo.")
    @Min(value = 1, message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value = "25.0", message = "A largura máxima permitida por cômodo é de 25 metros.")
    private double room_width;

    @NotNull(message = "É obrigatório informar o comprimento do cômodo.")
    @Min(value = 1, message = "O comprimento do cômodo não pode estar vazio.")
    @DecimalMax(value = "33.0", message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double room_length;

    public RoomDTO() {
    }
    
    public RoomDTO(String room_name, double room_width, double room_length) {
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

    public double getM2(){
        return this.room_width*this.room_length; 
    }

}

