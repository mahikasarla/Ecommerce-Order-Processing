package com.example.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author MahenderKasarla
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@CreatedDate
	@Column(name = "created_date")
	private Date createdDate;

	@LastModifiedBy
	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
}