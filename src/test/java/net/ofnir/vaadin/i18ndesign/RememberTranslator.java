package net.ofnir.vaadin.i18ndesign;

import java.util.LinkedHashMap;
import java.util.Map;

public class RememberTranslator implements Translator {

    public final Map<String,String> seen = new LinkedHashMap<>();

    @Override
    public String translate(String key, String fallback) {
        seen.put(key, fallback);
        return key;
    }

}
