package com.example.UsersNews.aop;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Err.CheckUserException;
import com.example.UsersNews.Service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckAspect {

    private final ItemsService itemsService;



    @Before(value = "@annotation(CheckingIt) && args(idItem, ownerId)", argNames = "joinPoint,idItem,ownerId")
    public void CheckPointcut(JoinPoint joinPoint, Integer idItem, Integer ownerId) {
        itemsService.checkIt(idItem, ownerId);
              joinPoint.getSignature().getName();
    }

    @Before(value = "@annotation(CheckingIt) && args(item, ownerId)", argNames = "joinPoint,ownerId,item")
    public void CheckPointcutPut(JoinPoint joinPoint, Integer ownerId, Item item) {
        itemsService.CheckUpd(item, ownerId);
        joinPoint.getSignature().getName();
    }

}
