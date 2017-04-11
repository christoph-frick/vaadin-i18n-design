package net.ofnir.vaadin.i18ndesign.read;

import org.jsoup.nodes.Document;

import java.io.InputStream;

/**
 * Read/parse an InputStream into a Document.
 */
public interface Reader {
    Document read(InputStream stream);
}
