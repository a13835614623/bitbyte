package com.zzk.bitbyte.service;

public interface SubscribeService {
    String USER_ID_NOT_BLANK = "用户id不能为空!";
    String SUBSCRiBER_ID_NOT_BLANK = "关注者id不能为空!";

    /**
     * 取消关注
     *
     * @param userId       操作用户的ID
     * @param subscriberId 被取关的用户ID
     */
    void removeSubscribe(String userId,
                         String subscriberId) throws Exception;

    /**
     * 关注
     *
     * @param userId       操作用户的ID
     * @param subscriberId 被关注的用户ID
     */
    void subscribe(String userId,
                   String subscriberId) throws Exception;

    /**
     * 是否关注
     *
     * @param userId       操作用户的ID
     * @param subscriberId 判断用户的ID
     */
    boolean isSubscribe(String userId,
                        String subscriberId) throws Exception;
}
