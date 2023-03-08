package com.sutrix.demo.core.models.pageslink;

import com.sutrix.demo.core.models.navimage.NavImage;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Page.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageImpl implements Page {

    @Inject
    private String title;
    @Inject
    private String pageone;

    @Inject
    private String pagetwo;

    @Inject
    private String pagethree;

    @Inject
    private String pagefour;

    @Inject
    private String pagefive;

    @Inject
    private String pagesix;

    @Inject
    private String pageseven;

    @Inject
    private String pageeight;

    @Inject
    private String pagenine;

    @Inject
    private String pageten;

    @Inject
    private String pageleven;

    @Inject
    private String pagetowel;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getPageone() {
        return pageone;
    }

    @Override
    public String getPagetwo() {
        return pagetwo;
    }

    @Override
    public String getPagethree() {
        return pagethree;
    }

    @Override
    public String getPagefour() {
        return pagefour;
    }

    @Override
    public String getPagefive() {
        return pagefive;
    }

    @Override
    public String getPagesix() {
        return pagesix;
    }

    @Override
    public String getPageseven() {
        return pageseven;
    }

    @Override
    public String getPageeight() {
        return pageeight;
    }

    @Override
    public String getPagenine() {
        return pagenine;
    }

    @Override
    public String getPageten() {
        return pageten;
    }

    @Override
    public String getPageleven() {
        return pageleven;
    }

    @Override
    public String getPagetowel() {
        return pagetowel;
    }
}