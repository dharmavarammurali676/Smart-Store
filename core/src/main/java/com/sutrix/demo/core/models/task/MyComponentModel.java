package com.sutrix.demo.core.models.task;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class MyComponentModel {

    @Inject
    private String text;

    @Inject
   // @Default(values = "-- Select --")
    private String[] options;

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        if (StringUtils.isBlank(text)) {
            return options;
        } else {
            return ArrayUtils.addAll(new String[]{"-- Select --", text}, options);
        }
    }
}
