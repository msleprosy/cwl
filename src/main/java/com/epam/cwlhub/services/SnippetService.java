package com.epam.cwlhub.services;

import com.epam.cwlhub.entities.snippet.Snippet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SnippetService extends BaseService<Snippet> {
    List<Snippet> findByGroupId(Long id);
    Snippet findByFileName(String fileName);
    boolean createSnippetObjectFromRequest(HttpServletRequest request) throws ServletException, IOException;
}
