package net.ofnir.vaadin.i18ndesign;

import com.google.common.collect.ImmutableMap;
import net.ofnir.vaadin.i18ndesign.transform.TextTagTransformer;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TextTagTransformerTest extends Base {

    @Test
    public void allSeen() throws IOException {
        RememberTranslator translator = new RememberTranslator();
        Pipeline pipeline = new PipelineBuilder()
                .withTransformer(new TextTagTransformer())
                .build(translator);
        try (InputStream is = pipeline.process(load("textTag.html"))) {
            assertEquals(
                    ImmutableMap.of(
                            "key1", "default1",
                            "key2", "default2",
                            "key3", "default3"
                    ),
                    translator.seen
            );
        }
    }

}