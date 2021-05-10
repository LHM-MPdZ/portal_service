/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.api.resource;

import de.muenchen.demoservicempdz.form.api.mapper.FormApiMapper;
import de.muenchen.demoservicempdz.form.api.transport.FormTO;
import de.muenchen.demoservicempdz.form.domain.model.Form;
import de.muenchen.demoservicempdz.form.domain.service.FormService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Rest API to handle forms.
 *
 * @author externer.dl.horn
 */
@Validated
@RestController
@Transactional
@RequestMapping("/rest/form")
@RequiredArgsConstructor
public class FormRestController {

    private final FormService formService;
    private final FormApiMapper formMapper;

    /**
     * Create a new form.
     *
     * @param to Form that should be created
     * @return form
     */
    @PostMapping
    public ResponseEntity<FormTO> createForm(@RequestBody @Valid final FormTO to) {
        final Form form = this.formMapper.map(to);
        val savedForm = this.formService.saveForm(form);
        final FormTO savedTO = this.formMapper.map(savedForm);
        return ResponseEntity.ok(savedTO);
    }

    /**
     * Get the form by key.
     *
     * @param formKey key of the form
     * @return form
     */
    @GetMapping("/{key}")
    public ResponseEntity<FormTO> getForm(@PathVariable("key") @NotBlank final String formKey) {
        val form = this.formService.getForm(formKey);
        final FormTO to = this.formMapper.map(form);
        return ResponseEntity.ok(to);
    }

}
