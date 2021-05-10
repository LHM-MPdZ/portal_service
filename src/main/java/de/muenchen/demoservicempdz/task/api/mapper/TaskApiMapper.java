package de.muenchen.demoservicempdz.task.api.mapper;

import de.muenchen.demoservicempdz.task.api.transport.TaskInfoTO;
import de.muenchen.demoservicempdz.task.domain.model.TaskInfo;
import de.muenchen.digitalwf.task.domain.event.TaskCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TaskApiMapper {

    TaskInfoTO map(TaskInfo taskInfo);

    List<TaskInfoTO> map(List<TaskInfo> list);

    @Mapping(source = "taskName", target = "name")
    @Mapping(source = "taskId", target = "id")
    @Mapping(source = "taskAssignee", target = "assignee")
    TaskInfo mapTaskCreatedEvent(TaskCreatedEvent event);

}
