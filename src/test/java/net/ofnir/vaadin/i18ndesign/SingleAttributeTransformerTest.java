package net.ofnir.vaadin.i18ndesign;

import com.google.common.collect.ImmutableMap;
import com.vaadin.ui.*;
import net.ofnir.vaadin.i18ndesign.transform.SingleAttributeTransformer;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class SingleAttributeTransformerTest extends Base {

    @Test
    public void allSeen() throws IOException {
        RememberTranslator translator = new RememberTranslator();
        Pipeline pipeline = new PipelineBuilder()
                .withTransformer(new SingleAttributeTransformer())
                .build(translator);
        try (InputStream is = pipeline.process(load("singleAttribute.html"))) {
            assertEquals(
                    ImmutableMap.of(
                            "the.caption.key", "The Caption",
                            "the.placeholder.key", "The Placeholder"
                    ),
                    translator.seen
            );
        }
    }

    @Test
    public void partOfDefault() {
        I18nDesign i18nDesign = new I18nDesign(new PipelineBuilder().build((key, fallback) -> key));
        TextField component = new TextField();
        i18nDesign.read(load("singleAttribute.html"), component);
        assertEquals(TextField.class, component.getClass());
        assertEquals("the.caption.key", component.getCaption());
        assertEquals("the.placeholder.key", component.getPlaceholder());
    }

}