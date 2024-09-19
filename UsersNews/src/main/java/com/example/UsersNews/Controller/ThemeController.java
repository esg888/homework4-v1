package com.example.UsersNews.Controller;
import com.example.UsersNews.Entity.Theme;
import com.example.UsersNews.Mapper.ThemeMapper;
import com.example.UsersNews.Service.ThemeService;
import com.example.UsersNews.different.PageFilter;
import com.example.UsersNews.web.ThemeListResponse;
import com.example.UsersNews.web.ThemeRequest;
import com.example.UsersNews.web.ThemeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;
    private final ThemeMapper themeMapper;

    @GetMapping
    public ResponseEntity<ThemeListResponse> findAll(@Valid PageFilter pageFilter){
        List<Theme> themes = themeService.findAll(pageFilter);
        return ResponseEntity.ok(themeMapper.themeListResponseList(themes));
    }

    @GetMapping("/{id}")
    public  ResponseEntity <ThemeResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(themeMapper.themeToResponse(themeService.findById(id)));
            }
    @PostMapping
    public  ResponseEntity <ThemeResponse> create (@RequestBody ThemeRequest request){
        Theme theme = themeService.save(themeMapper.requestToTheme(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(themeMapper.themeToResponse(theme));
    }

    @PutMapping("/{id}")
    public  ResponseEntity <ThemeResponse> update(@PathVariable("id") Integer themeId,
                                                  @RequestBody ThemeRequest request) {
Theme uTheme = themeService.update(themeMapper.requestToTheme(themeId, request));
        return ResponseEntity.ok(themeMapper.themeToResponse(uTheme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
themeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
