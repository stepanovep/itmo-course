package module1.message.model;

/**
 * Created by xmitya on 17.10.16.
 */
public enum MessagePriority {
    LOW,
    MEDIUM,
    HIGH,
    URGENT;

    public static MessagePriority fromOrdinal(int ord) {
        for (MessagePriority mp : values()) {
            if (ord == mp.ordinal())
                return mp;
        }

        throw new AssertionError("Wrong ordinal: " + ord);
    }
}
