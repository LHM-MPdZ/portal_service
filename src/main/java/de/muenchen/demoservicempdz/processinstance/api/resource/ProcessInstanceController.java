/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processinstance.api.resource;

import de.muenchen.demoservicempdz.processinstance.api.mapper.ProcessInstanceApiMapper;
import de.muenchen.demoservicempdz.processinstance.api.transport.ProcessInstanceInfoTO;
import de.muenchen.demoservicempdz.processinstance.domain.service.ProcessInstanceService;
import de.muenchen.demoservicempdz.security.UserAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Api to interact with the process instances.
 *
 * @author externer.dl.horn
 */
@Validated
@RestController
@Transactional
@RequestMapping("/rest/processinstance")
@RequiredArgsConstructor
public class ProcessInstanceController {

    private final ProcessInstanceService taskService;
    private final ProcessInstanceApiMapper taskApiMapper;
    private final UserAuthentication userAuthentication;

    @GetMapping
    public ResponseEntity<List<ProcessInstanceInfoTO>> getAllTasks() {
        val processInstance = this.taskService.getAllProcessInstances(this.userAuthentication.getLoggedInUser());
        return ResponseEntity.ok(this.taskApiMapper.map(processInstance));
    }

}
