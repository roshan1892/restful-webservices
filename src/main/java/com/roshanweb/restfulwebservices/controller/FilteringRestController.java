package com.roshanweb.restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.roshanweb.restfulwebservices.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FilteringRestController responsible for performing filtration on Restful web services
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@RestController
public class FilteringRestController {

  /**
   * method responsible for performing static filtering on object,throws out "Value3" as we have put @JsonIgnore on model class
   *
   * @author RoshanBhandari
   * @version 1.0.0
   * @since 2 Sep 2019
   */
  @GetMapping("/static-filtering")
  public SomeBean staticFiltering() {
    return new SomeBean("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");
  }

  /**
   * method responsible for performing dynamic filtering on object,throws out "Value1","Value2","Value3"
   *
   * @author RoshanBhandari
   * @version 1.0.0
   * @since 2 Sep 2019
   */
  @GetMapping("/dynamic-filtering")
  public MappingJacksonValue dynamicFiltering() {

    SomeBean someBean = new SomeBean("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field4", "field5");
    FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
    MappingJacksonValue mapping = new MappingJacksonValue(someBean);

    mapping.setFilters(filterProvider);
    return mapping;
  }

}
