package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Translator;
import org.jsoup.nodes.Element;

/**
 * Apply transformations on an Element and use a Translator to look up replacements.
 */
public interface Transformer {
    void transform(Element element, Translator translator);
}
