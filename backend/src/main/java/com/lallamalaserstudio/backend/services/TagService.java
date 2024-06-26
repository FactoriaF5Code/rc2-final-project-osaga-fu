package com.lallamalaserstudio.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lallamalaserstudio.backend.controllers.tag.TagResponse;
import com.lallamalaserstudio.backend.persistence.tag.TagRepository;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(@Autowired TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream()
                .map(TagResponse::from)
                .collect(Collectors.toList());
    }

    public TagResponse getTagById(Long id) {

        return tagRepository.findById(id)
                .map(TagResponse::from)
                .orElse(null);

    }

}
