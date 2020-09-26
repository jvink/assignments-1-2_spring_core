package com.jvink.assignments12_spring_core.services;

import com.jvink.assignments12_spring_core.interfaces.StringRepository;
import com.jvink.assignments12_spring_core.models.StringDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StringService {

    private StringRepository stringRepository;

    @Autowired
    public StringService(StringRepository stringRepository) {
        this.stringRepository = stringRepository;
    }

    public String reverseString(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    public String encapsulateString(String name) {
        return name.toUpperCase();
    }

    public void saveString(StringDTO stringDTO) {
        stringRepository.save(stringDTO);
    }

    public List<StringDTO> getAllStrings() {
        List<StringDTO> stringDTOs = new ArrayList<>();
        stringRepository.findAll().forEach(stringDTO -> stringDTOs.add(stringDTO));
        return stringDTOs;
    }

    public Number countCharacters(String name){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = name.length() - 1;
        Optional<StringDTO> stringDTO = stringRepository.findById(name);

        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(name.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(name.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }

        if (stringDTO.isPresent()) {
            return stringDTO.get().getCount();
        } else {
            StringDTO newStringDTO = new StringDTO(name, wordCount);
            saveString(newStringDTO);
            return wordCount;
        }
    }
}
