package com.google.api.client.repackaged.com.google.common.base;

import com.google.errorprone.annotations.*;
import javax.annotation.*;

@Deprecated
public static final class ToStringHelper
{
    private final String className;
    private final ValueHolder holderHead;
    private ValueHolder holderTail;
    private boolean omitNullValues;
    
    private ToStringHelper(final String a1) {
        super();
        this.holderHead = new ValueHolder();
        this.holderTail = this.holderHead;
        this.omitNullValues = false;
        this.className = Preconditions.checkNotNull(a1);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, @Nullable final Object a2) {
        return this.addHolder(a1, a2);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final boolean a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final char a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final double a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final float a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final int a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(final String a1, final long a2) {
        return this.addHolder(a1, String.valueOf(a2));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(@Nullable final Object a1) {
        return this.addHolder(a1);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final boolean a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final char a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final double a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final float a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final int a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(final long a1) {
        return this.addHolder(String.valueOf(a1));
    }
    
    @Override
    public String toString() {
        final boolean omitNullValues = this.omitNullValues;
        String s = "";
        final StringBuilder v0 = new StringBuilder(32).append(this.className).append('{');
        for (ValueHolder v2 = this.holderHead.next; v2 != null; v2 = v2.next) {
            if (!omitNullValues || v2.value != null) {
                v0.append(s);
                s = ", ";
                if (v2.name != null) {
                    v0.append(v2.name).append('=');
                }
                v0.append(v2.value);
            }
        }
        return v0.append('}').toString();
    }
    
    private ValueHolder addHolder() {
        final ValueHolder v1 = new ValueHolder();
        final ValueHolder holderTail = this.holderTail;
        final ValueHolder valueHolder = v1;
        holderTail.next = valueHolder;
        this.holderTail = valueHolder;
        return v1;
    }
    
    private ToStringHelper addHolder(@Nullable final Object a1) {
        final ValueHolder v1 = this.addHolder();
        v1.value = a1;
        return this;
    }
    
    private ToStringHelper addHolder(final String a1, @Nullable final Object a2) {
        final ValueHolder v1 = this.addHolder();
        v1.value = a2;
        v1.name = Preconditions.checkNotNull(a1);
        return this;
    }
    
    ToStringHelper(final String a1, final Objects$1 a2) {
        this(a1);
    }
    
    private static final class ValueHolder
    {
        String name;
        Object value;
        ValueHolder next;
        
        private ValueHolder() {
            super();
        }
        
        ValueHolder(final Objects$1 a1) {
            this();
        }
    }
}
