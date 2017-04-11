package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Translator;
import net.ofnir.vaadin.i18ndesign.Prefix;
import org.jsoup.nodes.Element;

/**
 * Handles {ns}:{attr}="key" {attr}="default"
 */
public class SingleAttributeTransformer implements Transformer {

    final Prefix prefix;

    public SingleAttributeTransformer() {
        this(Prefix.DEFAULT);
    }

    public SingleAttributeTransformer(Prefix prefix) {
        this.prefix = prefix;
    }

    @Override
    public void transform(Element element, Translator translator) {
        element.attributes().forEach(attribute -> {
            prefix.hasPrefix(attribute.getKey()).ifPresent( attrName -> {
                String key, fallback;
                if (element.hasAttr(attrName)) {
                    key = attribute.getValue();
                    fallback = element.attr(attrName);
                } else {
                    key = fallback = attribute.getValue();
                }
                element.removeAttr(attribute.getKey());
                element.attr(attrName, translator.translate(key,fallback));
            });
        });
    }

}
