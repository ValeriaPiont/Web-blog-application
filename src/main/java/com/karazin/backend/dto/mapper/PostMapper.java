package com.karazin.backend.dto.mapper;

import com.karazin.backend.dto.PostDTO;
import com.karazin.backend.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostMapper {

    Post postDTOToPost(PostDTO postDTO);

    PostDTO postToPostDTO(Post post);

}
