package com.desafio.desafio.models.players;

import java.math.BigDecimal;

import com.desafio.desafio.enums.PlayerType;
import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;

import lombok.Builder;

@Builder
public class CautiousPlayer extends Player{

    @Override
    public boolean isBuyingProperty(Property property) {
        boolean hasMinimumBalance = this.getBalance().subtract(property.getBuyoutPrice()).compareTo(new BigDecimal(80)) >= 0;
        if (property.hasBuyoutBalance(this.getBalance()) && hasMinimumBalance)
            return true;
        return false;
    }

    public CautiousPlayer(){
        super(PlayerType.CAUTELOSO);
    }
    
}
