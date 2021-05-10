package de.muenchen.demoservicempdz.task.domain.model;

import lombok.*;

import java.util.Map;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class TaskInfo {

    private final String id;

    private final String name;

    private final String assignee;

    private final String processInstanceId;

    private TaskStatus status;

    private final Map<String, String> data;

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

}
