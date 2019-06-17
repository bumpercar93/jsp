package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.db.service.DbServiceImpl;
import kr.or.ddit.db.service.IDbService;

public class RequestMapping {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	// /main.do -> MainController
	// /userList.do -> UserListController
	
	private static Map<String, Controller> requestMapping;
	
	private static IDbService dbService = new DbServiceImpl();
	
	static{
		requestMapping = new HashMap<String, Controller>();
		List<DbVO> uriClassMappingList = dbService.getAllUriMapping();
		
		for(DbVO dbVO : uriClassMappingList) {
			try {
				Class clazz = Class.forName(dbVO.getClassName());
				Object obj = clazz.newInstance();
				requestMapping.put(dbVO.getUri(), (Controller)obj);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}

}
