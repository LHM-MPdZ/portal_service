package de.muenchen.demoservicempdz.task.domain.mapper;

import de.muenchen.demoservicempdz.task.domain.model.TaskInfo;
import de.muenchen.demoservicempdz.task.infrastructure.entity.TaskInfoDataEntity;
import de.muenchen.demoservicempdz.task.infrastructure.entity.TaskInfoEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper
public interface TaskInfoMapper {

    TaskInfoEntity map(TaskInfo taskInfo);

    List<TaskInfo> map(List<TaskInfoEntity> list);

    TaskInfo map(TaskInfoEntity entity);

    default List<TaskInfoDataEntity> mapData(final Map<String, String> data) {
        return data.entrySet()
                .stream()
                .map(obj -> TaskInfoDataEntity.builder()
                        .key(obj.getKey())
                        .value(obj.getValue())
                        .build()
                )
                .collect(Collectors.toList());
    }

    default Map<String, String> mapData(final List<TaskInfoDataEntity> data) {
        return data.stream()
                .collect(Collectors.toMap(TaskInfoDataEntity::getKey, TaskInfoDataEntity::getValue));
    }

}
