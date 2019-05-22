package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A MimeTypeModel.
 */
@Entity
@Table(name = "mime_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data class MimeTypeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "file_extension", nullable = false)
    private String fileExtension;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

}
