package com.lmiky.apitest.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmiky.platform.controller.api.BaseApiController;
import com.lmiky.platform.controller.api.view.CodeDataView;
import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.logger.util.LoggerUtils;
import com.lmiky.platform.sort.pojo.BaseSortPojo;
import com.lmiky.platform.tree.pojo.BaseTreePojo;
import com.lmiky.platform.util.Environment;
import com.lmiky.platform.util.IPUtils;

/**
 * @author lmiky
 * @date 2015年5月11日 下午2:58:27
 */
@RestController
@RequestMapping("/api/test")
public class TestApiController extends BaseApiController {

	/**
	 * 激活
	 * @author lmiky
	 * @date 2015年5月11日 下午5:24:25
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param playerCode 15为IEMI+15位IMSI(3位MCC+2位MNC+10位MSIN)+12位MAC地址
	 * @param gameCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test.shtml")
	@ResponseBody
	public CodeDataView test(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerUtils.info(String.format("IP[%s]进入到test测试接口中", IPUtils.getRealIP(request)));
		CodeDataView view = CodeDataView.buildSuccessView("diService", service.toString());
		view.addDate("beanFactory", Environment.getBean("baseService").toString());
		view.addDate("time", new Date());
		view.addDate("null", null);
		return view;
	}

	/**
	 * 激活
	 * @author lmiky
	 * @date 2015年5月11日 下午5:24:25
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param playerCode 15为IEMI+15位IMSI(3位MCC+2位MNC+10位MSIN)+12位MAC地址
	 * @param gameCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testList.shtml")
	@ResponseBody
	public CodeDataView testList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerUtils.info(String.format("IP[%s]进入到testList测试接口中", IPUtils.getRealIP(request)));
		List<BaseTreePojo> loggers = service.list(BaseTreePojo.class);
		return CodeDataView.buildSuccessView("loggers", loggers);
	}

	/**
	 * @author lmiky
	 * @date 2015年9月7日 下午11:40:23
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testFind.shtml")
	@ResponseBody
	public CodeDataView testFind(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Long id) throws Exception {
		LoggerUtils.info(String.format("IP[%s]进入到testFind测试接口中", IPUtils.getRealIP(request)));
		BasePojo pojo = service.find(BaseTreePojo.class, id);
		Map<String, Object> data = new HashMap<>();
		data.put("tree", pojo);
		return CodeDataView.buildSuccessView("tree", pojo);
	}

	/**
	 * @author lmiky
	 * @date 2015年9月7日 下午11:40:23
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testFind2.shtml")
	@ResponseBody
	public CodeDataView testFind2(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Long id) throws Exception {
		LoggerUtils.info(String.format("IP[%s]进入到testFind测试接口中", IPUtils.getRealIP(request)));
		BaseSortPojo sort = service.find(BaseSortPojo.class, id);
		BaseTreePojo tree = service.find(BaseTreePojo.class, id);
		CodeDataView view = CodeDataView.buildSuccessView("tree", tree);
		view.addDate("sort", sort);
		return view;
	}

	/**
	 * 修改
	 * @author lmiky
	 * @date 2015年9月7日 下午11:29:45
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testUpdate.shtml")
	@ResponseBody
	public CodeDataView testUpdate(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerUtils.info(String.format("IP[%s]进入到testList测试接口中", IPUtils.getRealIP(request)));
		List<BaseTreePojo> datas = service.list(BaseTreePojo.class);
		BaseTreePojo tree = datas.get(0);
		service.update(BaseTreePojo.class, tree.getId(), "name", tree.getName() + Math.random() * 100 / 100);
		return CodeDataView.buildSuccessView();
	}

}
