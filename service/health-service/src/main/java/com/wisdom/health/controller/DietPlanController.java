package com.wisdom.health.controller;

import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.core.ResponseDTO;
import com.wisdom.common.dto.health.DietPlanDTO;
import com.wisdom.health.interceptor.LoginRequired;
import com.wisdom.health.service.DietPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 饮食记录
 *
 * @author 张博
 * @date 2017年5月25日
 */
@Controller
@RequestMapping(value = "diet")
public class DietPlanController {

    private static Lock lock = new ReentrantLock();

    @Autowired
    private DietPlanService dietPlanService;

    /**
     * 用户的所有的饮食记录
     * @return
     */
    @RequestMapping(value = "getAllDietPlan", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<DietPlanDTO>> getAllDietPlan(@RequestBody DietPlanDTO dietPlanDTO) {
        List<DietPlanDTO> list=dietPlanService.getAllDietPlan(dietPlanDTO.getElderUserID());
        ResponseDTO<List<DietPlanDTO>> ResponseDTO = new ResponseDTO<>();
        ResponseDTO.setResponseData(list);
        ResponseDTO.setResult(StatusConstant.SUCCESS);
        ResponseDTO.setErrorInfo(StatusConstant.DIET_ERROR);
        return ResponseDTO;
    }

    /**
     * 用户的所有的饮食记录
     * @return
     */
    @RequestMapping(value = "getDietPlanByDate", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<DietPlanDTO>> getDietPlanByDate(@RequestBody DietPlanDTO dietPlanDTO) {
        List<DietPlanDTO> list=dietPlanService.getAllDietPlanByDate(dietPlanDTO);
        ResponseDTO<List<DietPlanDTO>> ResponseDTO = new ResponseDTO<>();
        ResponseDTO.setResponseData(list);
        ResponseDTO.setResult(StatusConstant.SUCCESS);
        ResponseDTO.setErrorInfo(StatusConstant.DIET_ERROR);
        return ResponseDTO;
    }


    /**
     *  新增饮食记录
     * @return
     */
    @RequestMapping(value = "insertDietPlan", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO insertDietPlan(@RequestBody DietPlanDTO dietPlanDTO) {
        Integer re=dietPlanService.insertDietPlan(dietPlanDTO);
        ResponseDTO ResponseDTO = new ResponseDTO<>();
        ResponseDTO.setResult(StatusConstant.SUCCESS);
        ResponseDTO.setErrorInfo(StatusConstant.DIET_ERROR);
        return ResponseDTO;
    }

    /**
     *  获取一条饮食记录
     * @return
     */
    @RequestMapping(value = "getDietPlan", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO getDietPlan(@RequestBody DietPlanDTO dietDTO) {
        DietPlanDTO dietPlanDTO=dietPlanService.getDietPlan(dietDTO.getId());
        ResponseDTO ResponseDTO = new ResponseDTO<>();
        ResponseDTO.setResponseData(dietPlanDTO);
        ResponseDTO.setResult(StatusConstant.SUCCESS);
        ResponseDTO.setErrorInfo(StatusConstant.DIET_ERROR);
        return ResponseDTO;
    }

}
