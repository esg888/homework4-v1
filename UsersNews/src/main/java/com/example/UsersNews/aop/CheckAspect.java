package com.example.UsersNews.aop;

import com.example.UsersNews.Service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckAspect {

    private final ItemsService itemsService;
//    private final Integer idItem;
//    private final Integer idOw;


//    @Pointcut("@annotation(CheckingIt)")
//    public void CheckPointcut(){
//    }



    @Before(value = "execution(*ItemsService.delete(Integer itemId, Integer ownerId)) && args(itemId, ownerId)")
    public void CheckPointcut(JoinPoint joinPoint, Integer idItem, Integer ownerId) {
        itemsService.checkIt(idItem, ownerId);
    }


}
