package com.delta.css.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delta.css.excp.DataAcesExcp;
import com.delta.css.excp.DbSvcExcp;
import com.delta.css.utils.BsLogger;
import com.delta.css.vo.CrewInfoInputVo;
import com.delta.css.vo.CrewRotnAtvyRestDtlsVo;

@Component
public class CrewRotnAtvyRestDaoImpl implements CrewRotnAtvyRestDaoIfc {

	@Autowired
	private BsDbCon dbConCss;

	private final Logger LOGGER = BsLogger.getLogger(CrewRotnAtvyRestDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<CrewRotnAtvyRestDtlsVo> getCrewRotnAtvyRest(CrewInfoInputVo param) throws DataAcesExcp {
		dbConCss = new BsDbCon();
		try {
			LOGGER.info("In Dao getCrewRotnAtvyRest");
			return (List<CrewRotnAtvyRestDtlsVo>) dbConCss.getRows("getCrewRotnAtvyRest", param);

		} catch (DbSvcExcp dSE) {
			throw new DataAcesExcp(dSE);
		}

	}

}
