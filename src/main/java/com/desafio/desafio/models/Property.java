package com.desafio.desafio.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Property {  

    private BigDecimal buyoutPrice;

    private BigDecimal rentPrice;

    @JsonIgnore
    private Player owner;

    public boolean hasBuyoutBalance(BigDecimal balance) {
        return this.getBuyoutPrice().compareTo(balance) <= 0;
    }
    
}
