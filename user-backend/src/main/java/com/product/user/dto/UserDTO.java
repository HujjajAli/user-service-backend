package com.product.user.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	
	
	private Long userId;
	private String name;
	private String email;
	private String mobileNumber;
	private String password;
	
	
	private Date createDate;
	private String createdBy;
	private Date lastModifiedDate;
	private String modifiedBy;
	private List<RoleDTO> roles;
	

}
