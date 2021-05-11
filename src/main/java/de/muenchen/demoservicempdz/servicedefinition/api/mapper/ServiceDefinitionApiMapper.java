/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.servicedefinition.api.mapper;

import de.muenchen.demoservicempdz.servicedefinition.api.transport.ServiceDefinitionTO;
import de.muenchen.demoservicempdz.servicedefinition.domain.model.ServiceDefinition;
import org.mapstruct.Mapper;

/**
 * Map between {@link ServiceDefinitionTO} and {@link ServiceDefinition}
 *
 * @author externer.dl.horn
 */
@Mapper
public interface ServiceDefinitionApiMapper {

    ServiceDefinitionTO map(ServiceDefinition serviceDefinition);

}
