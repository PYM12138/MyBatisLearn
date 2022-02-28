import com.atguigu.bean.User;
import com.atguigu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest5 {

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


//    @Test
//    public void Test1() {//一级缓存
//        /*
//        * 一级缓存失效的四种情况：
//        * 1.sqlSession不同
//        * 2.sqlSession相同，查询条件不同
//        * 3.sqlSession相同，但两次查询期间执行了增删改操作
//        * 4.sqlSession相同，手动执行了缓存情况操作 clearCache()
//        *
//        * */
//        SqlSessionFactory sqlSession = getSqlSession();
//        SqlSession openSession = null;
//        try {
//            openSession = sqlSession.openSession();
//            UserMapper userMapper = openSession.getMapper(UserMapper.class);
//            User user = new User(1, null, null, null, null);
//            List<User> userIf = userMapper.getUserIf(user);
//            for (User user1 : userIf) {
//                System.out.println(user1);
//            }
//
//        } finally {
//            assert openSession != null;
//            openSession.close();
//        }
//
//    }


    @Test
    public void Test2() {//二级缓存 又叫全局缓存
        /*
        * 使用:1.在mybatis-config setting标签中设置<cacheEnabled> 默认是true，但是也要显示开启，防止有一天默认为false了
        *     2.在mapper.xml的<mapper> 标签下设置<cache>标签
        *     3.对应的接口要实现序列化接口
        * 二级缓存:工作机制
        *       0.首先一个会话查询一条数据，当前的数据就会保存在一级缓存中
        *       1.如果会话关闭，一级缓存会保存在二级缓存中，新的会话查询信息，会首先去查找缓存
        *       2.一个namespace对应一个二级缓存，所以不同的mapper.xml对应的二级缓存都不同
        *       3.缓存使用是在不同的sqlSession之间的，要先使用然后关闭一个sqlSession才会有。另外一个sqlSession查询数据会先去缓存中查找
        *       （前提是同一个nameSpace下）
        *
        *
        *  对应标签的缓存属性设置：
        *       1.cacheEnabled=true;  false:关闭二级缓存（一级缓存不受影响）
        *       2.每个select 标签都有useCache="true" false:不使用二级缓存(一级缓存不受影响)
        *       3.每个增删改标签都有flushCache="true" (一、二级缓存全部清除)，select标签也有但是默认是false
        *       4.sqlSession.clearCache();此方法只清楚当前session的一级缓存
        *       5.mybatis 3.3.x以后的版本 有localCacheScope ：本地缓存作用域 默认值是SESSION,
        *                 可选值STATEMENT表示不共享一级缓存，也就是关闭
        *
        *
        */

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        SqlSession openSession1 = sqlSession.openSession();
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            UserMapper mapper = openSession1.getMapper(UserMapper.class);
            User user = userMapper.getUser(1);
            System.out.println(user);
            openSession.close();
            User user1 = mapper.getUser(1);
            System.out.println(user1);
            openSession1.close();


        } finally {
            assert openSession != null;
            openSession.close();
        }

    }




}
