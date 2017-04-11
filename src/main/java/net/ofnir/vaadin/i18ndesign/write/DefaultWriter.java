package net.ofnir.vaadin.i18ndesign.write;

import org.jsoup.nodes.Document;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class DefaultWriter implements Writer {

    final String charset;

    public DefaultWriter(String charset) {
        this.charset = charset;
    }

    @Override
    public InputStream write(Document doc) {
        try {
            return new ByteArrayInputStream(doc.html().getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
