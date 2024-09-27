package com.example.UsersNews.valid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;
import com.example.UsersNews.different.PageFilter;

public class FilterValidValidator implements ConstraintValidator<PageFilterValid, PageFilter>{

//    @Override
//    public boolean isValid(PageFilter value, ConstraintValidatorContext context) {
//        if (ObjectUtils.anyNull(value.getNum(), value.getSize())) {
//            return false;
//        }
//        return (value.getUserId() != null || value.getThemeId() == null) && (value.getUserId() == null || value.getThemeId() != null);
//   }
//    @Override
//    public boolean isValid(PageFilter pf, ConstraintValidatorContext context)
//    {
//        return (pf.getNum() != null) && (pf.getThemeId() != null) && (pf.getSize() != null) && (pf.getUserId() != null);
//    }

    @Override
    public boolean isValid(PageFilter pf, ConstraintValidatorContext context)
    {
        return ((pf.getNum() != null)  && (pf.getSize() != null));
    }

}
