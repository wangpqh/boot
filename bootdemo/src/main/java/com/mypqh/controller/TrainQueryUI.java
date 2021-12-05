package com.mypqh.controller;

import com.alibaba.druid.util.TransactionInfo;
import com.mypqh.common.Result;
import com.mypqh.common.train.TrainQueryReq;
import com.mypqh.common.train.TrainQueryRsp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainQueryUI {

    @CrossOrigin
    @PostMapping("api/train/query")
    @ResponseBody
    public Result<TrainQueryRsp> queryTrain(@RequestBody TrainQueryReq req) {
        System.out.print(req.toString());
        Result<TrainQueryRsp> result = new Result();
        result.setResultCode("200");
        result.setResultDetail("success");
        result.setResultData("");
        return result;
    }
}
