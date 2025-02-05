package HSPM.api_relatorio_das.service;

import HSPM.api_relatorio_das.dto.RelatorioDASDTO;
import HSPM.api_relatorio_das.repository.RelatorioDASRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class DatabaseService {

    private final RelatorioDASRepository relatorioDASRepository;

    @Autowired
    public DatabaseService(RelatorioDASRepository relatorioDASRepository) {
        this.relatorioDASRepository = relatorioDASRepository;
    }

    // Gerador de ID incremental via API
    private final AtomicLong contador = new AtomicLong(1);

    public List<RelatorioDASDTO> listarRelatoriosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        Date dataInicioConvertida = Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFinalConvertida = Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Object[]> resultados = relatorioDASRepository.buscarRelatoriosPorPeriodo(dataInicioConvertida, dataFinalConvertida);

        return resultados.stream().map(obj ->
                new RelatorioDASDTO(
                        contador.getAndIncrement(),
                        (Date) obj[0], (Date) obj[1], (Date) obj[2], (String) obj[3],
                        (String) obj[4], (String) obj[5], (Integer) obj[6], (Integer) obj[7],
                        (String) obj[8], (String) obj[9], (Date) obj[10], (Double) obj[11],
                        (Integer) obj[12]
                )
        ).collect(Collectors.toList());
    }
}
