package ua.com.autoplus.config;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class DocxViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        DocxView docxView = new DocxView();
        return docxView;
    }
}
