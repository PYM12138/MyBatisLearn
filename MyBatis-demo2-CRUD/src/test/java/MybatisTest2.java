import com.atguigu.bean.User;
import com.atguigu.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTest2 {
    /*
     * sqlSession代表和数据库的一次会话，用完要关闭
     * sqlSession和Connection一样是非线程安全的，所以每次使用应该要去获取新的对象
     * */

    /*使用方式:
    * 1.实体类
    * 2.mybatis-config.xml
    * 3.对应的Mapper.xml(这里面写sql语句，然后注册到mybatis-config，完成映射。)
    * 4.写hallo.mybatis
      		1）、根据全局配置文件得到SqlSessionFactory；
      		2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
      			一个sqlSession就是代表和数据库的一次会话，用完关闭
     		3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
     * */

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


   /* @Test
    public void test1() throws IOException {
        //1）、根据全局配置文件得到SqlSessionFactory；
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
//        一个sqlSession就是代表和数据库的一次会话，用完关闭

        // 2、获取sqlSession实例，能直接执行已经映射的sql语句
        // sql的唯一标识：statement Unique identifier matching the statement to use.
        // 执行sql要用的参数：parameter A parameter object to pass to the statement.

        SqlSession openSession = sqlSessionFactory.openSession();

        //3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
        try {
            User user = openSession.selectOne(
                    "com.atguigu.bean.User.getEmpById", 2);
            System.out.println(user);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void Test2() {
        //1.获取全局配置
        SqlSessionFactory sqlSession = getSqlSession();
        //2.通过openSession()方法获取对象
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            //3.获取接口的实现类对象(getMapper自动为接口创建代理对象，然后就可以直接使用接口方法)
            //该方式有一个前提就是需要将接口和mapper.xml动态绑定。
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            //4.使用(接口方法已经固定了返回值和形参，这样就不能随意更改类型了，防止出错)
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        } finally {
            //5.关闭资源
            assert openSession != null;
            openSession.close();
        }


    }*/


    @Test
    public void Test3() {//CRUD
        /*
        * 1.默认是手动提交(开启自动提交:openSession(true))
        * 2.允许增删改之后自动包装返回值类型:Integer,Long,Boolean
        * */
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            /*User userById = userMapper.getUserById(6);
            System.out.println(userById);*/
           User user = new User(null,"胡图图","123456","翻斗花园","13755053302");
            Boolean aBoolean = userMapper.addUser(user);
            System.out.println("当前自增主键值是:"+user.getId());
            /*User user = new User(6,"牛爷爷","123456","翻斗花园","13755053302");
            Boolean aBoolean = userMapper.updateUser(user);*/
//            Boolean aBoolean = userMapper.deleteUser(6);
            System.out.println(aBoolean);


            //默认是要手动提交
            openSession.commit();

        } finally {
            assert openSession != null;
            openSession.close();
        }


    }

    @Test
    public void Test4() {//命名参数,传入多个参数的处理方法

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User user = userMapper.getUserByIdAndName(1, "章子怡");
            System.out.println(user);

        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test5() {//POJO,自动把POJO的属性映射查询条件的属性

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User user = new User(1,"章子怡","null",null,null);
            User userByUser = userMapper.getUserByUser(user);
            System.out.println(userByUser);

        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test6() {//返回一个List集合，类型是User

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            List<User> usersLikeName = userMapper.getUsersLikeName("%图");
            for (User u : usersLikeName) {
                System.out.println(u);
            }


        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test7() {//返回一个Map集合，键值对是String Object

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            Map<String, Object> userByIdMap = userMapper.getUserByIdMap(1);

            System.out.println(userByIdMap);

        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test8() {//返回一个Map集合，里面包含多条数据，key是当前记录的id，value是User对象

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            Map<Integer, User> userByNameMap = userMapper.getUserByNameMap("胡%");
            System.out.println(userByNameMap);


        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test9() {//自定义结果映射集

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            User userById = userMapper.getUserById1(1);
            System.out.println(userById);


        } finally {
            assert openSession != null;
            openSession.close();
        }


    }
    @Test
    public void Test10() {//map集合指定param属性名

        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = null;
        try {
            openSession = sqlSession.openSession();
            UserMapper userMapper = openSession.getMapper(UserMapper.class);
            Map<String,Object> map=new HashMap<>();
            map.put("id",7);
            map.put("name","胡图图");
            User userByMap = userMapper.getUserByMap(map);
            System.out.println(userByMap);


        } finally {
            assert openSession != null;
            openSession.close();
        }


    }

}
