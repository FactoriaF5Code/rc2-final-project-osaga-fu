package com.lallamalaserstudio.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lallamalaserstudio.backend.controllers.TagResponse;
import com.lallamalaserstudio.backend.persistence.Tag;
import com.lallamalaserstudio.backend.persistence.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagResponse> getAllTags(){

        List<TagResponse> tags = new ArrayList<TagResponse>();

        List<Tag> tagsInDatabase = tagRepository.findAll();
        for (Tag tag : tagsInDatabase) {
            tags.add(new TagResponse(tag.getId(),tag.getName(), tag.getSize(), tag.getPrice(), tag.getPhotoUrl()));
        }

        return tags;
    }
    
}
