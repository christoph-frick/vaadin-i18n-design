package net.ofnir.vaadin.i18ndesign;

import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.declarative.DesignContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Transforms a Vaadin Design file via a Pipeline or a Translator creates a Component.
 * @see Design
 */
public class I18nDesign {

    final Pipeline pipeline;

    public I18nDesign(Translator translator) {
        this.pipeline = new PipelineBuilder().build(translator);
    }

    public I18nDesign(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public Component read(InputStream stream, Component rootComponent) {
        try (InputStream transformed = pipeline.process(stream)) {
            DesignContext designContext = Design.read(transformed, rootComponent);
            return designContext.getRootComponent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
