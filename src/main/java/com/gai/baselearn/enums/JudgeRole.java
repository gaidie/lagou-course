package com.gai.baselearn.enums;

/**
 * @Author: xiaogai
 * @Description: todo
 * @Date:Create：in 2020/3/22 17:05
 * @Modified By：
 */
public class JudgeRole {

    public String judge(String roleName){
        return RoleEnum.valueOf(roleName).op();
    }

    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        System.out.println(judgeRole.judge("ROLE_ROOT_ADMIN"));
    }

}
