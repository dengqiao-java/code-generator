package com.yimi.codegenerator.controller;

import cn.hutool.core.date.DateUtil;
import com.yimi.codegenerator.service.GeneratorService;
import com.yimi.codegenerator.utils.PageUtils;
import com.yimi.codegenerator.utils.Query;
import com.yimi.codegenerator.utils.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author dengqiao
 * @date 2019-09-17 09:46
 */
@Controller
@RequestMapping({"/generator"})
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @ResponseBody
    @RequestMapping({"/list"})
    public R list_sys(@RequestParam Map<String, Object> params) {
        PageUtils pageUtil = this.generatorService.queryList(new Query(params));
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping({"/code"})
    public void code(String moduleName, String author, String email, String tables, HttpServletResponse response)
            throws IOException {
        byte[] data = this.generatorService.generatorCode(moduleName, author, email, tables.split(","));
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code-generator-" + DateUtil.parse(DateUtil.now().toString(), "yyyy-MM-dd HH:mm:ss") + ".zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
