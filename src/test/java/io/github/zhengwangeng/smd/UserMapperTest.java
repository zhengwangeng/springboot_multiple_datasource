package io.github.zhengwangeng.smd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.zhengwangeng.smd.mapper.cluster.ClusterUserMapper;
import io.github.zhengwangeng.smd.mapper.master.MasterUserMapper;
import io.github.zhengwangeng.smd.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private ClusterUserMapper clusterUserMapper;

    @Autowired
    private MasterUserMapper masterUserMapper;

    @Test
    public void multipleDatasourceTest() throws Exception {
        User addUser = new User();
        addUser.setUserName("zhangsan");
        addUser.setPassword("123456!@#");
        addUser.setPhone("13800138000");

        clusterUserMapper.insert(addUser);

        masterUserMapper.insert(addUser);
        masterUserMapper.insert(addUser);

        {
            List<User> userAll = masterUserMapper.getAll();
            //List<UserModel> userAll = clusterUserMapper.selectList(null);
            System.out.println("master用户所有集合：" + userAll.size());

            User user = masterUserMapper.selectById(1);
            System.out.println("master用户：" + user.toString());
        }
        System.out.println("-------------------------------------- 我是分割线 ------------------------------------");
        {
            //List<UserModel> userAll = clusterUserMapper.getAll();
            List<User> userAll = clusterUserMapper.selectList(null);
            System.out.println("cluster用户所有集合：" + userAll.size());

            User user = clusterUserMapper.selectById(1);
            System.out.println("cluster用户：" + user.toString());
        }

    }
}