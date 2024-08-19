package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.Theme;
import com.example.UsersNews.Err.EntityNotFoundException;
import com.example.UsersNews.Repo.ThemeJPA;
import com.example.UsersNews.Repo.ThemeRepo;
import com.example.UsersNews.util.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ThemeService implements ThemeRepo {

    private ThemeJPA themeJPA;

    @Override
    public List<Theme> findAll() {
        return themeJPA.findAll();
    }

    @Override
    public Theme findById(Integer id) {
        return themeJPA.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID {0} не найден", id)));
    }

    @Override
    public Theme save(Theme theme) {
        return themeJPA.save(theme);
    }

    @Override
    public Theme update(Theme theme) {
        Theme eTheme = findById(theme.getId());
        BeanUtils.copyNonNullProperties(theme, eTheme);
         return themeJPA.save(eTheme);
    }

    @Override
    public void delete(Integer id) {
        themeJPA.deleteById(id);
    }
}
