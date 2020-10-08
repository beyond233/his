package com.beyond233.his.controller;

import com.beyond233.his.entity.Drug;
import com.beyond233.his.service.impl.DrugServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档: 药品控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-15 23:32
 */
@Controller
@RequestMapping("/drug")
public class DrugController {
    @Resource
    DrugServiceImpl drugService;

    /**
     * 通过id获取对应药品数据
     **/
    @ResponseBody
    @GetMapping("/{id}")
    public Drug getDrugById(@PathVariable int id) {
        return drugService.findDrugById(id);
    }

    /**
     * 获取所有药品信息
     **/
    @ResponseBody
    @GetMapping("/all")
    public Map<String, Object> getAllDrugs() {
        List<Drug> drugs = drugService.findAllDrug();
        Map<String, Object> map = new HashMap<>(100);
        map.put("code", 0);
        map.put("message", "");
        map.put("total", drugs.size());
        map.put("data", drugs);
        return map;
    }

    /**
     * 分页获取药品信息
     **/
    @ResponseBody
    @GetMapping("/limit")
    public Map<String, Object> getDrugsByPageLimit(int page, int limit) {
        //数据总数
        int count = drugService.findAllDrug().size();
        PageHelper.startPage(page, limit);
        List<Drug> drugs = drugService.findAllDrug();
        Map<String, Object> map = new HashMap<>(10);
        map.put("code", 0);
        map.put("message", "");
        map.put("count", count);
        map.put("data", drugs);
        return map;
    }

    /**
     * 添加药品
     **/
    @ResponseBody
    @PostMapping("/add")
    public String addDrug(Drug drug) {
        try {
            drugService.addDrug(drug);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    /**
     * 删除药品
     **/
    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
    }

    /**
     * 批量删除药品
     **/
    @ResponseBody
    @DeleteMapping("/deleteMore")
    public String deleteMoreDrug(int[] ids) {
        try {
            for (int id : ids) {
                drugService.deleteDrug(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";

    }

    /**
     * 修改药品
     **/
    @PutMapping("/{id}")
    public void updateDrug(@RequestBody Drug drug, @PathVariable int id) {
        drug.setDrugId(id);
        drugService.updateDrug(drug);
    }
}
