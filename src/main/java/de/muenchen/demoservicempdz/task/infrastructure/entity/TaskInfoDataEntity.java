package de.muenchen.demoservicempdz.task.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TaskInfoData")
@Table(name = "sp_task_info_data")
public class TaskInfoDataEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_", unique = true, nullable = false, length = 36)
    private String id;

    @Column(name = "key_", nullable = false)
    private String key;

    @Column(name = "value_")
    private String value;

}
