/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.api.mapper;

import de.muenchen.demoservicempdz.form.api.transport.FormTO;
import de.muenchen.demoservicempdz.form.domain.model.Form;
import org.mapstruct.Mapper;

/**
 * Map between {@link FormTO} and {@link Form}
 *
 * @author externer.dl.horn
 */
@Mapper
public interface FormApiMapper {

    Form map(FormTO form);

    FormTO map(Form form);

}
