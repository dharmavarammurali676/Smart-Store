package com.sutrix.demo.core.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.sutrix.demo.core.bean.MenuItem;

/**
 * This is to use to get all menu items.
 */
public class NavigationComponent extends WCMUsePojo {

  List<MenuItem> menuItems = null;

  @Override
  public void activate() throws Exception {

    final Page rootPage = getCurrentPage().getAbsoluteParent(getCurrentStyle().get("absParent", 2));
    if (rootPage != null) {
      
      menuItems = new ArrayList<>();
      menuItems.add(new MenuItem(getTitle(rootPage), rootPage.getPath()));

      Iterator<Page> children = rootPage.listChildren();
      while (children.hasNext()) {
        Page page = children.next();
        if (page != null) {
          MenuItem menuItem = new MenuItem(getTitle(page), page.getPath());
          List<MenuItem> childItems = getChildren(page);
          if (!childItems.isEmpty()) {
            menuItem.setChildren(childItems);
          }
          menuItems.add(menuItem);
        }
      }
    }
  }
  
  /**
   * Gets all child pages by {@link Page}.
   * @param page a parent page.
   * @return list of {@link MenuItem} if found. Otherwise return {@code null}.
   */
  private List<MenuItem> getChildren(Page page) {
    
    List<MenuItem> childItems = new ArrayList<>();
    Iterator<Page> children = page != null ? page.listChildren() : null;
    if (children == null || !children.hasNext()) {
      return childItems;
    }
    
    while (children.hasNext()) {
      Page childPage = children.next();
      if (childPage != null) {
        childItems.add(new MenuItem(getTitle(childPage), childPage.getPath()));
      }
    }
    
    return childItems;
  }

  private String getTitle(Page page) {
    String title = "";
    if (page == null) {
      return title;
    }

    title = page.getTitle();
    if ("".equals(title)) {
      title = page.getPageTitle();
      if ("".equals(title)) {
        title = page.getNavigationTitle();
        if ("".equals(title)) {
          title = page.getName();
        }
      }
    }

    return title;
  }

  /**
   * @return the menuItems
   */
  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

}
