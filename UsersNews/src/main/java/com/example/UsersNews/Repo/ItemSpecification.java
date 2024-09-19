package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.different.PageFilter;
import org.springframework.data.jpa.domain.Specification;

public interface ItemSpecification {

    static Specification<Item> byUserId(Integer userId) {
        return ((root, query, criteriaBuilder) -> {
            if (userId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("user").get("id"), userId);
        });
    }

    static Specification<Item> byThemeId(Integer themeId) {
        return ((root, query, criteriaBuilder) -> {
            if (themeId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("theme").get("id"), themeId);
        });
    }

    static Specification<Item> withFilter (PageFilter pageFilter)
    {
        return Specification.where(byThemeId(pageFilter.getThemeId())).
                and(byUserId(pageFilter.getUserId()));
    }
}

