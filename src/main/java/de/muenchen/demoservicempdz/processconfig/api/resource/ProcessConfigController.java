/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.api.resource;

import de.muenchen.demoservicempdz.processconfig.api.mapper.ProcessConfigApiMapper;
import de.muenchen.demoservicempdz.processconfig.api.transport.ProcessConfigTO;
import de.muenchen.demoservicempdz.processconfig.domain.service.ProcessConfigService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Rest Api to interact with the process configuration.
 *
 * @author externer.dl.horn
 */
@Validated
@RestController
@Transactional
@RequestMapping("/rest/processconfig")
@RequiredArgsConstructor
public class ProcessConfigController {

    private final ProcessConfigService processConfigService;

    //Mapper
    private final ProcessConfigApiMapper processConfigApiMapper;

    /**
     * Create a new Config.
     *
     * @param to process config that should be created
     * @return process config
     */
    @PostMapping
    public ResponseEntity<ProcessConfigTO> createConfig(@RequestBody @Valid final ProcessConfigTO to) {
        val processConfig = this.processConfigService.saveProcessConfig(this.processConfigApiMapper.map(to));
        return ResponseEntity.ok(this.processConfigApiMapper.map(processConfig));
    }

    /**
     * Get a process config by key
     *
     * @param configKey key of the process config
     * @return process config
     */
    @GetMapping("/{key}")
    public ResponseEntity<ProcessConfigTO> getConfig(@PathVariable("key") @NotBlank final String configKey) {
        val processConfig = this.processConfigService.getProcessConfig(configKey);
        return ResponseEntity.ok(this.processConfigApiMapper.map(processConfig));
    }

}
