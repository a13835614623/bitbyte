package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.service.ReadHistoryService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zzk
 * @Date: 2020-04-06 10:55
 */
@RestController
@RequestMapping("/action/read")
public class ReadHistoryController {

    @Autowired
    private ReadHistoryService readHistoryService;

    /**
     * 关注用户
     * @param userId    用户ID
     * @param articleId 文章ID
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public ResponseState read(@RequestParam("userId") String userId,
                                   @RequestParam("articleId") String articleId) throws Exception {
        readHistoryService.addReadHistory(articleId, userId);
        ResponseState state = new ResponseState();
        state.setStatus(ResponseState.STATUS_SUCCESS);
        state.setMessage("添加浏览记录成功!");
        return state;
    }
}
