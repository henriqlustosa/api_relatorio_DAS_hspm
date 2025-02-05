package HSPM.api_relatorio_das.repository.impl;

import HSPM.api_relatorio_das.repository.RelatorioDASRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RelatorioDASRepositoryImpl implements RelatorioDASRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> buscarRelatoriosPorPeriodo(Date dataInicial, Date dataFinal) {
        String sql = """
            SELECT dt_acolhimento, dt_consulta, dt_mvto, gravidade_descritor, 
                   nm_profissional, nm_paciente, nr_prontuario, cd_consulta, 
                   setor, status_ficha, dt_nascimento, idade, cd_consulta_anterior
            FROM agh.v_relatorio_das_hspm
            WHERE dt_consulta BETWEEN :dataInicial AND :dataFinal
            ORDER BY cd_consulta DESC, dt_consulta DESC, dt_mvto DESC
        """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);

        return query.getResultList();
    }
}
