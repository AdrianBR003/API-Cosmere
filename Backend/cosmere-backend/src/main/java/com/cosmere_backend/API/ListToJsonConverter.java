package com.cosmere_backend.API;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Converter(autoApply = true)
public class ListToJsonConverter implements AttributeConverter<List<String>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        if (stringList == null) return null;
        try {
            return objectMapper.writeValueAsString(stringList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir lista a JSON", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {

        if (s == null || s.isEmpty()) return new ArrayList<>();

        try {
            return objectMapper.readValue(s, List.class);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON a lista", e);
        }
    }
}
