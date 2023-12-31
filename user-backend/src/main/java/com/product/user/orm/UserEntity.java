package com.product.user.orm;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Audited
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String fullname;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(length = 13)
	private String mobileNumber;
	private String password;
	private Date expiryDate;
	
	@CreatedDate
	private long createDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private long lastModifiedDate;
	@LastModifiedBy
	private String modifiedBy;
	
	private String gender;
	private Date dateOfBirth;
	
	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(name = "userId"),
	        inverseJoinColumns = @JoinColumn(name = "roleId")
	    )
	    private List<RoleEntity> roles;

}
