package module1.message.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by xmitya on 17.10.16.
 */
public class MessageGenerator {

    public List<Message> generate(int num) {
        if (num <= 0)
            return Collections.emptyList();

        Random rnd = new Random();

        List<Message> messages = new ArrayList<>(num);

        int typesCnt = MessagePriority.values().length;

        for (int i = 0; i < num; i++) {
            messages.add(new Message(MessagePriority.fromOrdinal(rnd.nextInt(typesCnt)), rnd.nextInt(10)));
        }

        return messages;
    }
}
