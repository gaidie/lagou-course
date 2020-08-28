package com.gai.baselearn.enums;


public enum UserRole {

    ROLE_ROOT_ADMIN,//系统管理员
    ROLE_ORDER_ADMIN,//订单管理员
    ROLE_NORMAL;//普通用户

    public static void main(String[] args) {
        UserRole roleOrderAdmin = UserRole.ROLE_ORDER_ADMIN;
        UserRole roleRootAdmin = UserRole.ROLE_ROOT_ADMIN;
        UserRole roleNormal = UserRole.ROLE_NORMAL;
        //values()方法 返回所有的枚举常量的数组集合
        for (UserRole userRole : UserRole.values()){
            System.out.println(userRole);
            System.out.println(userRole.name());
            System.out.println(userRole.ordinal());
        }
//        name()方法 获得枚举常量的名称

//        valueOf方法 返回指定名称的枚举常量
//        UserRole userRole = UserRole.valueOf("XXDDD");
//        if (userRole == null){
//            System.out.println("不存在。。。");
//        }
//        boolean wahhahah = UserRole.contains("WAHHAHAH");
        boolean wahhahah = UserRole.contains("ROLE_NORMAL");
        System.out.println("dedao " + wahhahah);
//        Assert.isTrue(wahhahah, "传入角色有误");

        System.out.println(UserRole.valueOf("ROLE_NORMAL"));
    }

    public static boolean contains(String name) {
        // 所有的枚举值
        UserRole[] userRoles = values();
        // 遍历查找
        for (UserRole role : userRoles) {
            if (role.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
