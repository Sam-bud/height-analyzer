package com.heightanalyzer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PythonAIService {

    private static final String PYTHON_API_URL = "http://127.0.0.1:8001/estimate-height";

    public JsonNode sendImageToPython(MultipartFile file) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(PYTHON_API_URL);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody(
                    "image",
                    file.getBytes(),
                    ContentType.create("image/jpeg"),
                    file.getOriginalFilename()
            );

            HttpEntity entity = builder.build();
            post.setEntity(entity);

            return client.execute(post, response -> {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readTree(response.getEntity().getContent());
            });
        }
    }

}
