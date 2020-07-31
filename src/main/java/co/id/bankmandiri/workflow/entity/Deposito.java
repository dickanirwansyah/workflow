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
@Table(name = "mst_deposito")
public class Deposito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "rs_id")
    private String rsId;

    @Column(name = "rek_no")
    private String rekNo;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "status")
    private String status;
}
