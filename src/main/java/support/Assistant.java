package support;

import enums.NomeProjetoEnum;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Assistant {

    public static Properties properties = new Properties();

    public static String getConfigPropertiesValues(NomeProjetoEnum projectName, String variable){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/" + projectName.getProjetoName() + "/config.properties");
            properties.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        return  properties.getProperty(variable);
    }
}
