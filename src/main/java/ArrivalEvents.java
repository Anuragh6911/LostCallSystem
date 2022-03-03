import java.text.Normalizer;

public class ArrivalEvents {
    public int From;
    public int to;
    public int length;
    public int arrivalTime;

    public ArrivalEvents(int from, int to, int length, int arrivalTime) {
        From = from;
        this.to = to;
        this.length = length;
        this.arrivalTime = arrivalTime;
    }

    public int getFrom() {
        return From;
    }

    public int getTo() {
        return to;
    }

    public int getLength() {
        return length;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setFrom(int from) {
        From = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "ArrivalEvents{" +
                "From=" + From +
                ", to=" + to +
                ", length=" + length +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
