/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.digitalwf.task.domain.event;

import lombok.*;

import java.util.Date;
import java.util.Map;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreatedEvent {

    private String taskId;

    private String taskName;

    private String taskAssignee;

    private String processInstanceId;

    private Date creationTime;

    private String description;

    private String formKey;

    private Map<String, String> data;

}
