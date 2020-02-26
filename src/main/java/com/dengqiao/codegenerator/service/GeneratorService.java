package com.dengqiao.codegenerator.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.dengqiao.codegenerator.dao.GeneratorDao;
import com.dengqiao.codegenerator.utils.GenUtils;
import com.dengqiao.codegenerator.utils.PageUtils;
import com.dengqiao.codegenerator.utils.Query;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @author dengqiao
 * @date 2019-09-17 09:49
 */
@Service
public class GeneratorService {
    @Autowired
    private GeneratorDao generatorDao;

    public PageUtils queryList(Query query) {
        Page page = PageHelper.startPage(query.getPage(), query.getLimit());
        List list = this.generatorDao.queryList(query);

        return new PageUtils(list, (int) page.getTotal(), query.getLimit(), query.getPage());
    }

    public Map<String, String> queryTable(String tableName) {
        return this.generatorDao.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return this.generatorDao.queryColumns(tableName);
    }

    public byte[] generatorCode(String moduleName, String author, String email, String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            Map table = queryTable(tableName);

            List columns = queryColumns(tableName);

            GenUtils.generatorCode(moduleName, author, email, table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
