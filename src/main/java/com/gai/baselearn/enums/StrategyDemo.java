package com.gai.baselearn.enums;

/**
 * @Author: xiaogai
 * @Description: todo
 * @Date:Create：in 2020/3/22 17:10
 * @Modified By：
 */
public class StrategyDemo {

    public enum Calculator {

        ADDITION {
            @Override
            public Double execute(Double x, Double y) {
                return x + y; // 加法
            }
        },

        SUBTRACTION {
            @Override
            public Double execute(Double x, Double y) {
                return x - y; // 减法
            }
        },

        MULTIPLICATION {
            @Override
            public Double execute(Double x, Double y) {
                return x * y; // 乘法
            }
        },


        DIVISION {
            @Override
            public Double execute(Double x, Double y) {
                return x / y;  // 除法
            }
        };

        public abstract Double execute(Double x, Double y);
    }

    public static void main(String[] args) {
        System.out.println( Calculator.ADDITION.execute( 4.0, 2.0 ) );
        // 打印 6.0
        System.out.println( Calculator.SUBTRACTION.execute( 4.0, 2.0 ) );
        // 打印 2.0
        System.out.println( Calculator.MULTIPLICATION.execute( 4.0, 2.0 ) );
        // 打印 8.0
        System.out.println( Calculator.DIVISION.execute( 4.0, 2.0 ) );
        // 打印 2.0
    }

}
