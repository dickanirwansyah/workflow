package co.id.bankmandiri.workflow.repository;

import co.id.bankmandiri.workflow.entity.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {
}
