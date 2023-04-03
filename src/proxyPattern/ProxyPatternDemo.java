package proxyPattern;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyResource resourceForAdmin = new ProxyResource(Role.ADMIN);
        ProxyResource resourceForEmployee = new ProxyResource(Role.EMPLOYEE);
        System.out.println(resourceForAdmin.getResource());
        System.out.println(resourceForEmployee.getResource());
    }
}

interface Access {
    String getResource();
}

enum Role {
    ADMIN,
    EMPLOYEE
}

class ResourceAccess implements Access {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getResource() {
        return "Some Sort of Resource";
    }
}

class ProxyResource implements Access {
    Role role;
    public String grantAccess(Role role) {
        if(role == Role.ADMIN){
            ResourceAccess access = new ResourceAccess();
            return access.getResource();
        }else{
            return "You are not allowed to access resource";
        }
    }

    @Override
    public String getResource() {
        return grantAccess(role);
    }
    ProxyResource(Role role){
        this.role = role;
    }
}