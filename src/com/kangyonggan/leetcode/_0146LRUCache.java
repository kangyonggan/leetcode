package com.kangyonggan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author kyg
 */
public class _0146LRUCache {

    private class LinkNode {
        int key;
        int value;
        LinkNode prev;
        LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkNode> map;
    private LinkNode head;
    private LinkNode tail;
    private int capacity;

    public static void main(String[] args) {
        _0146LRUCache cache = new _0146LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        System.out.println(111);
    }

    public _0146LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        if (node == null) {
            LinkNode linkNode = new LinkNode(key, value);
            map.put(key, linkNode);
            addToHead(linkNode);

            if (map.size() > capacity) {
                LinkNode rmNode = removeNode(tail.prev);
                map.remove(rmNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LinkNode removeNode(LinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    private void addToHead(LinkNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }


}
