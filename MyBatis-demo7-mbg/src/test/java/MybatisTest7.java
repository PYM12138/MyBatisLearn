import com.atguigu.bean.User;
import com.atguigu.bean.UserExample;
import com.atguigu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest7 {

    //对全局配置提取
    public SqlSessionFactory getSqlSession() {
        //1）、根据全局配置文件得到SqlSessionFactory；
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void TestMybatisRuntime(){
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = sqlSession.openSession();
        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            //查询 名字中包含有一个字，and电话号码有包含2
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andNameLike("%1%");
            criteria.andPhoneLike("%1%");
            //或者 名字叫做胡图图的
            UserExample.Criteria criteria1 = userExample.createCriteria();
            UserExample.Criteria nameEqualTo = criteria1.andNameEqualTo("胡图图");
            userExample.or(criteria1);

            List<User> users = mapper.selectByExample(userExample);
            for (User user : users) {
                System.out.println(user.getId());
            }

        }finally {
            openSession.close();
        }
    }



}
