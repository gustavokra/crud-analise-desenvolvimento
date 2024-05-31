package org.acme.domain.entities;

import java.time.LocalDateTime;

import org.acme.domain.entities.vo.CreatedAtVO;
import org.acme.domain.repositories.ICrudBO;

public class UserBO implements ICrudBO {

    private Long id;

    private String name;

    private String username;

    private String password;

    private CreatedAtVO createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime disabledAt;
    
    public UserBO(Long id, String name, String username, String password, CreatedAtVO createdAt,
            LocalDateTime updatedAt, LocalDateTime disabledAt) {
        this.id = id;
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

   

}
