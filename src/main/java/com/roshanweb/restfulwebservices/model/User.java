package com.roshanweb.restfulwebservices.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

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
@ApiModel(description = "Validations about the fields of a user.")
public class User {
  private int id;
  @Size(min = 2, message = "Name should have at least two characters.")
  @ApiModelProperty(notes = "The name must be at least of two characters.")
  private String name;
  @Past
  @ApiModelProperty(notes = "The birth date must be before of present date.")
  private Date birthDate;
}
