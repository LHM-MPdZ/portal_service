package de.muenchen.demoservicempdz.processinstance.domain.mapper;

import de.muenchen.demoservicempdz.processinstance.domain.model.ProcessInstanceInfo;
import de.muenchen.demoservicempdz.processinstance.infrastructure.entity.ProcessInstanceInfoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProcessInstanceInfoMapper {

    ProcessInstanceInfoEntity map(ProcessInstanceInfo taskInfo);

    List<ProcessInstanceInfo> map(List<ProcessInstanceInfoEntity> list);

    ProcessInstanceInfo map(ProcessInstanceInfoEntity entity);

}
