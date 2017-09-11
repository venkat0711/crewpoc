package com.delta.css.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.delta.css.excp.BsnObjExcp;
import com.delta.css.excp.DataAcesExcp;
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
	 * @throws DataAcesExcp 
	 * 
	 * 
	 */
	@RequestMapping(value = "/CrewInfo", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(nickname = "RtrvCrewRotnAtvyRestDtls", value = "Retrieve Count With Special Meals")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody MasterVo retrieveCountWithSpecialMeals( HttpServletRequest request,
			//@ApiParam(value = "Access token authorization. Example: Bearer V2hS4VDBLNtJBouLfwr321ESWGul", name = "Authorization", required = false, defaultValue = "DELTA") @RequestHeader(name = "Authorization", value = "Authorization", required = false) String authorization,
			//@ApiParam(value = "Transaction ID; if not provided, UUID generated value will be returned.", name = "TransactionID", required = false, defaultValue = "") @RequestHeader(name = "TransactionID", value = "TransactionID", required = false) String transactionID,
			@RequestParam("emplId") String emplId,  @RequestParam("date") String date


	) throws BsnObjExcp{
		String loginUser =  (String) request.getSession().getAttribute("usersession");
		MasterVo masterVo = new MasterVo();
		masterVo.setAppMsg(null);
		if(emplId.equals(loginUser)){
			
		
		CrewInfoInputVo crewInfoInputVo = new CrewInfoInputVo();
		crewInfoInputVo.setDate(date);
		crewInfoInputVo.setEmplId(emplId);
		
		CrewRotnAtvyRestBo bo = new CrewRotnAtvyRestBo();
		try {
			masterVo = bo.uptoDateCount( crewInfoInputVo);
		} catch (DataAcesExcp e) {
			// TODO Auto-generated catch block
			 throw new BsnObjExcp(e.getMessage(), e);
		}
		LOGGER.info("Output schedule--"+masterVo);
		
		}
		else{
			masterVo.setAppMsg("Resource cannot access directly without login");
		}
		return masterVo;
	}

}
