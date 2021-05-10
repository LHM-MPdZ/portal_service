/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.form.infrastructure.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Entity representation of a form.
 *
 * @author externer.dl.horn
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Form")
@Table(name = "sp_form", indexes = { @Index(name = "idx_sp_formkey", columnList = "key_") })
public class FormEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_", unique = true, nullable = false, length = 36)
    private String id;

    @Column(name = "key_", nullable = false, unique = true)
    private String key;

    @Column(name = "version_", nullable = false)
    private String version;

    @Column(name = "config_", columnDefinition = "CLOB")
    private String config;
}
