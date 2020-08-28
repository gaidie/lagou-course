package com.gai.baselearn.enums;

public enum UserRoleCode {
    ROLE_ROOT_ADMIN("ROLE_ROOT_ADMIN", 00000),
    ROLE_ORDER_ADMIN("ROLE_ORDER_ADMIN", 100000),
    ROLE_NORMAL("ROLE_ORDER_ADMIN", 200000);

    UserRoleCode(String roleName, Integer roleCode) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    private final String roleName;

    private final Integer roleCode;

    public String getRoleName() {
        return roleName;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public static Integer getRoleCodeByName(String roleName){
        for (UserRoleCode roleCode : UserRoleCode.values()){
            if (roleCode.getRoleName().equals(roleName)){
                return roleCode.getRoleCode();
            }
        }
        return null;
    }
}
