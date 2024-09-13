package com.desafio.desafio.models.players;

import java.math.BigDecimal;

import com.desafio.desafio.enums.PlayerType;
import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;

public class DemandingPlayer extends Player {

    @Override
    public boolean isBuyingProperty(Property property) {

        if(property.hasBuyoutBalance(this.getBalance()) && propertyAbove50Balance(property))
            return true;
        return false;
    }

    public DemandingPlayer(){
        super(PlayerType.EXIGENTE);
    }

    private boolean propertyAbove50Balance(Property property) {
        return property.getBuyoutPrice().compareTo(new BigDecimal(50)) == 1;
    }
}
