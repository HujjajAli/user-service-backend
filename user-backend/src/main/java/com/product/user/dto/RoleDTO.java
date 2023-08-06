package com.product.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
	
	private Long roleId;
	private String roleCode;
	private String roleDescription;
	
	private long createDate;
	private String createdBy;
	private long lastModifiedDate;
	private String modifiedBy;
	

}
