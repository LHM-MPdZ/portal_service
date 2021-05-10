/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.task.api.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Complete a task.
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompleteTaskTO {

    /**
     * Data of the task.
     */
    private Map<String, String> data;

}
