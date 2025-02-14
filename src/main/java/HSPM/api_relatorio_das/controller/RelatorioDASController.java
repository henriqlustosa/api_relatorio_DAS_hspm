package HSPM.api_relatorio_das.controller;

import HSPM.api_relatorio_das.dto.RelatorioDASDTO;
import HSPM.api_relatorio_das.service.DatabaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioDASController {

    private final DatabaseService databaseService;

    public RelatorioDASController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Operation(
            summary = "List reports within a date range",
            description = "Retrieves a list of RelatorioDASDTO objects based on the provided date range."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of reports",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RelatorioDASDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid date range or format",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping
    public List<RelatorioDASDTO> listarRelatorios(
            @Parameter(description = "Start date in YYYY-MM-DD format", required = true)
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,

            @Parameter(description = "End date in YYYY-MM-DD format", required = true)
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        return databaseService.listarRelatoriosPorPeriodo(dataInicial, dataFinal);
    }
}

