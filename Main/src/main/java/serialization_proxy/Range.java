package serialization_proxy;

import java.io.Serializable;

/**
 Represents inclusive integer range.
 */
class Range implements Serializable {

    private static final long serialVersionUID = 1L;

    /** @serial */
    private final int from;
    /** @serial */
    private final int to;

    /**
     * Creates Range.
     *
     * @param from start
     * @param to end
     * @throws IllegalArgumentException if start is greater than end.
     */
    public Range(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private static class SerializationProxy
            implements Serializable {

        int mX; int mY;
        public SerializationProxy() { }
        public SerializationProxy(Range range) {
            mX = range.getFrom();  mY = range.getTo();
        }
        Object readResolve() {
            return new Range(mX, mY);
        }
    }
}