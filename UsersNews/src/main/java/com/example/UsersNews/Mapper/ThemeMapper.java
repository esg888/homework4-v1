package com.example.UsersNews.Mapper;

import com.example.UsersNews.Entity.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.UsersNews.web.ThemeListResponse;
import com.example.UsersNews.web.ThemeRequest;
import com.example.UsersNews.web.ThemeResponse;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ItemMapper.class})
public interface ThemeMapper {

    Theme requestToTheme(ThemeRequest request);

    @Mapping(source = "themeId", target = "id")
    Theme requestToTheme(Integer themeId, ThemeRequest request);

    ThemeResponse themeToResponse(Theme theme);

    default ThemeListResponse themeListResponseList (List<Theme> themes) {
        ThemeListResponse response = new ThemeListResponse();
        response.setThemes(themes.stream().map(this::themeToResponse).collect(Collectors.toList()));
        return response;
    }
}
