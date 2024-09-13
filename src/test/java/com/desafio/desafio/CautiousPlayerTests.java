package com.desafio.desafio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.desafio.desafio.models.Property;
import com.desafio.desafio.models.players.CautiousPlayer;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CautiousPlayerTest {

    private CautiousPlayer cautiousPlayer;
    private Property property;

    @BeforeEach
    void setUp() {
        cautiousPlayer = new CautiousPlayer();
        property = new Property();
        property.setBuyoutPrice(new BigDecimal(100));
    }

    @Test
    void shouldReturnTrueWhenPlayerHasSufficientBalanceAndCanAffordTheProperty() {
        // Arrange
        cautiousPlayer.setBalance(new BigDecimal(200));
        property.setBuyoutPrice(new BigDecimal(50));

        // Act
        boolean result = cautiousPlayer.isBuyingProperty(property);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenPlayerDoesNotHaveSufficientBalance() {
        // Arrange
        cautiousPlayer.setBalance(new BigDecimal(30));
        property.setBuyoutPrice(new BigDecimal(50));

        // Act
        boolean result = cautiousPlayer.isBuyingProperty(property);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseWhenPlayerCannotAffordThePropertyEvenWithSufficientBalance() {
        // Arrange
        cautiousPlayer.setBalance(new BigDecimal(150));
        property.setBuyoutPrice(new BigDecimal(200));

        // Act
        boolean result = cautiousPlayer.isBuyingProperty(property);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseWhenPlayerCannotAffordThePropertyAndDoesNotHaveSufficientBalance() {
        // Arrange
        cautiousPlayer.setBalance(new BigDecimal(20));
        property.setBuyoutPrice(new BigDecimal(200));

        // Act
        boolean result = cautiousPlayer.isBuyingProperty(property);

        // Assert
        assertThat(result).isFalse();
    }
}