package co.id.bankmandiri.workflow.repository;

import co.id.bankmandiri.workflow.entity.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
