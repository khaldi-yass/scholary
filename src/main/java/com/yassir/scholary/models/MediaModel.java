package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A MediaModel.
 */
@Entity
@Table(name = "medias")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class MediaModel extends ItemModel {

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

    @Column(name = "size")
    private Long size;

    @Column(name = "keywords")
    private String keywords;

    private String mimeType;

    private String fileExtension;

    @PodamExclude
    @ManyToOne
    @JsonIgnoreProperties("")
    private UserModel owner;
}
