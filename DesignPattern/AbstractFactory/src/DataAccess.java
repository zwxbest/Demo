public class DataAccess
    {
        private static  String AssemblyName = "抽象工厂模式";
        private static  String db = "Sqlserver";
        //private static readonly string db = "Access";

        public static IUser CreateUser()
        {
            String className = AssemblyName + "." + db + "User";
            //使用反射
            return null;
        }

        public static IDepartment CreateDepartment()
        {
            String className = AssemblyName + "." + db + "Department";
            //使用反射
            return null;
        }
    }