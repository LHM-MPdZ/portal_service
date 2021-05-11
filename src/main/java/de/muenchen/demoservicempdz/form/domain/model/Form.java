/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.domain.model;

import lombok.*;

import java.util.List;

/**
 * Form object.
 * Used for backend validation of the completed forms.
 *
 * @author externer.dl.horn
 */
@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Form {

    /**
     * Key of the form.
     */
    private final String key;

    /**
     * description of the form.
     */
    private final String description;

    /**
     * authorized groups.
     */
    private final String authorizedGroups;

    /**
     * Buttons of the form.
     */
    private final Buttons buttons;

    /**
     * Sections of the form including all form fields.
     */
    private final List<Group> groups;

}
