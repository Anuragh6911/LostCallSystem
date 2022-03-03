public class CallInProcess {
    public int from=0;
    public int to=0;
    public int end=0;

    public CallInProcess(int from, int to, int end) {
        this.from = from;
        this.to = to;
        this.end = end;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getEnd() {
        return end;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CallInProcess{" +
                "from=" + from +
                ", to=" + to +
                ", end=" + end +
                '}';
    }
}
