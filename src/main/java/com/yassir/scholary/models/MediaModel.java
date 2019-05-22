package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A MediaModel.
 */
@Entity
@Table(name = "media")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class MediaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "full_path")
    private String fullPath;

    @Column(name = "alt_text")
    private String altText;

    @Column(name = "real_file_name")
    private String realFileName;

    @Column(name = "jhi_size")
    private Long size;

    @Column(name = "keywords")
    private String keywords;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private MimeTypeModel mimeTypeModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private UserModel owner;
}
