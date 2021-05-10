package de.muenchen.demoservicempdz.processinstance.infrastructure.repository;

import de.muenchen.demoservicempdz.processinstance.infrastructure.entity.ProcessInstanceInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessInstanceInfoRepository extends JpaRepository<ProcessInstanceInfoEntity, String> {
}
