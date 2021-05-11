/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.domain.service;

import de.muenchen.demoservicempdz.form.domain.mapper.FormMapper;
import de.muenchen.demoservicempdz.form.domain.model.Form;
import de.muenchen.demoservicempdz.form.infrastructure.repository.FormRepository;
import de.muenchen.demoservicempdz.shared.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * Service to interact with {@link Form}
 *
 * @author externer.dl.horn
 */
@Slf4j
@Service("digitalWfFormService")
@RequiredArgsConstructor
public class FormService {

    private final FormMapper formMapper;
    private final FormRepository formRepository;

    /**
     * Get a form by key.
     *
     * @param formkey key of the form
     * @return form
     */
    public Form getForm(final String formkey) {
        //TODO authorization check
        val entity = this.formRepository.findByKey(formkey)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("The form with the key %s is not available", formkey)));
        return this.formMapper.map(entity);
    }

    /**
     * Save a From.
     *
     * @param form form that is saved
     * @return form
     */
    public Form saveForm(final Form form) {
        val entity = this.formRepository.findByKey(form.getKey());
        val newEntity = this.formMapper.map2Entity(form);
        entity.ifPresent(formEntity -> newEntity.setId(formEntity.getId()));
        val savedEntity = this.formRepository.save(newEntity);
        log.info("Form deployed: {}", savedEntity);

        return this.formMapper.map(savedEntity);
    }

}
