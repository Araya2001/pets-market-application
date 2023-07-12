package pets.market.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pets.market.dto.DomainWrapperDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonPersistServiceImpl<T> implements JsonPersistService<T> {
    @Override
    public Boolean writeToFile(DomainWrapperDTO<T> t, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(new StringBuffer().append("persist/").append(fileName).toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(mapper.writeValueAsString(t));
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DomainWrapperDTO<T> readFromFile(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(new StringBuffer().append("persist/").append(fileName).toString());
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<DomainWrapperDTO<T>>() {
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
