package com.tree;

import lombok.Data;

@Data

public class BinaryNode<E extends Comparable<E>> {
    private E data;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E data) {
        this(data, null, null);
    }

    public BinaryNode(final E data, final BinaryNode<E> left, final BinaryNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void insert(final E data) {
        if (this.data.compareTo(data) == 0) {
            return;
        }
        if (this.data.compareTo(data) > 0) {
            if (this.right == null) {
                this.right = new BinaryNode<>(data);
            } else {
                this.right.insert(data);
            }
        } else {
            if (this.left == null) {
                this.left = new BinaryNode<>(data);
            } else {
                this.left.insert(data);
            }
        }

    }

    public StringBuilder prefix(final StringBuilder sb) {
        sb.append(this.data).append("");
        if (this.left != null) sb.append(this.left.prefix(sb));
        if (this.right != null) sb.append(this.right.prefix(sb));

        return sb;

    }

    public StringBuilder infix(final StringBuilder sb) {
        if (this.left != null) sb.append(this.left.infix(sb));
        sb.append(this.data).append("");
        if (this.right != null) sb.append(this.right.infix(sb));

        return sb;

    }

    public StringBuilder posfix(final StringBuilder sb) {
        if (this.left != null) sb.append(this.left.posfix(sb));
        if (this.right != null) sb.append(this.right.posfix(sb));
        sb.append(this.data).append("");

        return sb;

    }
}
