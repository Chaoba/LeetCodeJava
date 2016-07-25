package com.mushuichuan;

/**
 * Created by Liyanshun on 2016/7/25.
 */
public class HeapSort {
    void heapfy(int[] k, int size, int root) {
        //find the biggest value in root's children
        int leftChild = root * 2 + 1;
        int rightChild = 2 * (root + 1);
        int newRoot = root;
        if (leftChild < size && k[leftChild] > k[newRoot]) {
            newRoot = leftChild;
        }
        if (rightChild < size && k[rightChild] > k[newRoot]) {
            newRoot = rightChild;
        }
        if (newRoot != root) {
            //move the biggest child to root
            swap(k, root, newRoot);
            //continue heapfy the child that switched with root before.
            heapfy(k, size, newRoot);
        }
    }

    void swap(int[] k, int i, int j) {
        int temp = k[i];
        k[i] = k[j];
        k[j] = temp;
    }

    void buildHeap(int[] k) {
        if (k.length < 2) {
            return;
        }
        int mid = k.length >> 1;
        //from the last node that is not a leaf, since all leaf node can be seen as a heap
        for (int i = mid - 1; i >= 0; i--) {
            heapfy(k, k.length, i);
        }
    }

    public void heapSort(int[] k) {
        buildHeap(k);
        int size = k.length;
        for (int i = size - 1; i > 0; i--) {
            swap(k, 0, i);
            heapfy(k, --size, 0);
        }

    }
}
