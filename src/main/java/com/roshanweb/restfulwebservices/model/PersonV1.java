package com.roshanweb.restfulwebservices.model;

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
public class PersonV1 {
  private String name;
}
