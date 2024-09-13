package com.desafio.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.dtos.GameResultDTO;
import com.desafio.desafio.services.GameService;

@RequestMapping("/jogo")
@RestController
public class GameController {
    
    @Autowired
    GameService gameService;

    @GetMapping("/simular")
    public ResponseEntity<GameResultDTO> simulateGame() {
        return ResponseEntity.ok(gameService.simulateGame());
    }
}
