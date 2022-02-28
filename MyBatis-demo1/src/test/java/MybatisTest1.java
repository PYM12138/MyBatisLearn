import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest1 {
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


    @Test
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
            UserDao mapper = openSession.getMapper(UserDao.class);
            //4.使用(接口方法已经固定了返回值和形参，这样就不能随意更改类型了，防止出错)
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        } finally {
            //5.关闭资源
            assert openSession != null;
            openSession.close();
        }


    }
}
