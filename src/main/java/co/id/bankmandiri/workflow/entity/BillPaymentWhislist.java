package co.id.bankmandiri.workflow.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_bill_payment_whislist")
public class BillPaymentWhislist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rs_id")
    private String rsId;

    @Column(name = "description")
    private String description;

    @Column(name = "rek_bank")
    private String rekBank;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "whislist")
    private String whislist;
}
