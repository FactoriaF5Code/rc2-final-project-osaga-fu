package com.lallamalaserstudio.backend;

import com.lallamalaserstudio.backend.controllers.tag.TagResponse;
import com.lallamalaserstudio.backend.services.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TagService tagService;

    @Test
    public void testGetAllTags() throws Exception {

        TagResponse tag1 = new TagResponse(1L, "Focus Star", "11x11cm", 7.0, "photo", "description");
        TagResponse tag2 = new TagResponse(2L, "Filter Tag", "3.5x1.5cm", 1.8, "photo2", "description2");
        List<TagResponse> tagList = Arrays.asList(tag1, tag2);

        when(tagService.getAllTags()).thenReturn(tagList);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Focus Star"))
                .andExpect(jsonPath("$[0].size").value("11x11cm"))
                .andExpect(jsonPath("$[0].price").value(7.0))
                .andExpect(jsonPath("$[0].photoUrl").value("photo"))
                .andExpect(jsonPath("$[0].description").value("description"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Filter Tag"))
                .andExpect(jsonPath("$[1].size").value("3.5x1.5cm"))
                .andExpect(jsonPath("$[1].price").value(1.8))
                .andExpect(jsonPath("$[1].photoUrl").value("photo2"))
                .andExpect(jsonPath("$[1].description").value("description2"));

    }

    @Test
    public void testGetTagById() throws Exception {

        TagResponse tag1 = new TagResponse(1L, "Focus Star", "11x11cm", 7.0, "photo", "description");

        when(tagService.getTagById(tag1.getId())).thenReturn(tag1);

        mockMvc.perform(get("/api/products/{id}", tag1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Focus Star"))
                .andExpect(jsonPath("$.size").value("11x11cm"))
                .andExpect(jsonPath("$.price").value(7.0))
                .andExpect(jsonPath("$.photoUrl").value("photo"))
                .andExpect(jsonPath("$.description").value("description"));
    }
}
