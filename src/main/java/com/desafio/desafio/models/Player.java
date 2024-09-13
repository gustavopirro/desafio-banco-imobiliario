package com.desafio.desafio.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import com.desafio.desafio.enums.PlayerType;
import com.desafio.desafio.models.interfaces.PlayerInterface;
import com.desafio.desafio.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player implements PlayerInterface {

    private PlayerType playerType;

    private BigDecimal balance = new BigDecimal("300");
    
    private int position = 0;

    @JsonIgnore
    private boolean stillPlaying = true;
    
    private List<Property> properties = new ArrayList<>();

    public List<Property> getProperties() {
        // Return a copy to avoid direct manipulation
        return new ArrayList<>(properties);
    }

    public int rollDice(){
        return Utils.random.nextInt(6);
    }

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String toString() {
        return playerType.toString();
    }

    public void addProperty(Property property) {
        if(!properties.contains(property)){
            properties.add(property);
            property.setOwner(this);
        }
    }

    public void removeAllProperties() {
        for(Property property : this.properties)
            property.setOwner(null);

        this.properties.clear();
    }
    
}
