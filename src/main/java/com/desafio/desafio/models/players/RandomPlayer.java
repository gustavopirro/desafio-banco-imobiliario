package com.desafio.desafio.models.players;

import com.desafio.desafio.enums.PlayerType;
import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;
import com.desafio.desafio.utils.Utils;

public class RandomPlayer extends Player {

    @Override
    public boolean isBuyingProperty(Property property) {
        // Buys with 50% chance
        if(property.hasBuyoutBalance(this.getBalance()) && Utils.random.nextInt(1) == 0)
            return true;
        return false;
    }
    
    public RandomPlayer(){
        super(PlayerType.ALEATORIO);
    }
}
