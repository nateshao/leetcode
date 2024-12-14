package com.nateshao.play_with_data_structures.lesson_01_arrays;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/9/6 10:56
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Demo02_Create_Our_Own_Array {
    public static void main(String[] args) {
        Array arr = new Array(30);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.addLast(1);
        System.out.println(arr);

    }

    static class Array {
        private int[] data;
        private int size;

        /**
         * 构造函数，传入数组的容量capacity构造Array
         *
         * @param capacity
         */
        public Array(int capacity) {
            data = new int[capacity];
            size = 0;
        }

        /**
         * 无参的构造函数，默认数组的容量capacity=10
         */
        public Array() {
            this(10);
        }

        /**
         * 获取数组中的元素个数
         *
         * @return
         */
        public int getSize() {
            return size;
        }

        /**
         * 判断数组是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 向所有元素后添加一个新元素
         *
         * @param e
         */
        public void addLast(int e) {
            if (size == data.length) {
                throw new IllegalArgumentException("addLast failed, Array is full");
            }
            data[size] = e;
            size++;
        }

        /**
         * 在所有元素前添加一个新元素
         *
         * @param e
         */
        public void addFirst(int e) {
            add(0, e);
        }

        // 在index索引的位置插入一个新元素e
        public void add(int index, int e) {
            if (size == data.length)
                throw new IllegalArgumentException("addLast failed, Array is full");
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
                data[index] = e;
                size++;
            }
        }

        @Override
        public String toString() {
            return "Array{" +
                    "data=" + Arrays.toString(data) +
                    ", size=" + size +
                    '}';
        }


        int get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("addLast failed, Array is full");
            return data[index];
        }

        void set(int index, int e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("addLast failed, Array is full");
            data[index] = e;
        }

        /**
         * 查找数组中是否有元素e
         *
         * @param e
         * @return
         */
        public boolean contains(int e) {
            for (int i = 0; i < size; i++) {
                if (data[i] == e) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
         *
         * @param e
         * @return
         */
        public int find(int e) {
            for (int i = 0; i < size; i++) {
                if (data[i] == e) {
                    return i;
                }
            }
            return -1;
        }

        public int remove(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            int ret = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
                size--;

            }
            return ret;
        }

        // 从数组中删除第一个元素, 返回删除的元素
        public int removeFirst(){
            return remove(0);
        }

        // 从数组中删除最后一个元素, 返回删除的元素
        public int removeLast(){
            return remove(size - 1);
        }

        // 从数组中删除元素e
        public void removeElement(int e){
            int index = find(e);
            if(index != -1)
                remove(index);
        }
    }
}
