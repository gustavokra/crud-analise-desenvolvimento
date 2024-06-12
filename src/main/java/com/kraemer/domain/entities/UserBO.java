package com.kraemer.domain.entities;

import java.time.LocalDateTime;

import com.kraemer.domain.entities.vo.CreatedAtVO;
import com.kraemer.domain.repositories.ICrudBO;
import com.kraemer.domain.utils.StringUtil;

public class UserBO implements ICrudBO {

    private Long id;

    private String document;

    private String name;

    private String username;

    private String password;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;

    public UserBO(Long id, String document, String name, String username, String password,
            CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.disabledAt = disabledAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public CreatedAtVO getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public String getDocument() {
        return document;
    }

    public void handleDisable() {
        this.disabledAt = LocalDateTime.now();
    }

    public void handleUpdateInfo(UserBO userBO) {
        if (StringUtil.isNotNullOrEmpty(userBO.getName()) && !userBO.getName().equalsIgnoreCase(this.name)) {
            this.name = userBO.getName();
        }

        if (StringUtil.isNotNullOrEmpty(userBO.getDocument()) && !userBO.getDocument().equalsIgnoreCase(this.document)) {
            this.document = userBO.getDocument();
        }

        if (StringUtil.isNotNullOrEmpty(userBO.getUsername()) && !userBO.getUsername().equalsIgnoreCase(this.username)) {
            this.username = userBO.getUsername();
        }

        if (StringUtil.isNotNullOrEmpty(userBO.getPassword()) && !userBO.getPassword().equalsIgnoreCase(this.password)) {
            this.password = userBO.getPassword();
        }

        this.updatedAt = LocalDateTime.now();
    }

}
