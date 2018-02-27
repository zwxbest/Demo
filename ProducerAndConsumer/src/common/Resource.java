package common;

/**
 * User:zhangweixiao
 * Description:
 *
 */
public class Resource
{
    private String threadname;
    private String name;
    private String gender;

    public Resource(String threadname,String name,String gender)
    {
        this.setThreadname(threadname);
        this.setName(name);
        this.setGender(gender);
    }

    public String getThreadname() {
        return threadname;
    }

    public void setThreadname(String threadname) {
        this.threadname = threadname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}