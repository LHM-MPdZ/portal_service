package de.muenchen.demoservicempdz.processinstance.domain.model;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProcessInstanceInfo {

    private final String id;

    private final String processKey;

    private final String processName;

    private final String assignee;

    private final Date startTime;

    private final Date endTime;

}
