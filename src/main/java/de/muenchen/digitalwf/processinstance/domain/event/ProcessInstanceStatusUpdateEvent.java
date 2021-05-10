/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.digitalwf.processinstance.domain.event;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProcessInstanceStatusUpdateEvent {

    private String processInstanceId;

    private String statusKey;

}
