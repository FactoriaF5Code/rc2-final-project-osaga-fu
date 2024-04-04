package com.lallamalaserstudio.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lallamalaserstudio.backend.services.TagService;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin("http://localhost:5173")
public class TagController {
    
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagResponse> getAllTags(){
        return tagService.getAllTags();
    }
}
