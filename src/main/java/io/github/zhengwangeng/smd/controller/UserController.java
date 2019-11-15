package io.github.zhengwangeng.smd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.zhengwangeng.smd.mapper.cluster.ClusterUserMapper;
import io.github.zhengwangeng.smd.mapper.master.MasterUserMapper;
import io.github.zhengwangeng.smd.model.User;

/**
 * 用户控制层
 * TODO 这里注入注入Mapper只是为了简单测试多数据源，实际使用时应注入Service
 */
@RestController
public class UserController {

    @Autowired
    private MasterUserMapper masterUserMapper;

    @Autowired
    private ClusterUserMapper clusterUserMapper;

    /************************主库控制层接口-start******************************/
    @RequestMapping("user/master/all")
    public List<User> getMasterAllUser() {
        return masterUserMapper.getAll();
    }

    /************************主库控制层接口-end******************************/


    /************************从库控制层接口-start******************************/
    @RequestMapping("user/cluster/all")
    public List<User> getClusterAllUser() {
        return clusterUserMapper.getAll();
    }


    /************************从库控制层接口-end******************************/
}
