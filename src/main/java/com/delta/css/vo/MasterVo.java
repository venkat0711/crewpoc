package com.delta.css.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MasterVo {

	private Map<String, List<CrewRotnAtvyRestDtlsVo>> crewRotnAtvyRestDtlsMap=null;

	public Map<String, List<CrewRotnAtvyRestDtlsVo>> getCrewRotnAtvyRestDtlsMap() {
		return crewRotnAtvyRestDtlsMap;
	}

	public void setCrewRotnAtvyRestDtlsMap(HashMap<String, List<CrewRotnAtvyRestDtlsVo>> crewRotnAtvyRestDtlsMap) {
		this.crewRotnAtvyRestDtlsMap = crewRotnAtvyRestDtlsMap;
	}

	private String appMsg;

	public String getAppMsg() {
		return appMsg;
	}

	public void setAppMsg(String appMsg) {
		this.appMsg = appMsg;
	}
	
	
	
	
	
}
