package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Prefix;
import net.ofnir.vaadin.i18ndesign.Translator;
import org.jsoup.nodes.Element;

import java.util.stream.Stream;

/**
 * Handles {ns}:key="prefix" {ns}:attributes="attr1 attr2 ... attrN" attr1="default1" attr2="default2" ... attrN="defaultN";
 * Generates {prefix}.{attr1} {prefix}.{attr2} ... {prefix}.{attrN}
 */
public class AttributesTransformer implements Transformer {

    final Prefix prefix;
    final String keyAttrName, attributesAttrName;

    public AttributesTransformer() {
        this(Prefix.DEFAULT);
    }

    public AttributesTransformer(Prefix prefix) {
        this.prefix = prefix;
        this.keyAttrName = prefix.prefix("key");
        this.attributesAttrName = prefix.prefix("attributes");
    }

    @Override
    public void transform(Element element, Translator translator) {
        if (element.hasAttr(keyAttrName) && element.hasAttr(attributesAttrName)) {
            String keyPrefix = element.attr(keyAttrName);
            String attrs = element.attr(attributesAttrName);
            Stream.of(attrs.split("\\s+")).forEach(attrName -> {
                String key = keyPrefix + "." + attrName, fallback;
                if (element.hasAttr(attrName)) {
                    fallback = element.attr(attrName);
                } else {
                    fallback = key;
                }
                element.attr(attrName, translator.translate(key,fallback));
            });
            element.removeAttr(keyAttrName);
            element.removeAttr(attributesAttrName);
        }
    }

}
