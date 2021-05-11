/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.digitalwf.processinstance.domain.event;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProcessInstanceCreatedEvent {

    private String processInstanceId;

    private String processKey;

    private String processName;

    private String statusKey;

    private String assignee;

    private String description;

    private Date startTime;

}
