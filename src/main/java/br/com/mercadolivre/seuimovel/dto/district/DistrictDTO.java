package br.com.mercadolivre.seuimovel.dto.district;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.mercadolivre.seuimovel.entities.district.District;

public class DistrictDTO {

    @NotNull(message = "É obrigatório informar o bairro da propriedade.")
    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max=45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @NotNull(message = "É obrigatório informar o valor do m2 no bairro.")
    @Min(value = 1, message = "O valor do m2 no bairro não pode estar vazio.")
    @DecimalMax(value = "9999999999.999", message = "O comprimento máximo do valor do m2 não pode exceder 13 dígitos.")
    private BigDecimal value_district_m2;

    public DistrictDTO() {
    }

    public DistrictDTO(String prop_district, BigDecimal value_district_m2) {
        this.prop_district = prop_district;
        this.value_district_m2 = value_district_m2;
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

    public static DistrictDTO convert(District d){
        return new DistrictDTO(d.getProp_district(), d.getValue_district_m2());
    }

    public static District convert (DistrictDTO d){
        return new District(d.getProp_district(), d.getValue_district_m2());
    }
    
}
