package com.cn.demo.Utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Project: demo
 * Created by admin on 2018/11/25 22:42
 */
public class FreeMarkerUtil {

    public static String getTemplate(String template, Map map) throws IOException, TemplateException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_20);
        config.setDefaultEncoding("UTF-8");
        Template temp = config.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        return stringWriter.toString();
    }
}
