package com.delta.css.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.delta.css.utils.CssApiCnst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	public @ResponseBody MasterVo rtrvSchdInf( HttpServletRequest request,
			@RequestParam(CssApiCnst.EMPL_ID) String emplId,  @RequestParam(CssApiCnst.DATE) String date

	) throws BsnObjExcp{
		String loginUser =  (String) request.getSession().getAttribute(CssApiCnst.USER_SESSION);
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
