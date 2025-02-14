package HSPM.api_relatorio_das.service;

import HSPM.api_relatorio_das.dto.RelatorioDASDTO;
import HSPM.api_relatorio_das.repository.RelatorioDASRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class DatabaseService {

    private final RelatorioDASRepository relatorioDASRepository;
    // ✅ Variável declarada corretamente no escopo da classe
    private static final AtomicLong idGenerator = new AtomicLong(1000); // Começa em 1000
    @Autowired
    public DatabaseService(RelatorioDASRepository relatorioDASRepository) {
        this.relatorioDASRepository = relatorioDASRepository;
    }

    public List<RelatorioDASDTO> listarRelatoriosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        // Converter LocalDate para Date para consulta no banco
        Instant inicioInstant = dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant fimInstant = dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant();

        List<Object[]> resultados = relatorioDASRepository.buscarRelatoriosPorPeriodo(
                Date.from(inicioInstant), Date.from(fimInstant));

        return resultados.stream().map(obj -> {
            // Obtém o ID dinamicamente, garantindo que não seja null
            Long id = generateId();

            return new RelatorioDASDTO(
                    id, // ID obtido dinamicamente
                    convertToLocalDateTime(obj[0]), // dtAcolhimento
                    convertToLocalDateTime(obj[1]), // dtConsulta
                    convertToLocalDateTime(obj[2]), // dtMvto
                    (String) obj[3],  // gravidadeDescritor
                    (String) obj[4],  // nmProfissional
                    (String) obj[5],  // nmPaciente
                    (Integer) obj[6], // nrProntuario
                    (Integer) obj[7], // cdConsulta
                    (String) obj[8],  // setor
                    (String) obj[9], // statusFicha
                    convertToLocalDate(obj[10]),  // dtNascimento
                    (Double) obj[11], // idade
                    (Integer) obj[12] // cdConsultaAnterior
            );
        }).collect(Collectors.toList());
    }

    // Métodos auxiliares para conversão de datas
    private LocalDateTime convertToLocalDateTime(Object obj) {
        return (obj != null) ? ((Date) obj).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

    private LocalDate convertToLocalDate(Object obj) {
        if (obj == null) {
            return null;
        }


        if (obj instanceof java.sql.Date) {
            return ((java.sql.Date) obj).toLocalDate();
        }

        throw new IllegalArgumentException("Objeto não pode ser convertido para LocalDate: " + obj.getClass());

    }
    // Método para gerar um ID caso não venha do banco
    private Long generateId() {
        return idGenerator.incrementAndGet(); // Incrementa e retorna o ID
    }
}

