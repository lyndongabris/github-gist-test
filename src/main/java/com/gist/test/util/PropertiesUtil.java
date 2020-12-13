package com.gist.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUtil {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);
    public static final String USER_PROPERTIES = "user.properties";

    public static void loadPropertiesFile(String fileName) {
        LOG.info("Loading test system properties from {}", fileName);

        Properties prop = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get(fileName))) {
            // load a properties file
            prop.load(input);

            prop.forEach((key, value) -> {
                System.setProperty((String) key, (String) value);
                LOG.info("Setting test property {}={}", key, value);
            });

        } catch (IOException ex) {
            throw new IllegalStateException("Could not find properties file " + fileName, ex);
        }
    }

    public static void loadUserTestProperties() {
        loadPropertiesFile(USER_PROPERTIES);
    }

    public static String getSystem(String propertyName) {
        String output = System.getProperty(propertyName);
//        Preconditions.checkNotNull(output, "System property %s is null, please check it has been loaded", propertyName);
        return output;
    }
}
