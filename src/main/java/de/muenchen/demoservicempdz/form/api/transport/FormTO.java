/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.api.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Form object.
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormTO {

    /**
     * Key of the form.
     */
    @NotBlank
    private String key;

    /**
     * description of the form.
     */
    private String description;

    /**
     * authorized groups.
     */
    private String authorizedGroups;

    /**
     * Buttons of the form.
     */
    private ButtonsTO buttons;

    /**
     * Sections of the form including all form fields.
     */
    @Size(min = 1, max = 200)
    private List<GroupTO> groups;
}
