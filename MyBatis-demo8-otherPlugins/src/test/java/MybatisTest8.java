import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest8 {
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
    public void  testPageHelp(){
        SqlSessionFactory sqlSession = getSqlSession();
        SqlSession openSession = sqlSession.openSession();
        //批量执行，单次设置，也可以去配置文件全局设置
        //SqlSession openSession1 = sqlSession.openSession(ExecutorType.BATCH);
        try{
            UserDao mapper = openSession.getMapper(UserDao.class);
            //第一个是参数是第几页，第二个参数是一页显示几条记录
            PageHelper.startPage(2, 1);
            List<User> allUser = mapper.getAllUser();
            //使用于网页的方法 例如:（详情使用可以去看pageHelper的github项目）
            //第二个参数是要连续显示多少页
            PageInfo<User> objectPageInfo = new PageInfo<>(allUser,5);
            for (User user : allUser) {
                System.out.println(user);
            }
            int pageNum = objectPageInfo.getPageNum();
            System.out.println("当前页是:"+pageNum);
            boolean isFirstPage = objectPageInfo.isIsFirstPage();
            System.out.println("是否是首页:"+isFirstPage);
            int[] navigatepageNums = objectPageInfo.getNavigatepageNums();
            System.out.println("当前设置连续显示的页数为:");
            for (int navigatepageNum : navigatepageNums) {
                System.out.println(navigatepageNum);
            }


        }finally {
            openSession.close();

        }
    }



}
