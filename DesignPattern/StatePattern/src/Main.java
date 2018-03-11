public class Main {

    public static void main(String[] args) {
        //紧急项目
        Work emergencyProjects = new Work();
        emergencyProjects.setHour(9);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(10);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(12);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(13);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(14);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(17);

        //emergencyProjects.WorkFinished = true;
        emergencyProjects.setTaskFinished(false);

        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(19);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(22);
        emergencyProjects.WriteProgram();

    }
}
