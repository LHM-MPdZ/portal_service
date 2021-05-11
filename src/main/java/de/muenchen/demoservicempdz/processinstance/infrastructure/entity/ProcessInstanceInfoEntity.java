package de.muenchen.demoservicempdz.processinstance.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "ProcessInstanceInfo")
@Table(name = "sp_process_instance_info")
public class ProcessInstanceInfoEntity {

    @Id
    @Column(name = "id_", nullable = false)
    private String id;

    @Column(name = "processKey_", nullable = false)
    private String processKey;

    @Column(name = "processName_", nullable = false)
    private String processName;

    @Column(name = "assignee_")
    private String assignee;

    @Column(name = "statusKey_")
    private String statusKey;

    @Column(name = "startTime_")
    private Date startTime;

    @Column(name = "endTime_")
    private Date endTime;

    @Column(name = "description_")
    private String description;

}
