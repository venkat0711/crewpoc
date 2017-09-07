package com.delta.css.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Common utility methods for MealApi
 * 
 */
public class CssPropsUtils {

    private final static Logger LOGGER = Logger.getLogger(CssPropsUtils.class);
    private static Properties properties = new Properties();
    public static CssPropsUtils propertiesUtils = null;

    /**
     * Load inputstream from classloader
     * 
     * @param resourceName
     * @return
     */
    private InputStream getInputStreamFromClassLoader(String resourceName) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        if (is == null) {
            is = ClassLoader.getSystemResourceAsStream(resourceName);
        }
        return is;
    }

    /**
     * Load properties from Working Directory
     * 
     * @param resourceName
     * @return
     * @throws FileNotFoundException
     */
    private InputStream getPropertiesFromWorkingDirectory(String resourceName)
            throws FileNotFoundException {
        String propFilePath = System.getProperty(CssApiCnst.RUNTIME_ENVIRONMENT);
        File propertyFile = new File(propFilePath + resourceName);
        FileInputStream in = null;
        in = new FileInputStream(propertyFile);
        return new BufferedInputStream(in);
    }

    /**
     * Load Properties from an input stream
     * 
     * @param is
     */
    private void loadPropertiesFromInputStream(InputStream is) throws IOException {
    	LOGGER.debug("Loading MealApi.properties");
        properties.load(is);
        is.close();
    }

    public static CssPropsUtils getInstance() {
        if (null == propertiesUtils) {
            propertiesUtils = new CssPropsUtils();
        }
        return propertiesUtils;
    }

    private static Properties getPrpyFile() {
        Properties props = new Properties();
        try {
        	LOGGER.debug("getPrpyFile: " + CssApiCnst.SVC_PROP_FILE);
            props.load(new FileInputStream(CssApiCnst.getPrpyLoc() + CssApiCnst.SVC_PROP_FILE));
            PropertyConfigurator.configure(props);
        } catch (FileNotFoundException e) {
        	LOGGER.error(e);
        } catch (java.io.IOException e) {
        	LOGGER.error(e);
        }
        return props;
    }

    /**
     * Load properties
     * 
     * @throws FileNotFoundException , IOException
     */
    public void loadProperties() throws FileNotFoundException, IOException {
        if (properties.isEmpty()) {
            properties = getPrpyFile();
        }
        if (properties.isEmpty()) {
            InputStream is = null;
            is = getInputStreamFromClassLoader(CssApiCnst.SVC_PROP_FILE);
            if (is == null) {
                is = getPropertiesFromWorkingDirectory(CssApiCnst.SVC_PROP_FILE);
            }
            loadPropertiesFromInputStream(is);
        }
    }

    /**
     * Retrieve the value of the property
     * 
     * @param propertyName
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws Exception
     */
    public String getProperty(String propertyName) throws FileNotFoundException, IOException {
        if (properties.isEmpty()) {
            loadProperties();
        }
        return properties.getProperty(propertyName);
    }

    /**
     * Retrieve the property value
     * 
     * @param propertyName
     * @return
     * @throws Exception
     */
    public String getAvailableProperty(String propertyName) throws Exception {
        return getProperty(propertyName);
    }

    /**
     * 
     * @return String - Runtime Environment
     */
    public static String getRuntimeEnvt() {
        String prpy = System.getProperty(CssApiCnst.RUNTIME_ENVIRONMENT);
        if (prpy == null) {
            System.err.println("Missing system property - runtime environment ["
                    + CssApiCnst.RUNTIME_ENVIRONMENT + "]");
        }

        return prpy;

    }
}
