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
public class ProcessInstanceCompletedEvent {

    private String processInstanceId;

    private Date endTime;

}
