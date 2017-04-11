package net.ofnir.vaadin.i18ndesign;

import net.ofnir.vaadin.i18ndesign.read.DefaultReader;
import net.ofnir.vaadin.i18ndesign.read.Reader;
import net.ofnir.vaadin.i18ndesign.transform.CompositeTransformer;
import net.ofnir.vaadin.i18ndesign.transform.DefaultTransformer;
import net.ofnir.vaadin.i18ndesign.transform.Transformer;
import net.ofnir.vaadin.i18ndesign.write.DefaultWriter;
import net.ofnir.vaadin.i18ndesign.write.Writer;

import java.util.ArrayList;
import java.util.List;

public class PipelineBuilder {

    Prefix prefix = Prefix.DEFAULT;
    String charset = "UTF-8";
    Reader reader;
    List<Transformer> transformers = new ArrayList<>();
    Writer writer;

    public PipelineBuilder() {
    }

    PipelineBuilder withCharset(String charset) {
        this.charset = charset;
        return this;
    }

    PipelineBuilder withReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    PipelineBuilder withWriter(Writer writer) {
        this.writer = writer;
        return this;
    }

    PipelineBuilder withTransformer(Transformer transformer) {
        this.transformers.add(transformer);
        return this;
    }

    Pipeline build(Translator translator) {
        Transformer transformer;
        switch (transformers.size()) {
            case 0:
                transformer = new DefaultTransformer(prefix);
                break;
            case 1:
                transformer = transformers.get(0);
                break;
            default:
                transformer = new CompositeTransformer(transformers.toArray(new Transformer[transformers.size()]));
                break;
        }
        return new Pipeline(
                reader != null ? reader : new DefaultReader(charset),
                transformer,
                writer != null ? writer : new DefaultWriter(charset),
                translator
        );
    }

}
