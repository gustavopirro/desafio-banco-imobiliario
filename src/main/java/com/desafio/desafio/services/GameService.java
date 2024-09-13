package com.desafio.desafio.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.dtos.GameResultDTO;
import com.desafio.desafio.models.Player;
import com.desafio.desafio.models.Property;

@Service
public class GameService {

    @Autowired
    PlayerService playerService;

    @Autowired
    PropertyService propertyService;

    private final int BOARD_MAX_SIZE = 19;
    private final int GAME_MAX_ROUNDS = 1000;

    public GameResultDTO simulateGame() {

        List<Player> players = playerService.createPlayers();
        List<Property> properties = propertyService.createProperties();

        int currentRound = 0;
        boolean gameOver = false;

        while (!gameOver && currentRound < GAME_MAX_ROUNDS) {

            for (Player player : players) {

                if(!player.isStillPlaying()){
                    continue;
                }

                if(isGameOver(players)){
                    handleBankruptPlayers(players);
                    gameOver = true;
                    break;
                }

                int newPosition = drawPosition(player);
                player.setPosition(newPosition);
                Property currentProperty = properties.get(newPosition);

                if(propertyService.hasOwner(currentProperty) && currentProperty.getOwner() != player)
                    propertyService.payRent(currentProperty, player);

                else if(player.isBuyingProperty(currentProperty))
                    propertyService.buyProperty(currentProperty, player);
                
                if(newPosition == BOARD_MAX_SIZE)
                    playerService.completeGameLap(player);

                handleBankruptPlayers(players);
                
            }
            
            currentRound++;
        }

        return getResultDTO(sortPlayers(players), currentRound);
    }

    private List<Player> sortPlayers(List<Player> players){
        Collections.sort(players, (p1, p2) -> p2.getBalance().compareTo(p1.getBalance()));
        return players;
    }
    private void handleBankruptPlayers(List<Player> players) {
        players.forEach( p -> {
            if(p.isStillPlaying() && playerService.isBankrupt(p)){
                p.setStillPlaying(false);
                p.removeAllProperties();
            }
        });
    }

    private int drawPosition(Player player) {
        int newPosition = player.rollDice() + player.getPosition();
        
        if(newPosition > BOARD_MAX_SIZE)
            return BOARD_MAX_SIZE;

        return newPosition;
    }

    private Player getWinner(List<Player> players) {
        BigDecimal max = new BigDecimal(0);
        Player winner = null;

        for (Player p : players) {
            if (p.getBalance().compareTo(max) == 1){
                max = p.getBalance();
                winner = p;
            }
        }

        return winner;
    }

    private boolean isGameOver(List<Player> players) {
        int validPlayers = 0;

        for (Player p : players) {
            if (!playerService.isBankrupt(p))
                validPlayers++;
        }

        return validPlayers == 1;
    }

    private GameResultDTO getResultDTO(List<Player> players, int currentRound) {
        Player winner = getWinner(players);

        return GameResultDTO
        .builder()
        .vencedor(winner.getPlayerType().name())
        .jogadores(players.stream().map(Player::toString).collect(Collectors.toList()))
        .quantidadeDePropriedadesDoVencedor(winner.getProperties().size())
        .quantidadeDeRodadas(currentRound)
        .build();
    }
}
