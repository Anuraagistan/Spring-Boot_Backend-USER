package com.ritik.vo;

import com.ritik.payloads.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
  UserDto user;
  Animal animal;
}
