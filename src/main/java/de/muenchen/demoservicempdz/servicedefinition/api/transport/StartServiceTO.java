/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.servicedefinition.api.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Transport object of the {@link de.muenchen.demoservicempdz.servicedefinition.domain.model.ServiceDefinition}
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StartServiceTO {

    /**
     * Key of the service definition.
     */
    @NotBlank
    private String key;

    /**
     * Data to start the service.
     */
    private Map<String, String> data;

}
