package starter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import starter.models.data.UserData;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StringToJson {

    public List<UserData> getUsers() throws IOException {
        File file = new File(
                getClass().getClassLoader().getResource("users.json").getFile()
        );

        ObjectMapper mapper = new ObjectMapper();
        return  Arrays.asList(mapper.readValue(file, UserData[].class));
    }
}
