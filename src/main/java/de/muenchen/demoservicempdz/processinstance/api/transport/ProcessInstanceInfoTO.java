/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processinstance.api.transport;

import de.muenchen.demoservicempdz.processinstance.domain.model.ProcessInstanceInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Transport object of the {@link ProcessInstanceInfo}
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessInstanceInfoTO {

    /**
     * Id of the process instance.
     */
    @NotBlank
    private String id;

    /**
     * Key of the corresponding process.
     */
    @NotBlank
    private String processKey;

    /**
     * Name of the corresponding process.
     */
    @NotBlank
    private String processName;

    /**
     * Assignee of the process instance.
     */
    @NotBlank
    private String assignee;

    /**
     * Assignee of the process instance.
     */
    @NotBlank
    private String status;

    /**
     * Assignee of the process instance.
     */
    @NotBlank
    private String statusKey;

    /**
     * Start time of the instance.
     */
    private Date startTime;

    /**
     * End time of the instance.
     */
    private Date endTime;

}
