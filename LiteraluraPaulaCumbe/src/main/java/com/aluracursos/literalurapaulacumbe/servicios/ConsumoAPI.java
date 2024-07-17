package com.aluracursos.literalurapaulacumbe.servicios;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumoAPI {

    private static final String URL_BASE = "https://gutendex.com/books/";

    public String obtenerDatos(String endpoint) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL_BASE + endpoint, String.class);
    }
}
