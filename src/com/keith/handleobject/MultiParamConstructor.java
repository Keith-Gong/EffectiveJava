package com.keith.handleobject;

import java.lang.reflect.Method;

/**
 * Created by Keith on 10/2/15.
 *
 * 1.Telescope constructor
 * 2.JavaBean setter
 * 3.Builder
 *
 * */
public class MultiParamConstructor {
    public static void main (String args[]) {
        Method3 method3 = new Method3.Builder(1,2).setVar3(3).setVar4(4).setVar5(5).build();
    }
}

/**
 * Telescope constructor
 */
class Method1 {
    private final int var1;
    private final int var2;
    private final int var3;
    public Method1(int var1, int var2, int var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }
    public Method1(int var1) {
        this(var1, 0, 0);
    }
}

/**
 * Javabean
 */
class Method2 {
    private int var1;
    private int var2;
    private int var3;
    public Method2 () {}
    public void setVar1 (int var1) {
        this.var1 = var1;
    }
    public void setVa2 (int var2) {
        this.var2 = var2;
    }
    public void setVar3 (int var3) {
        this.var3 = var3;
    }
}

/**
 * Builder
 */
class Method3 {
    //required
    private final int var1;
    private final int var2;
    private int i = 0;

    //optional
    private final int var3;
    private final int var4;
    private final int var5;

    public static class Builder {
        private final int var1;
        private final int var2;

        private int var3 = 0;
        private int var4 = 0;
        private int var5 = 0;

        public Builder (int var1, int var2) {
            this.var1 = var1;
            this.var2 = var2;
        }

        public Builder setVar3 (int var3) {
            this.var3 = var3;
            return this;
        }
        public Builder setVar4 (int var4) {
            this.var4 = var4;
            return this;
        }
        public Builder setVar5 (int var5) {
            this.var5 = var5;
            return this;
        }

        public Method3 build () {
            return new Method3(this);
        }
    }

    private Method3 (Builder builder) {
        var1 = builder.var1;
        var2 = builder.var2;
        var3 = builder.var3;
        var4 = builder.var4;
        var5 = builder.var5;
    }
}
