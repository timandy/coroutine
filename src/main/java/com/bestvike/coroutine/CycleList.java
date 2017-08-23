package com.bestvike.coroutine;

import com.bestvike.linq.enumerator.AbstractEnumerator;
import com.bestvike.linq.exception.Errors;
import com.bestvike.linq.exception.InvalidOperationException;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class CycleList<TSource> extends AbstractEnumerator<CycleList.CycleEntry<TSource>> {
    private CycleEntry<TSource> head = new CycleEntry<>();//head 永不为 null

    private boolean isEmpty() {
        return this.head.prev == null || this.head.next == null;
    }

    public void add(TSource item) {
        if (item == null)
            throw Errors.argumentNull("item");
        if (this.isEmpty()) {
            this.head.item = item;
            this.head.prev = this.head;
            this.head.next = this.head;
            return;
        }
        CycleEntry<TSource> tail = this.head.prev;
        CycleEntry<TSource> entry = new CycleEntry<>();
        entry.item = item;
        entry.prev = tail;
        entry.next = this.head;
        //
        tail.next = entry;
        this.head.prev = entry;
    }

    @Override
    public void remove() {
        if (this.current == null)
            return;
        if (this.current.prev == null || this.current.next == null)//无效的
            return;
        if (this.current.prev == this.current.next) {//唯一的
            if (this.current != this.head)
                throw new InvalidOperationException("唯一元素,但不是 head");
            this.current.prev = null;
            this.current.next = null;
            this.current = null;
            return;
        }
        this.current.prev.next = this.current.next;
        this.current.next.prev = this.current.prev;
        this.current.prev = null;
        if (this.current == this.head)
            this.head = this.current.next;
    }

    @Override
    public boolean moveNext() {
        if (this.isEmpty()) {
            this.current = null;
            return false;
        }
        if (this.current == null) {
            this.current = this.head;
            return true;
        }
        this.current = this.current.next;
        return true;
    }

    static class CycleEntry<TSource> {
        TSource item;
        CycleEntry<TSource> prev;
        CycleEntry<TSource> next;
    }
}
