package co.id.bankmandiri.workflow.repository;

import co.id.bankmandiri.workflow.entity.BillPaymentWhislist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentWhislistRepository extends JpaRepository<BillPaymentWhislist, Long> {
}
