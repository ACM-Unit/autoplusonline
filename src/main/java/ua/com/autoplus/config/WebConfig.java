package ua.com.autoplus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import ua.com.autoplus.entity.Warehouse;


@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_JSON)
                .parameterName("type")
                .favorParameter(false)
                .ignoreUnknownPathExtensions(false)
                .ignoreAcceptHeader(false)
                .useJaf(true)
        ;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Warehouse.class);
        MarshallingView marshallingView = new MarshallingView();
        marshallingView.setMarshaller(marshaller);
        registry.enableContentNegotiation(new DocxView(), new XlsView(), view, marshallingView);
    }
}