package net.ofnir.vaadin.i18ndesign.write;

import org.jsoup.nodes.Document;

import java.io.InputStream;

/**
 * Create/Write a Document (back) into an InputStream.
 */
public interface Writer {
    InputStream write(Document doc);
}
