package com.desafio.desafio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RedirectController {

    private static final String TARGET_ENDPOINT = "/jogo/simular";

    @RequestMapping("/")
    public void redirectToServices(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect(TARGET_ENDPOINT);
    }
}
