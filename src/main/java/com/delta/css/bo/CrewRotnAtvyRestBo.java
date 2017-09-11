package com.delta.css.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.delta.css.dao.CrewRotnAtvyRestDaoIfc;
import com.delta.css.dao.CrewRotnAtvyRestDaoImpl;
import com.delta.css.excp.DataAcesExcp;
import com.delta.css.vo.CrewInfoInputVo;
import com.delta.css.vo.CrewRotnAtvyRestDtlsVo;
import com.delta.css.vo.MasterVo;

/**
 * Business Object to set FlightMealsCountsResponse object from SOA Meal service
 * response
 */

@Component
public class CrewRotnAtvyRestBo {
	public MasterVo uptoDateCount(CrewInfoInputVo crewInfoInputVo) throws DataAcesExcp {
		CrewRotnAtvyRestDaoIfc crewRotnAtvyRestDaoIfc = new CrewRotnAtvyRestDaoImpl();
		List<CrewRotnAtvyRestDtlsVo> crewRotnAtvyRestDtlsVoLst;
		List<CrewRotnAtvyRestDtlsVo> crewRotnAtvyRestDtlsVoLstChk;

		MasterVo masterVo2 = new MasterVo();
		HashMap<String, List<CrewRotnAtvyRestDtlsVo>> crewRotnAtvyRestDtlsMap = new HashMap();
		String dateKey;

		crewRotnAtvyRestDtlsVoLst = crewRotnAtvyRestDaoIfc.getCrewRotnAtvyRest(crewInfoInputVo);
		for (CrewRotnAtvyRestDtlsVo crewRotnAtvyRestDtlsVo : crewRotnAtvyRestDtlsVoLst) {
			dateKey = StringUtils.substring(crewRotnAtvyRestDtlsVo.getCalDt(), 0, 10);

			if (crewRotnAtvyRestDtlsMap.containsKey(dateKey)) {
				crewRotnAtvyRestDtlsVoLstChk = crewRotnAtvyRestDtlsMap.get(dateKey);
				crewRotnAtvyRestDtlsVoLstChk.add(crewRotnAtvyRestDtlsVo);
				crewRotnAtvyRestDtlsMap.put(dateKey, crewRotnAtvyRestDtlsVoLstChk);
			} else {
				crewRotnAtvyRestDtlsVoLstChk = new ArrayList();
				crewRotnAtvyRestDtlsVoLstChk.add(crewRotnAtvyRestDtlsVo);
				crewRotnAtvyRestDtlsMap.put(dateKey, crewRotnAtvyRestDtlsVoLstChk);
			}
		}
		masterVo2.setCrewRotnAtvyRestDtlsMap(crewRotnAtvyRestDtlsMap);
		return masterVo2;
	}
	public Boolean validation(String userId,String pass){
	if(userId!=null && (userId.equals("0000111111") || userId.equals("0000222222"))&& pass.equals("delta_user")){
		 return true;
	 }
	else
	return false;
	}
}
