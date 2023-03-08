package com.sutrix.demo.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

/**
 * The Carousel Model
 */
@Model(adaptables = Resource.class)
public class CarouselModel {

  // Inject the products node under the current node
  /**
   * The carousel items
   */
  @Inject
  @Optional
  public Resource carousels;

}
