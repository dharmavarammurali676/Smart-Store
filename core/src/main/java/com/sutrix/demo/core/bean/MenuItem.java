package com.sutrix.demo.core.bean;

import java.util.List;

/**
 * This is to define fields and methods to access the menu items.
 */
public class MenuItem {

  private String title;
  private String path;
  private List<MenuItem> children;

  /**
   * @param title the title of item.
   * @param path the item path.
   */
  public MenuItem(String title, String path) {
    this.title = title;
    this.path = path;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * @param path the path to set
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * @return the children
   */
  public List<MenuItem> getChildren() {
    return children;
  }

  /**
   * @param children the children to set
   */
  public void setChildren(List<MenuItem> children) {
    this.children = children;
  }

}
