package com.xyz.actor.service.impl;

import com.xyz.actor.entity.Actor;
import com.xyz.actor.mapper.ActorMapper;
import com.xyz.actor.service.ActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-06-26
 */
@Service
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements ActorService {

}
