package com.lallamalaserstudio.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lallamalaserstudio.backend.controllers.TagResponse;
import com.lallamalaserstudio.backend.persistence.Tag;
import com.lallamalaserstudio.backend.persistence.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

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
