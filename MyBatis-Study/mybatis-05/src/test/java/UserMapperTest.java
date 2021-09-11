import com.zhu.dao.UserMapper;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);
      /*
              mapper.updateUser(new User(6,"test","1433223"));

              mapper.addUser(new User(6,"hello","admin"));

       List<User> users = mapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        User userById = mapper.getUserById(1);

        System.out.println(userById);*/

        sqlSession.close();
    }
}
