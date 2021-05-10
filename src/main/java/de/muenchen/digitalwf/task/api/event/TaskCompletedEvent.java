/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.digitalwf.task.api.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TaskCompletedEvent {

    private final String taskId;

    private final Map<String, String> data;

}
