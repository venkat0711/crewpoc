package com.delta.css.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delta.css.bo.CrewRotnAtvyRestBo;
import com.delta.css.utils.BsLogger;
import com.delta.css.vo.CrewInfoInputVo;
import com.delta.css.vo.MasterVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * method Accept JSON 
 * 
 */
/**
 * @author 394418
 *
 */
@Api(value = "RtrvCrewRotnAtvyRestDtls")
@RestController
@RequestMapping("/")
public class RtrvCrewRotnAtvyRestDtls {

	private static final Logger LOGGER = BsLogger.getLogger(RtrvCrewRotnAtvyRestDtls.class);

	/**
	 * Method to get Rotation , Activity and rest details for an employee
	 * 
	 * 
	 */
	@RequestMapping(value = "/CrewInfo", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(nickname = "RtrvCrewRotnAtvyRestDtls", value = "Retrieve Count With Special Meals")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody MasterVo retrieveCountWithSpecialMeals(
			@ApiParam(value = "Access token authorization. Example: Bearer V2hS4VDBLNtJBouLfwr321ESWGul", name = "Authorization", required = false, defaultValue = "DELTA") @RequestHeader(name = "Authorization", value = "Authorization", required = false) String authorization,
			@ApiParam(value = "Transaction ID; if not provided, UUID generated value will be returned.", name = "TransactionID", required = false, defaultValue = "") @RequestHeader(name = "TransactionID", value = "TransactionID", required = false) String transactionID,
			@RequestParam("emplId") String emplId,  @RequestParam("date") String date

	) throws Exception {
		CrewInfoInputVo crewInfoInputVo = new CrewInfoInputVo();
		crewInfoInputVo.setDate(date);
		crewInfoInputVo.setEmplId(emplId);
		MasterVo masterVo = new MasterVo();
		CrewRotnAtvyRestBo bo = new CrewRotnAtvyRestBo();
		masterVo = bo.uptoDateCount(masterVo, crewInfoInputVo);
		LOGGER.info("Output schedule--"+masterVo);
		return masterVo;
	}

}
