package com.atguigu.sparsearray;


public class SparseArray {
    public static void main(String[] args) {
        //1、创建一个原始的二维数组
        //1表示白子，2表示蓝子
        int chassArr1[][] = new int[11][11];
        chassArr1[1][2] = 1;
        chassArr1[2][3] = 2;
        for (int[] ints : chassArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }

            System.out.println();
        }
        //2、将二维数组转为稀疏数组的思路
        // 2、1 先遍历数组，获取非0的数据
        int num = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chassArr1[i][j] != 0) {
                    num++;
                }
            }
        }
        //2、2创建对应的稀疏数组
        int[][] sparseArr = new int[num + 1][3];
        //给稀疏数组的第一行赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=num;
         //遍历二维数组，给稀疏数组赋值
        int count=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chassArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chassArr1[i][j];

                }
            }
        }
        //输出稀疏数组的形式为
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        for (int i = 0; i <sparseArr.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //3、将稀疏数组恢复成二维数组
         //3、1 先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int chassArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        //3、2 在读取稀疏数组第二行以后的数据，并赋值给原始数组
        for (int i = 1; i <sparseArr.length ; i++) {
            chassArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int[] ints : chassArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}