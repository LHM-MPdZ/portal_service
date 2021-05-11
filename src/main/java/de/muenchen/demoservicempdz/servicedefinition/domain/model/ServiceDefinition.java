/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.servicedefinition.domain.model;

import lombok.*;

/**
 * Configuration for a specific process definition.
 *
 * @author externer.dl.horn
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ServiceDefinition {

    /**
     * key of the process config.
     */
    private String key;

}
