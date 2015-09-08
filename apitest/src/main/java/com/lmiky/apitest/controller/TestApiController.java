package com.lmiky.apitest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmiky.platform.controller.BaseApiController;
import com.lmiky.platform.controller.view.BaseCodeDataListView;
import com.lmiky.platform.controller.view.BaseCodeDataView;
import com.lmiky.platform.controller.view.BaseCodeView;
import com.lmiky.platform.controller.view.BaseJsonView;
import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.logger.util.LoggerUtils;
import com.lmiky.platform.sort.pojo.BaseSortPojo;
import com.lmiky.platform.test.service.TestService;
import com.lmiky.platform.tree.pojo.BaseTreePojo;
import com.lmiky.platform.util.Environment;
import com.lmiky.platform.util.IPUtils;

/**
 * @author lmiky
 * @date 2015年5月11日 下午2:58:27
 */
@Controller
@RequestMapping("/api/test")
public class TestApiController extends BaseApiController {
    private TestService testService;

    /**
     * 激活
     *
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
    public String test(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到test测试接口中", IPUtils.getRealIP(request)));
            System.out.println(testService);
            System.out.println(Environment.getBean("baseService"));
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeView.class);
    }

    /**
     * 激活
     *
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
    public String testList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到testList测试接口中", IPUtils.getRealIP(request)));
            List<BaseTreePojo> loggers = testService.list(BaseTreePojo.class);
            Map<String, Object> data = new HashMap<>();
            data.put("loggers", loggers);
            modelMap.put(BaseCodeDataListView.KEY_NAME_DATA, data);
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeDataListView.class);
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
    public String testFind(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Long id)
            throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到testFind测试接口中", IPUtils.getRealIP(request)));
            BasePojo pojo = testService.find(BaseTreePojo.class, id);
            Map<String, Object> data = new HashMap<>();
            data.put("tree", pojo);
            modelMap.put(BaseCodeDataListView.KEY_NAME_DATA, data);
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeDataView.class);
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
    public String testFind2(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Long id)
            throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到testFind测试接口中", IPUtils.getRealIP(request)));
            BasePojo pojo = testService.findPojo(id);
            BaseSortPojo sort = testService.findSortPojo(id);
            BaseTreePojo tree = testService.findTreePojo(id);
            Map<String, Object> data = new HashMap<>();
            data.put("pojo", pojo);
            data.put("sort", sort);
            data.put("tree", tree);
            modelMap.put(BaseCodeDataListView.KEY_NAME_DATA, data);
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeDataView.class);
    }

    /**
     * 修改
     *
     * @author lmiky
     * @date 2015年9月7日 下午11:29:45
     * @param modelMap
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/testUpdate.shtml")
    public String testUpdate(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到testList测试接口中", IPUtils.getRealIP(request)));
            List<BaseTreePojo> datas = testService.list(BaseTreePojo.class);
            BaseTreePojo tree = datas.get(0);
            testService.update(BaseTreePojo.class, tree.getId(), "name", tree.getName() + tree.getId());
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeView.class);
    }

    /**
     * 测试失误
     *
     * @author lmiky
     * @date 2015年9月7日 下午8:48:11
     * @param modelMap
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/testTx.shtml")
    public String testTx(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            LoggerUtils.info(String.format("IP[%s]进入到testTx测试接口中", IPUtils.getRealIP(request)));
            BaseTreePojo pojo = testService.test(BaseTreePojo.class);
            Map<String, Object> data = new HashMap<>();
            data.put("pojo", pojo);
            modelMap.put(BaseCodeDataListView.KEY_NAME_DATA, data);
        } catch (Exception e) {
            transactException(modelMap, request, response, e);
        }
        return BaseJsonView.getViewName(BaseCodeDataView.class);
    }

    /**
     * @return the testService
     */
    public TestService getTestService() {
        return testService;
    }

    /**
     * @param testService the testService to set
     */
    @Resource(name = "testService")
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

}
