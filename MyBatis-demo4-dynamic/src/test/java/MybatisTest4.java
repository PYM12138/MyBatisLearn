
import com.atguigu.bean.User;

import com.atguigu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MybatisTest4 {

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
    public void Test1() {//动态查询之IF条件  IF&WHERE&TRIM
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User user = new User(1, null, null, null, null);
            List<User> userIf = userMapper.getUserIf(user);
            for (User user1 : userIf) {
                System.out.println(user1);
            }

        } finally {
            assert openSession != null;
            openSession.close();
        }

    }
    @Test
    public void Test2() {
        //动态查询之choose 要么情况1要么情况2否则就怎么样（如果同时满足情况1和情况2，则取情况1的结果），
        // 不会像IF一样，sql语句拼接在一起
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User user = new User(null, null, null, null, null);
            List<User> userChoose = userMapper.getUserChoose(user);
            for (User user1 : userChoose) {
                System.out.println(user1);
            }

        } finally {
            assert openSession != null;
            openSession.close();
        }

    }
    @Test
    public void Test3() { //SET标签 =update语句

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User user = new User(7, "null", null, null, null);
            userMapper.updateUser(user);
            openSession.commit();


        } finally {
            assert openSession != null;
            openSession.close();
        }

    }
    @Test

    public void Test4() {//查询多条数据并返回
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            List<User> userCollection = userMapper.getUserCollection(Arrays.asList(1, 2, 3));

            for (User user : userCollection) {
                System.out.println(user);
            }


        } finally {
            assert openSession != null;
            openSession.close();
        }

    }

    @Test
    public void Test5() {//插入多条数据并返回boolean

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            ArrayList<User> list = new ArrayList<>();
            User user1 = new User(null, "我是你", "123312", "fandouhuayuan", "15012623302");
            User user2 = new User(null, "我是你", "123312", "fandouhuayuan", "15012623302");
            list.add(user1);
            list.add(user2);

            boolean b = userMapper.insertUsersList(list);
            System.out.println(b);

            openSession.commit();
        } finally {
            assert openSession != null;
            openSession.close();
        }

    }
    @Test
    public void Test6() {//SQL动态之Bind标签
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            List<User> tu = userMapper.getUserBind(new User(null, "我", null, null, null));
            System.out.println(tu);


        } finally {
            assert openSession != null;
            openSession.close();
        }

    }


}
