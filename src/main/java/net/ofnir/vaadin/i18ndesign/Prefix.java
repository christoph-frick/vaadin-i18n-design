package net.ofnir.vaadin.i18ndesign;

import java.util.Optional;

/**
 * Helper to work with a namespace in Jsoup, which is used to mark the tags and attributes the transformers will work with.
 */
public class Prefix {

    public static final Prefix DEFAULT = new Prefix();

    static final String DEFAULT_NS = "i18n";

    final String ns;
    final String prefix;

    public Prefix() {
        this(DEFAULT_NS);
    }

    public Prefix(String ns) {
        this.ns = ns;
        this.prefix = ns + ":";
    }

    public Optional<String> hasPrefix(String v) {
        if (!v.startsWith(prefix)) {
            return Optional.empty();
        }
        return Optional.of(v.replaceFirst(prefix, ""));
    }

    public String prefix(String v) {
        return prefix + v;
    }
}
