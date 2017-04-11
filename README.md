# Vaadin I18N Design

Transformation pipeline to deal with translations in Vaadin Design files.

## Supported transformations

### Single attribute

Request a translation for the key given in any `i18n:<attr>` attribute.  The default is the value of the `<attr>` attribute.

```html
<... i18n:caption="key" caption="default" .../>
```

### Multiple attributes at once

For each word in `i18n:attributes` request a translation for the word prefixed with `key.` provided in `i18n:key`.  The default is the value of the attribute of that name.

```html
<... i18n:key="key" i18n:attributes="caption placeholder" caption="default" placeholder="default" .../>
```

### Text tag

Replace the whole tag with the translation for the key from `i18n:key`.  The default is the `.text()` of the tag.

```html
<i18n:text i18n:key="key">default</i18n:text>
```
