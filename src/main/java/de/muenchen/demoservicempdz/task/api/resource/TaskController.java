/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.task.api.resource;

import de.muenchen.demoservicempdz.security.UserAuthentication;
import de.muenchen.demoservicempdz.task.api.mapper.TaskApiMapper;
import de.muenchen.demoservicempdz.task.api.transport.CompleteTaskTO;
import de.muenchen.demoservicempdz.task.api.transport.TaskInfoTO;
import de.muenchen.demoservicempdz.task.domain.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest Api to interact with the tasks.
 *
 * @author externer.dl.horn
 */
@Validated
@RestController
@Transactional
@RequestMapping("/rest/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskApiMapper taskApiMapper;
    private final UserAuthentication userAuthentication;

    @GetMapping
    public ResponseEntity<List<TaskInfoTO>> getAllTasks() {
        val tasks = this.taskService.getAllTasks(this.userAuthentication.getLoggedInUser());
        return ResponseEntity.ok(this.taskApiMapper.map(tasks));
    }

    @GetMapping("/{processinstanceId}")
    public ResponseEntity<List<TaskInfoTO>> getAllTasks(@PathVariable("processinstanceId") final String processinstanceId) {
        val tasks = this.taskService.getAllTasksByProcessInstance(this.userAuthentication.getLoggedInUser(), processinstanceId);
        return ResponseEntity.ok(this.taskApiMapper.map(tasks));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable("id") final String taskId, @RequestBody @Valid final CompleteTaskTO completeTaskTO) {
        this.taskService.completeTask(this.userAuthentication.getLoggedInUser(), taskId, completeTaskTO.getData());
        return ResponseEntity.ok().build();
    }

}
