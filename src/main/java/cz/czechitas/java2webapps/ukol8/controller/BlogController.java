package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final PostService service;

    @Autowired
    public BlogController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("seznam", service.findByPublishedBeforeAndPublishedNotNull());
    }

    @GetMapping("/{slug}")
    public ModelAndView detail (@PathVariable String slug, Pageable pageable) {
        return new ModelAndView("detail")
                .addObject("seznam", service.singlePost(slug, pageable));
    }

}
