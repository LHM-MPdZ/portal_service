/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.api.mapper;

import de.muenchen.demoservicempdz.processconfig.api.transport.ProcessConfigTO;
import de.muenchen.demoservicempdz.processconfig.domain.model.ProcessConfig;
import org.mapstruct.Mapper;

/**
 * Map between {@link ProcessConfigTO} and {@link ProcessConfig}
 *
 * @author externer.dl.horn
 */
@Mapper
public interface ProcessConfigApiMapper {

    ProcessConfigTO map(ProcessConfig config);

    ProcessConfig map(ProcessConfigTO processConfigTO);

}
