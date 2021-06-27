package com.xyz.actor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz.actor.entity.Actor;
import com.xyz.actor.query.ActorQuery;
import com.xyz.actor.service.ActorService;
import com.xyz.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-06-26
 */
@Api(tags = "演员相关操作接口")
@RestController
@RequestMapping("actor")
public class ActorController {

    //注入service field 注入有什么缺陷？为什么用set?
    @Autowired
    private ActorService actorService;


    @ApiOperation(value = "查询所有演员列表")
    @GetMapping("/findAll")
    public R findAllActor() {
        List<Actor> list = actorService.list(null);
        return R.ok().data("items",list);
    }

    @ApiOperation(value = "根据ID删除演员")
    @DeleteMapping("{id}")
    public R removeActor(@ApiParam(name = "id", value = "演员ID", required = true) @PathVariable String id) {
        boolean b = actorService.removeById(Long.valueOf(id));
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiModelProperty(value = "分页查询演员")
    @PostMapping("actor/{current}/{limit}")
    public R pageListActor(@PathVariable long current, @PathVariable long limit) {
        Page<Actor> actorPage = new Page<>(current, limit);
        //调用方法实现分页
        //调用方法时，底层封装，把分页所有的数据封装到 actorPage 对象里面
        actorService.page(actorPage, null);
        long total = actorPage.getTotal();
        List<Actor> records = actorPage.getRecords();
        return R.ok().data("total", total).data("list",records);
    }

    @ApiModelProperty(value = "带条件分页查询演员")
    @PostMapping("pageActorCondition/{current}/{limit}")
    public R pageActorCondition(@PathVariable long current, @PathVariable long limit,
                               @RequestBody(required = false) ActorQuery actorQuery) {
        Page<Actor> actorPage = new Page<Actor>(current, limit);
        //构建条件
        QueryWrapper<Actor> wrapper = new QueryWrapper<>();
        String name = actorQuery.getName();
        Integer level  = actorQuery.getLevel();
        String begin = actorQuery.getBegin();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level.toString())) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("create_time", begin);
        }
        actorService.page(actorPage, wrapper);
        long total = actorPage.getTotal();
        List<Actor> records = actorPage.getRecords();
        return R.ok().data("total", total).data("list",records);

    }

    @PostMapping("addActor")
    public R addActor(@RequestBody Actor actor) {
        boolean save = actorService.save(actor);
        if (save) {
            return R.ok().data("actor", actor);
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "根据ID查询演员")
    @GetMapping("getActorById/{id}")
    public R getActorById(@ApiParam(name = "id", value = "演员ID", required = true) @PathVariable Long id) {
        Actor actor = actorService.getById(id);
        if (actor != null) {
            return R.ok().data("actor",actor);
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "修改演员信息")
    @PostMapping("updateActor")
    public R updateActor(@RequestBody Actor actor) {
        int x = 10 / 0;
        boolean flag = actorService.updateById(actor);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

