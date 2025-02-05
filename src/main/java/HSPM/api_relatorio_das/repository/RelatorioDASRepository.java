package HSPM.api_relatorio_das.repository;

import java.util.Date;
import java.util.List;

public interface RelatorioDASRepository {
    List<Object[]> buscarRelatoriosPorPeriodo(Date dataInicial, Date dataFinal);
}
