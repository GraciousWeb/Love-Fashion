package com.blog.fashionblog.models;

import jakarta.persistence.Column;

public enum Category {
    @Column(name = "category_name")
    MENS_FASHION("Men's Fashion"),

    @Column(name = "category_name")
    WOMENS_FASHION("Women's Fashion"),

    @Column(name = "category_name")
    CHILDRENS_FASHION("Children's Fashion"),

    @Column(name = "category_name")
    ACCESSORIES("Accessories");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

