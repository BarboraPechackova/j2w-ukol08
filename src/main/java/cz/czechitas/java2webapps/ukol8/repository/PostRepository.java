package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    Pageable ownPage = PageRequest.of(0, 20, Sort.by("published").descending());
    Pageable ownPage = PageRequest.of(0, 20);

    // Page<Post> findBySlug(String slug, Pageable pageable);
    Post findPostBySlug(String slug);

    Page<Post> findByPublishedBeforeAndPublishedNotNullOrderByPublishedDesc(LocalDate dateDo, Pageable ownPage);
    }