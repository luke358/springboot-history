import com.zhu.dao.StudentMapper;
import com.zhu.dao.TeacherMapper;
import com.zhu.pojo.Student;
import com.zhu.pojo.Teacher;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void TestStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();

        for (Student student1 : student) {

            System.out.println(student1);
        }
        sqlSession.close();
    }

    @Test
    public void TestStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();

        for (Student student1 : student) {

            System.out.println(student1);
        }
        sqlSession.close();
    }
}
