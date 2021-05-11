/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.domain.service;

import de.muenchen.demoservicempdz.processconfig.domain.mapper.ProcessConfigMapper;
import de.muenchen.demoservicempdz.processconfig.domain.model.ProcessConfig;
import de.muenchen.demoservicempdz.processconfig.infrastructure.repository.ProcessConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * Service to interact with the {@link ProcessConfig}
 *
 * @author externer.dl.horn
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessConfigService {

    private final ProcessConfigMapper processConfigMapper;
    private final ProcessConfigRepository processConfigJpaRepository;

    /**
     * Get process config by key.
     *
     * @param key key of the process config
     * @return process config
     */
    public ProcessConfig getProcessConfig(final String key) {
        val entity = this.processConfigJpaRepository.findByKey(key)
                .orElseThrow(() -> new IllegalArgumentException(String.format("The process config with the key %s is not available", key)));
        return this.processConfigMapper.map(entity);
    }

    /**
     * Save a process config.
     *
     * @param processConfig process config that is saved
     * @return process config
     */
    public ProcessConfig saveProcessConfig(final ProcessConfig processConfig) {
        val entity = this.processConfigJpaRepository.findByKey(processConfig.getKey());
        val newEntity = this.processConfigMapper.map2Entity(processConfig);
        entity.ifPresent(formEntity -> newEntity.setId(formEntity.getId()));
        val savedEntity = this.processConfigJpaRepository.save(newEntity);
        log.info("process config deployed: {}", savedEntity);

        return this.processConfigMapper.map(savedEntity);
    }
}