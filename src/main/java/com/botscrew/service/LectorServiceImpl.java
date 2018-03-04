package com.botscrew.service;

import com.botscrew.Repository.LecturerRepository;
import com.botscrew.entity.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    private LecturerRepository lecturerRepository;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public String findByRegex(String searchString) {
        List<Lector> lectors = lecturerRepository.findByNameContainingOrSurnameContaining(searchString, searchString);

        String searchResult = lectors.stream()
                .map(lector -> String.format("%s %s", lector.getName(), lector.getSurname()))
                .collect(Collectors.joining(",  "));

        return searchResult.replace(searchString, String.format("%s%s%s", ANSI_YELLOW, searchString, ANSI_RESET));
    }
}
