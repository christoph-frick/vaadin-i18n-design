package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Translator;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;

public class CompositeTransformer implements Transformer {

    final List<Transformer> transformers;

    public CompositeTransformer(Transformer... transformers) {
        this.transformers = Arrays.asList(transformers);
    }

    @Override
    public void transform(Element element, Translator translator) {
        transformers.forEach(transformer -> transformer.transform(element, translator));
    }
}
