package com.aluracursos.literalurapaulacumbe.servicios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvierteDatos {

    public <T> T obtenerDatos(String json, Class<T> clase) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al procesar JSON", e);
        }
    }
}

