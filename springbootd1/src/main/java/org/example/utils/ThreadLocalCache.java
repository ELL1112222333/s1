package org.example.utils;

import org.example.entity.User;

/**
 * 线程独占 保存哟用户信息
 * 每次结束需要手动清除
 */
public class ThreadLocalCache {

    private static final ThreadLocal<User> USER_INFO_IN_TOKEN_HOLDER = new ThreadLocal<>();

    public static User get() {
        return USER_INFO_IN_TOKEN_HOLDER.get();
    }


    public static User forceGet() {
        return USER_INFO_IN_TOKEN_HOLDER.get();
    }

    public static void set(User userInfoInTokenBo) {
        USER_INFO_IN_TOKEN_HOLDER.set(userInfoInTokenBo);
    }

    public static void clean() {
        if (USER_INFO_IN_TOKEN_HOLDER.get() != null) {
            USER_INFO_IN_TOKEN_HOLDER.remove();
        }
    }
}
