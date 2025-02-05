package HSPM.api_relatorio_das.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class RelatorioDASDTO {

    private Long id;
    private Date dtAcolhimento;
    private Date dtConsulta;
    private Date dtMvto;
    private String gravidadeDescritor;
    private String nmProfissional;
    private String nmPaciente;
    private Integer nrProntuario;
    private Integer cdConsulta;
    private String setor;
    private String statusFicha;
    private Date dtNascimento;
    private Double idade;
    private Integer cdConsultaAnterior;

    // Construtor
    public RelatorioDASDTO(Long id, Date dtAcolhimento, Date dtConsulta, Date dtMvto, String gravidadeDescritor,
                           String nmProfissional, String nmPaciente, Integer nrProntuario, Integer cdConsulta,
                           String setor, String statusFicha, Date dtNascimento, Double idade, Integer cdConsultaAnterior) {
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
