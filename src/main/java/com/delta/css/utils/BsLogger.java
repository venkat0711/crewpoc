package com.delta.css.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * Base Logger Class
 *
 */
public class BsLogger extends Logger {
	
	/**
	 * @param name
	 */
	protected BsLogger(String name) {
		super(name);
	}

	/**
	 * Initializes Log4j
	 */
	private static void inlz() {
		try {
			//DOMConfigurator.configure(getCnfgFile(MealApiCnst.LOG4J_CNFG_XML_FILE).toURI().toURL());		
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * @param name
	 * @return Logger
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class name) {
		inlz();
		Logger _log = Logger.getLogger(name);	
	    return _log; 
	}
	
    /**
     * Retrieves Log4j Config File
     * @param file
     * @return File
     */
    private static File getCnfgFile(String file) {
		try {
			FileReader fileReader = new FileReader(CssApiCnst.getPrpyLoc() + file);
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("WARNING: Log4J Configuration File [" + file + "] not found");
		} catch (IOException e) {
			System.err.println("WARNING: Exception Reading Log4J Configuration File [" + file + "]");
		}
    	
    	return new File(CssApiCnst.getPrpyLoc() + file);
    }
	
}
