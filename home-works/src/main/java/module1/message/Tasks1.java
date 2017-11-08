package module1.message;


import module1.message.model.Message;
import module1.message.model.MessageGenerator;
import module1.message.model.MessagePriority;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xmitya on 17.10.16.
 */
public class Tasks1 {

    private static final int N = 40;

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(N);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        System.out.println("Generated messages: \n" + messages + "\n");
        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages) + "\n");

        removeEach(generator.generate(N), MessagePriority.LOW);
        removeOther(generator.generate(N), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        for (MessagePriority priority: MessagePriority.values()) {
            System.out.println(messages.stream()
                    .filter(msg -> msg.getPriority() == priority)
                    .count());
        }
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.

        Set<Integer> uniqueMessageCodes = messages
                .stream()
                .map(Message::getCode)
                .collect(Collectors.toSet());

        for (int code: uniqueMessageCodes) {
            int codeCount = 0;
            for (Message message: messages) {
                if (message.getCode() == code) {
                    codeCount++;
                }
            }
            System.out.println("Code " + code + ": " + codeCount);
        }
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.

        System.out.println("number of unique messages: " + new HashSet<>(messages).size());
    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.

        return new LinkedList<>(new LinkedHashSet<>(messages));
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);

        messages = messages
                .stream()
                .filter(msg -> msg.getPriority() != priority)
                .collect(Collectors.toList());

        System.out.printf("After remove each: %s, %s\n", priority, messages);
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);

        messages = messages
                .stream()
                .filter(msg -> msg.getPriority() == priority)
                .collect(Collectors.toList());

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
