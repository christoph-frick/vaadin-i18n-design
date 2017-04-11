package net.ofnir.vaadin.i18ndesign;

/**
 * Provide a translation for a key and an optional fallback.
 */
public interface Translator {
    String translate(String key, String fallback);
}
