package com.desafio.desafio.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;
import com.desafio.desafio.utils.Utils;

@Service
public class PropertyService {
    

    public List<Property> createProperties() {
        List<Property> properties = new ArrayList<>();
        
        for (int i = 0; i < 20; i++)
            properties.add(create());
        
        return properties;
    }

    public Property create(){
        Property property = new Property();
        property.setBuyoutPrice(calculateBuyoutPrice());
        property.setRentPrice(calculateRentPrice(property));
        return property;
    }

    public boolean hasOwner(Property property) {
        return property.getOwner() != null;
    }

    public void payRent(Property property, Player propertyRenter) {
        Player propertyOwner = property.getOwner();
        
        propertyRenter.setBalance(propertyRenter.getBalance().subtract(property.getRentPrice()));
        propertyOwner.setBalance(propertyOwner.getBalance().add(property.getRentPrice()));
    }

    public void buyProperty(Property property, Player player) {
        // Assume que jogador pode ficar com saldo negativo segundo regras do desafio.
        player.setBalance(player.getBalance().subtract(property.getBuyoutPrice()));
        player.addProperty(property);
    }

    private BigDecimal calculateRentPrice(Property property) {
        return property.getBuyoutPrice().multiply(new BigDecimal("0.10"));
    }

    private BigDecimal calculateBuyoutPrice() {
        double doubleValue = Utils.random.nextDouble(100, 200);
        return new BigDecimal(doubleValue);
    }
}
