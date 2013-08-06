package graguijer;


import com.google.inject.Singleton;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.template.ViewProcessor;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

@Provider
@Singleton
public class FreemarkerProvider implements ViewProcessor<Template> {

    Configuration configuration;

    public FreemarkerProvider() throws IOException {
        File file = new File("web/ftl");
        TemplateLoader templateLoader = new FileTemplateLoader(file);
        configuration = new Configuration();
        configuration.setTemplateLoader(templateLoader);
    }

    @Override
    public Template resolve(String name) {
        try {
            return configuration.getTemplate(name+".ftl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTo(Template template, Viewable viewable, OutputStream out) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            template.process(viewable.getModel(), stringWriter);
            stringWriter.close();
            out.write(stringWriter.toString().getBytes());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
