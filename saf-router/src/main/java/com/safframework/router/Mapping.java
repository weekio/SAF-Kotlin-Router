package com.safframework.router;

import android.app.Activity;

/**
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.safframework.router.Mapping.java
 * @author: Tony Shen
 * @date: 2018-03-28 15:30
 */
public class Mapping {

    private String format;
    private Class<? extends Activity> activity;
    private RouterParameter.RouterOptions options;
    private MethodInvoker method;
    private MatchType matchType;

    public Mapping(String format,Class<? extends Activity> activity,RouterParameter.RouterOptions options,MethodInvoker method) {

        if (format == null) {
            throw new RouterException("format can not be null");
        }
        this.format = format;
        this.activity = activity;
        this.options = options;
        this.method = method;

        if (format.toLowerCase().startsWith("http://") || format.toLowerCase().startsWith("https://")) {
            matchType = MatchType.BROWSER;
        } else if (format.contains("://")) {
            matchType = MatchType.SCHEME;
        } else {
            matchType = MatchType.PATH_ACTITY;
        }
    }

    public String getFormat() {
        return format;
    }

    public Class<? extends Activity> getActivity() {
        return activity;
    }

    public RouterParameter.RouterOptions getOptions() {
        return options;
    }

    public MethodInvoker getMethod() {
        return method;
    }
}
