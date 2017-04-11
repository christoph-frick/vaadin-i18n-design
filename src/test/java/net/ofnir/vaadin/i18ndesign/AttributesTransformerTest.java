package net.ofnir.vaadin.i18ndesign;

import com.google.common.collect.ImmutableMap;
import com.vaadin.ui.*;
import net.ofnir.vaadin.i18ndesign.transform.AttributesTransformer;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class AttributesTransformerTest extends Base {

    @Test
    public void allSeen() throws IOException {
        RememberTranslator translator = new RememberTranslator();
        Pipeline pipeline = new PipelineBuilder()
                .withTransformer(new AttributesTransformer())
                .build(translator);
        try (InputStream is = pipeline.process(load("attributes.html"))) {
            assertEquals(
                    ImmutableMap.of(
                            "the.key.caption", "The Caption",
                            "the.key.placeholder", "The Placeholder"
                    ),
                    translator.seen
            );
        }
    }

    @Test
    public void partOfDefault() {
        I18nDesign i18nDesign = new I18nDesign(new PipelineBuilder().build((key, fallback) -> key));
        TextField component = new TextField();
        i18nDesign.read(load("attributes.html"), component);
        assertEquals(TextField.class, component.getClass());
        assertEquals("the.key.caption", component.getCaption());
        assertEquals("the.key.placeholder", component.getPlaceholder());
    }

}