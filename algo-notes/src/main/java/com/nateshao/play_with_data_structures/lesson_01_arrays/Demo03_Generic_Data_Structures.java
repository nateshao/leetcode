package com.nateshao.play_with_data_structures.lesson_01_arrays;

/**
 * @date Created by 邵桐杰 on 2021/10/31 11:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo03_Generic_Data_Structures {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.add(1, 100);// [0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.addFirst(-1); // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2); // [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.removeElement(4); // [-1, 0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(arr);

        arr.removeFirst(); // [0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(arr);
    }

    public static class Array<E> {
        private E[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array
        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        // 无参数的构造函数，默认数组的容量capacity=10
        public Array() {
            this(10);
        }

        // 获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        public int getCat() {
            return data.length;
        }

        // 获取数组中的元素个数
        public int getSize() {
            return size;
        }

        public int getSizes() {
            return size;
        }

        // 返回数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isEn() {
            return size == 0;
        }

        // 在index索引的位置插入一个新元素e
        public void add(int index, E e) {

            if (size == data.length)
                throw new IllegalArgumentException("Add failed. Array is full.");

            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

            for (int i = size - 1; i >= index; i--)
                data[i + 1] = data[i];

            data[index] = e;

            size++;
        }

        // 向所有元素后添加一个新元素
        public void addLast(E e) {
            add(size, e);
        }

        // 在所有元素前添加一个新元素
        public void addFirst(E e) {
            add(0, e);
        }

        // 获取index索引位置的元素
        public E get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        // 修改index索引位置的元素为e
        public void set(int index, E e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            data[index] = e;
        }

        // 查找数组中是否有元素e
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e))
                    return true;
            }
            return false;
        }

        // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e))
                    return i;
            }
            return -1;
        }

        // 从数组中删除index位置的元素, 返回删除的元素
        public E remove(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");

            E ret = data[index];
            for (int i = index + 1; i < size; i++)
                data[i - 1] = data[i];
            size--;
            data[size] = null; // loitering objects != memory leak
            return ret;
        }

        // 从数组中删除第一个元素, 返回删除的元素
        public E removeFirst() {
            return remove(0);
        }

        // 从数组中删除最后一个元素, 返回删除的元素
        public E removeLast() {
            return remove(size - 1);
        }

        // 从数组中删除元素e
        public void removeElement(E e) {
            int index = find(e);
            if (index != -1)
                remove(index);
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }
    }


}
