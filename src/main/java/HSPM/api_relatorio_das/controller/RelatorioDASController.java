package HSPM.api_relatorio_das.controller;

import HSPM.api_relatorio_das.dto.RelatorioDASDTO;
import HSPM.api_relatorio_das.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioDASController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping
    public List<RelatorioDASDTO> listarRelatorios(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return databaseService.listarRelatoriosPorPeriodo(dataInicial, dataFinal);
    }
}

