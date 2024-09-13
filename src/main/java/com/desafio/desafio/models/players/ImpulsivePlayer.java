package com.desafio.desafio.models.players;

import com.desafio.desafio.enums.PlayerType;
import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;

public class ImpulsivePlayer extends Player{

    @Override
    public boolean isBuyingProperty(Property property) {
        if(property.hasBuyoutBalance(this.getBalance())) 
            return true;
        return false;
    }

    public ImpulsivePlayer(){
        super(PlayerType.IMPULSIVO);
    }
}
