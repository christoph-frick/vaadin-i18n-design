package net.ofnir.vaadin.i18ndesign.read;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.io.InputStream;

public class DefaultReader implements Reader {

    final String charset;

    public DefaultReader(String charset) {
        this.charset = charset;
    }

    @Override
    public Document read(InputStream stream) {
        try {
            return Jsoup.parse(stream, charset, "", Parser.htmlParser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
