package de.muenchen.demoservicempdz.processinstance.api.mapper;

import de.muenchen.demoservicempdz.processinstance.api.transport.ProcessInstanceInfoTO;
import de.muenchen.demoservicempdz.processinstance.domain.model.ProcessInstanceInfo;
import de.muenchen.digitalwf.processinstance.domain.event.ProcessInstanceCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProcessInstanceApiMapper {

    ProcessInstanceInfoTO map(ProcessInstanceInfo taskInfo);

    List<ProcessInstanceInfoTO> map(List<ProcessInstanceInfo> list);

    @Mapping(source = "processInstanceId", target = "id")
    ProcessInstanceInfo mapProcessInstanceCreatedEvent(ProcessInstanceCreatedEvent event);

}
