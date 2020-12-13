package br.dev.wesraiuga.brasilprevchallenge.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
@Lazy(false)
public class JsonConverter {

    private static ObjectMapper jsonConverter;

    @Autowired
    public JsonConverter(ObjectMapper jsonConverter) {
        JsonConverter.jsonConverter = jsonConverter;
    }

    @SneakyThrows
    public static String toJson(Object object) {
        return jsonConverter.writeValueAsString(object);
    }

    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> classType) {
        return jsonConverter.readValue(json, classType);
    }

    @SneakyThrows
    public static <T> List<T> fromJsonList(String json, Class<T> classType) {
        return jsonConverter.readValue(json,  jsonConverter.getTypeFactory().constructCollectionType(List.class, classType));
    }

}