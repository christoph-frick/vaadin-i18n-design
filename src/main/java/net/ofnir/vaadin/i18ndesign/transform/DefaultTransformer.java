package net.ofnir.vaadin.i18ndesign.transform;

import net.ofnir.vaadin.i18ndesign.Prefix;

public class DefaultTransformer extends CompositeTransformer {

    public DefaultTransformer(Prefix prefix) {
        super(
                new TextTagTransformer(prefix),
                new AttributesTransformer(prefix),
                new SingleAttributeTransformer(prefix)
        );
    }

}
