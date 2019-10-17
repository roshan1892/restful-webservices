package com.roshanweb.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * Model class for PersonV1
 *
 * @Author RoshanBhandari
 * @Version 1.0.0
 * @since 2 Sep 2019
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("DynamicFilter")
public class SomeBean {
  private String field1;
  private String field2;
  @JsonIgnore
  private String field3;
  private String field4;
  private String field5;
}
