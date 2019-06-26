package com.yassir.scholary.coremodule.dtos;

import lombok.Data;

public @Data
class MediaDto {

    private String name;
    private String url;
    private String realFileName;
    private Long size;
    private String keywords;
    private String fileExtension;

}
