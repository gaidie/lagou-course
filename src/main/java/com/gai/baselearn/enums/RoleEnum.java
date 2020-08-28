package com.gai.baselearn.enums;

public enum RoleEnum implements RoleOperation {
    ROLE_ROOT_ADMIN{
        /**
         * 表示某个角色可以做哪些OP操作
         *
         * @return
         */
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN:" + " has AAA permission";
        }
    },
    ROLE_ORDER_ADMIN{
        /**
         * 表示某个角色可以做哪些OP操作
         *
         * @return
         */
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN:" + " has BBB permission";
        }
    },
    ROLE_NORMAL{
        /**
         * 表示某个角色可以做哪些OP操作
         *
         * @return
         */
        @Override
        public String op() {
            return "ROLE_NORMAL:" + " has CCC permission";
        }
    },
    ;
}
