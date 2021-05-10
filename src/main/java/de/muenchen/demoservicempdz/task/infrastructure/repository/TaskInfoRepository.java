package de.muenchen.demoservicempdz.task.infrastructure.repository;

import de.muenchen.demoservicempdz.task.infrastructure.entity.TaskInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskInfoRepository extends JpaRepository<TaskInfoEntity, String> {

    List<TaskInfoEntity> findAllByProcessInstanceId(String processInstanceId);
}
