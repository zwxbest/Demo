public class Main {

    public static void main(String[] args) {
        User user = new User();
        Department dept = new Department();

        IUser iu = DataAccess.CreateUser();

        iu.Insert(user);
        iu.GetUser(1);

        IDepartment id = DataAccess.CreateDepartment();
        id.Insert(dept);
        id.GetDepartment(1);

    }
}
