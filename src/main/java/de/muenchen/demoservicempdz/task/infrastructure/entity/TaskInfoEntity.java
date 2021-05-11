package de.muenchen.demoservicempdz.task.infrastructure.entity;

import de.muenchen.demoservicempdz.task.domain.model.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "TaskInfo")
@Table(name = "sp_task_info")
public class TaskInfoEntity {

    @Id
    @Column(name = "id_", nullable = false)
    private String id;

    @Column(name = "name_", nullable = false)
    private String name;

    @Column(name = "assignee_", nullable = false)
    private String assignee;

    @Column(name = "processInstanceId_")
    private String processInstanceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_")
    private TaskStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id_")
    private List<TaskInfoDataEntity> data;

    @Column(name = "description_")
    private String description;

    @Column(name = "formKey_")
    private String formKey_;

    @Column(name = "creationTime_")
    private Date creationTime;

}
