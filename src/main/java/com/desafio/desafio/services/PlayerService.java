package com.desafio.desafio.services;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.players.CautiousPlayer;
import com.desafio.desafio.models.players.DemandingPlayer;
import com.desafio.desafio.models.players.ImpulsivePlayer;
import com.desafio.desafio.models.players.RandomPlayer;

@Service
public class PlayerService {
    
    public List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        
        players.add(new ImpulsivePlayer());
        players.add(new DemandingPlayer());
        players.add(new CautiousPlayer());
        players.add(new RandomPlayer());

        return players;
    }

    public boolean isBankrupt(Player player) {
        return player.getBalance().compareTo(BigDecimal.ZERO) < 0;
    }

    public void completeGameLap(Player player) {
        player.setPosition(0);
        player.getBalance().add(BigDecimal.valueOf(100));
    }
}
