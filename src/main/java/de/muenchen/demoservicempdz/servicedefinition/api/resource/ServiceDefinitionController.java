/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.servicedefinition.api.resource;

import de.muenchen.demoservicempdz.servicedefinition.api.transport.StartServiceTO;
import de.muenchen.demoservicempdz.servicedefinition.domain.service.ServiceDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Rest Api to interact with the service definition.
 *
 * @author externer.dl.horn
 */
@Validated
@RestController
@Transactional
@RequestMapping("/rest/servicedefinition")
@RequiredArgsConstructor
public class ServiceDefinitionController {

    private final ServiceDefinitionService serviceDefinitionService;

    //    private final ServiceDefinitionApiMapper processConfigApiMapper;

    /**
     * Start a service with the given data.
     *
     * @param to start service data
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> startService(@RequestBody @Valid final StartServiceTO to) {
        this.serviceDefinitionService.startService(to.getKey(), to.getData());
        return ResponseEntity.ok().build();
    }

}
