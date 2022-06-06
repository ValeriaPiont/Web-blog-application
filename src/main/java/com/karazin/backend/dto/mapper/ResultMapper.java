package com.karazin.backend.dto.mapper;

import com.karazin.backend.dto.ResultDTO;
import com.karazin.backend.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResultMapper {

    @Mapping(source = "createdOn", target = "createdOn", dateFormat = "dd.MM.yyyy HH:mm:ss")
    ResultDTO postToResultDTO(Post post);

}
