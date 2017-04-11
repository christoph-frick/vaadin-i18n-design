package net.ofnir.vaadin.i18ndesign;

import net.ofnir.vaadin.i18ndesign.read.Reader;
import net.ofnir.vaadin.i18ndesign.transform.Transformer;
import net.ofnir.vaadin.i18ndesign.write.Writer;
import org.jsoup.nodes.Document;

import java.io.InputStream;

/**
 * Filter an InputStream via the registered transformers, who will call the translator.
 *
 * input -> read -> [transformer(translator)] -> write -> output
 */
public class Pipeline {

    final Reader reader;
    final Transformer transformer;
    final Writer writer;
    final Translator translator;

    public Pipeline(Reader reader, Transformer transformer, Writer writer, Translator translator) {
        this.reader = reader;
        this.transformer = transformer;
        this.writer = writer;
        this.translator = translator;
    }

    public InputStream process(InputStream stream) {
        Document document = reader.read(stream);
        document.select("*").forEach(element -> transformer.transform(element, translator));
        return writer.write(document);
    }

}
