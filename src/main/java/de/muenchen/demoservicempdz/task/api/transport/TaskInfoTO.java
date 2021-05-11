/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.task.api.transport;

import de.muenchen.demoservicempdz.task.domain.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Map;

/**
 * Transport object of the {@link de.muenchen.demoservicempdz.task.domain.model.TaskInfo}
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskInfoTO {

    /**
     * Id of the task.
     */
    @NotBlank
    private String id;

    /**
     * Name of the task.
     */
    @NotBlank
    private String name;

    /**
     * Assignee of the task.
     */
    @NotBlank
    private String assignee;

    /**
     * Corresponding process instance of the task.
     */
    @NotBlank
    private String processInstanceId;

    /**
     * Status of the task.
     */
    @NotBlank
    private TaskStatus status;

    /**
     * Data of the task.
     */
    private Map<String, String> data;

    /**
     * Description of the task.
     */
    private String description;

    /**
     * Key of the corresponding form.
     */
    private String formKey;

    /**
     * Creation time of the task.
     */
    private Date creationTime;

}
