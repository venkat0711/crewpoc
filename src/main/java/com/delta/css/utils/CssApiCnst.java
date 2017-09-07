package com.delta.css.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.stereotype.Component;
//import com.delta.soa.flight.operations.meal.v1.EndPoint;

/**
 * MealApi constant class for static declaration and methods
 * 
 */
@Component
public class CssApiCnst {

    public static final String SVC_PROP_FILE = "MealApi.properties";
    public static final String LOG4J_CNFG_XML_FILE = "/MealApiLog4jCnfg.xml";
    public static final String SYS_LOC_PRPY = "meal.prop.loc";
    public static final String SYS_LOC_LOG = "meal.log.loc";
    public static final String RUNTIME_ENVIRONMENT = "runtime.environment";
    public static final String CHANNEL_ID = "MealAPI";
    public static final String TRANSACTION_ID = "RESTAPI_1.0";
    public static final String YES = "Y";
    public static final String BOOKING_DATABASE = "jdbc/BKGDB";
    public static final String SQL_CONFIG = "com/delta/css/dao/SqlConfig.xml";

    public static final String ERROR_CODE_1500 = "1500";

    public static final String ERROR_DESC_MISSING_CARRIER_CODE = "Required element/value missing for MarketedAsCarrierCode";
    public static final String ERROR_DESC_MISSING_FLIGHT_NUMBER = "Required element/value missing for MarketedFlightNumber";
    public static final String ERROR_DESC_MISSING_DEPARTURE_AIRPORT_CODE = "Required element/value missing for FlightLegDepartureAirportCode";
    public static final String ERROR_DESC_MISSING_DEPARTURE_DATE = "Required element/value missing for FlightLegDepartureDate";
    public static final String ERROR_DESC_MISSING_TRANSACTION_ID = "Required element/value missing for TransactionID";

    public static final String SOA_ERROR_INVALID_CARRIER_CODE = "Invalid value for MarketedAsCarrierCode";
    public static final String SOA_ERROR_INVALID_FLIGHT_NUMBER = "Invalid value for MarketedFlightNumber";
    public static final String SOA_ERROR_INVALID_DEPARTURE_AIRPORT_CODE = "Invalid value for FlightLegDepartureAirportCode";
    public static final String SOA_ERROR_INVALID_DEPARTURE_DATE = "Invalid value for FlightLegDepartureDate";

   // public static final String ENDPOINT_URL_KEY = MealPropsUtils.getRuntimeEnvt().toUpperCase()+ ".MEAL.SERVICE.ENDPOINT.URL";

   // public static final String CSS_GET_SOA_MEAL_API_JNDI_NM = "MEALAPI."+ MealPropsUtils.getRuntimeEnvt().toUpperCase() + ".JNDI.NM";
    public static final String INVALID_REQUEST = "Invalid request";
    public static final String BAD_REQUEST = "Bad request";
    public static final String PROCESS_START_MSG = "Process Start Time = ";
    public static final String PROCESS_END_MSG = "Process End Time = ";
    public static final String TOTAL_TIME = "Total Time Taken = ";
    public static final String SERVLET_EXCEPTION = "Servlet Exception";
    public static final String MILI_SEC = "(ms)";
    public static final String MEALAPI = "MealAPI";
    public static final String ONE = "1";
    public static final String REQUESTTYP = "I";
    public static final String DATE_FORMAT_SVC = "yyyyMMdd'T'HHmmss";
    public static final String REQ_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String INTERNAL_SERVER_ERROR = "500 internal server error";
    public static final String AUTHORIZATION_FAILED = "Access token authorization failed";
    public static final String ERR_CD = "100";
    public static final String APP_ROOT = "/crew";
    public static final String APP_NAME = "Meal API";
    public static final String APP_DESC = "This API provides availability and count of meals by passengers, cabin, and seats.";

    
    public static String getPrpyLoc() {
       /* System.out.println(System.getProperty(SYS_LOC_PRPY));
        String prpy = System.getProperty(SYS_LOC_PRPY);
        if (prpy == null) {
            System.err.println("Missing system property - properties location [" + SYS_LOC_PRPY+ "]");
        }
        return prpy;*/
    	return null;
    }

    public static String getEndPoint() {
       /* MealPropsUtils propUtil = MealPropsUtils.getInstance();
        try {
            propUtil.loadProperties();
           // EndPoint.url = (propUtil.getProperty(ENDPOINT_URL_KEY));
            return propUtil.getProperty(ENDPOINT_URL_KEY);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }*/
        return null;
    }
}