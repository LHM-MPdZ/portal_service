/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.shared;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(final String message) {
        super(message);
    }

}
