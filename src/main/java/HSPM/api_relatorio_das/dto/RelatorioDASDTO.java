package HSPM.api_relatorio_das.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Data Transfer Object for Relatorio DAS")
public class RelatorioDASDTO {

    @Schema(description = "Unique identifier of the report")
    private Long id;

    @Schema(description = "Date of acolhimento", example = "2024-02-06T10:15:30")
    private LocalDateTime dtAcolhimento;

    @Schema(description = "Date of consultation", example = "2024-02-06T10:15:30")
    private LocalDateTime dtConsulta;

    @Schema(description = "Date of movement", example = "2024-02-06T10:15:30")
    private LocalDateTime dtMvto;

    @Schema(description = "Severity descriptor")
    private String gravidadeDescritor;

    @Schema(description = "Name of the professional")
    private String nmProfissional;

    @Schema(description = "Name of the patient")
    private String nmPaciente;

    @Schema(description = "Patient record number")
    private Integer nrProntuario;

    @Schema(description = "Consultation code")
    private Integer cdConsulta;

    @Schema(description = "Sector name")
    private String setor;

    @Schema(description = "Status of the ficha")
    private String statusFicha;

    @Schema(description = "Patient birth date", example = "1985-08-23")
    private LocalDate dtNascimento;

    @Schema(description = "Patient age")
    private Double idade;

    @Schema(description = "Previous consultation code")
    private Integer cdConsultaAnterior;

    // Construtor padrão necessário para serialização JSON
    public RelatorioDASDTO() {
    }

    // Construtor completo
    public RelatorioDASDTO(Long id, LocalDateTime dtAcolhimento, LocalDateTime dtConsulta, LocalDateTime dtMvto,
                           String gravidadeDescritor, String nmProfissional, String nmPaciente, Integer nrProntuario,
                           Integer cdConsulta, String setor, String statusFicha, LocalDate dtNascimento,
                           Double idade, Integer cdConsultaAnterior) {
        this.id = id;
        this.dtAcolhimento = dtAcolhimento;
        this.dtConsulta = dtConsulta;
        this.dtMvto = dtMvto;
        this.gravidadeDescritor = gravidadeDescritor;
        this.nmProfissional = nmProfissional;
        this.nmPaciente = nmPaciente;
        this.nrProntuario = nrProntuario;
        this.cdConsulta = cdConsulta;
        this.setor = setor;
        this.statusFicha = statusFicha;
        this.dtNascimento = dtNascimento;
        this.idade = idade;
        this.cdConsultaAnterior = cdConsultaAnterior;
    }
}

