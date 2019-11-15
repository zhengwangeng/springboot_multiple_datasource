package io.github.zhengwangeng.smd.mapper.cluster;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import io.github.zhengwangeng.smd.model.User;

public interface ClusterUserMapper extends BaseMapper<User> {

    /**
     * 获取全部用户数据
     *
     * @return List<UserModel> 用户列表
     */
    List<User> getAll();
}
