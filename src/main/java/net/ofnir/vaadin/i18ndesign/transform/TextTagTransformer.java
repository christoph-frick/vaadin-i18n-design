package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Translator;
import net.ofnir.vaadin.i18ndesign.Prefix;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

/**
 * Handles tags like {ns}:text with Attribute {ns}:key and the .text() being the default.
 */
public class TextTagTransformer implements Transformer {

    final Prefix prefix;

    public TextTagTransformer() {
        this(Prefix.DEFAULT);
    }

    public TextTagTransformer(Prefix prefix) {
        this.prefix = prefix;
    }

    @Override
    public void transform(Element element, Translator translator) {
        prefix.hasPrefix(element.tagName()).ifPresent(s -> {
            String key, fallback;
            String keyAttr = prefix.prefix("key");
            if (element.hasAttr(keyAttr)) {
                key = element.attr(keyAttr);
                fallback = element.text();
            } else {
                key = fallback = element.text();
            }
            element.replaceWith(new TextNode(translator.translate(key, fallback), ""));

        });
    }

}
