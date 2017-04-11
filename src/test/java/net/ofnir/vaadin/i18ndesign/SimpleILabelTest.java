package net.ofnir.vaadin.i18ndesign;

import com.vaadin.ui.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleILabelTest extends Base {

    @Test
    public void simpleLabel() {
        testLabel((key, fallback) -> fallback, "Hello Caption", "Hello Value");
        testLabel((key, fallback) -> key, "hello.world.caption", "hello.world.value");
    }

    private void testLabel(Translator translator, String expectedCaption, String expectedValue) {
        I18nDesign i18nDesign = new I18nDesign(translator);
        Label label = new Label();
        i18nDesign.read(load("simple-label.html"), label);
        assertEquals(Label.class, label.getClass());
        assertEquals(expectedCaption, label.getCaption());
        assertEquals(expectedValue, label.getValue());
    }

}