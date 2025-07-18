package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.dto.ResgatePorFuncionario;
import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/resgates")
public class ResgateController {

    private final AnimalRepository repository;

    public ResgateController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/por-funcionario")
    public List<ResgatePorFuncionario> getResgatesPorFuncionario(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {

        if (ChronoUnit.DAYS.between(inicio, fim) > 365) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Intervalo máximo de 1 ano.");
        }

        return repository.countResgatesPorFuncionario(Date.valueOf(inicio), Date.valueOf(fim));
    }
}
