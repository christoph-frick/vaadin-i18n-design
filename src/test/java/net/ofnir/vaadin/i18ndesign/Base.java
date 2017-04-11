package net.ofnir.vaadin.i18ndesign;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

abstract class Base {

    public InputStream load(String resourceName) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
        assertNotNull(is);
        return is;
    }

}