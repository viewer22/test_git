package com.devweb.test.dto.request;

import jakarta.validation.constraints.Size;

public class studentUpdateRequest {
    private String id;

    @Size(min = 2, message = "phải trên 2 chữ, ok?")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public studentUpdateRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public studentUpdateRequest() {
    }
}
